package platform.game.Characters;

import platform.game.Actor;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

import static platform.game.Characters.Mob.Direction.RIGHT;

/**
 * Class name: Frog.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 07/12/2016 at 14:32
 **/
public class Frog extends Mob
{
    private double cooldown;
    private Direction direction;
    private double cooldownStill;

    /**
     * Create a new Frog
     *
     * @param position  initial position
     * @param velocity  initial velocity
     * @param health    initial health
     * @param maxhealth maximal value of health
     * @param size      of the Frog
     * @param side      of the Frog
     * @param category  of the Frog
     * @param direction initial direction of the Frog
     */
    public Frog(Vector position, Vector velocity, double health, double maxhealth, double size, Side side, Category category, Direction direction)
    {
        super(position, velocity, health, maxhealth, size, side, category);
        cooldown = 0;
        this.direction = direction;
        cooldownStill = 0;
        setBaseValue(1.0);
    }

    @Override
    public int getPriority()
    {
        return 50;
    }

    @Override
    public void draw(Input input, Output output)
    {
        String name = "";
        if(direction == Direction.LEFT)
        {
            if(cooldownStill > 0)
            {
                name = "frog.left.png";
            }
            else if(getHealth() <= 0)
            {
                name = "frog.left.dead.png";
            }
            else
            {
                name = "frog.left.leap.png";
            }
        }
        else if(direction == Direction.RIGHT)
        {
            if(cooldownStill > 0)
            {
                name = "frog.right.png";
            }
            else if(getHealth() <= 0)
            {
                name = "frog.right.dead.png";
            }
            else
            {
                name = "frog.right.leap.png";
            }
        }
        output.drawSprite(getSprite(name), getBox());

    }

    @Override
    public void interact(Actor other)
    {
        if(other.isSolid())
        {
            Vector delta = other.getBox().getCollision(getBox());
            if(delta != null)
            {
                setColliding(true);
                setPosition(position.add(delta));
                if(cooldownStill <= 0)
                {
                    if(delta.getX() != 0.0)
                    {
                        if(delta.getX() > 0)
                        {
                            direction = Direction.RIGHT;
                            setVelocity(new Vector(4, velocity.getY()));
                        }
                        else if(delta.getX() < 0)
                        {
                            direction = Direction.LEFT;
                            setVelocity(new Vector(-4, velocity.getY()));
                        }
                    }
                    if(delta.getY() != 0.0)
                    {
                        setVelocity(new Vector(velocity.getX(), 0));
                        if(delta.getY() > 0)
                        {
                            cooldownStill = 2;
                        }

                    }
                }
                else
                {
                    setVelocity(new Vector(0, 0));
                }

            }
            if(other.getBox().isColliding(getBox()))
            {
                if(cooldown <= 0 && this.getSide() != other.getSide())
                {
                    if(other.hurt(this, Damage.PHYSICAL, modifyDamageInflicted(getBaseValue()), getPosition()))
                    {
                        cooldown = 1;
                    }
                }
            }
        }
        else if(other.getBox().isColliding(getBox()))
        {
            if(cooldown <= 0 && this.getSide() != other.getSide())
            {
                if(other.hurt(this, Damage.PHYSICAL, modifyDamageInflicted(getBaseValue()), getPosition()))
                {
                    cooldown = 1;
                }
            }
        }
    }

    @Override
    public void update(Input input)
    {
        cooldown -= input.getDeltaTime();
        cooldownStill -= input.getDeltaTime();
        double delta = input.getDeltaTime();
        if(cooldownStill <= 0 && velocity.getY() == 0)
        {
            if(direction == Direction.RIGHT && velocity.getX() == 0)
            {
                setVelocity(new Vector(4, 6));
            }
            else if(direction == Direction.LEFT && velocity.getX() == 0)
            {
                setVelocity(new Vector(-4, 6));
            }
        }
        setVelocity(getVelocity().add(getWorld().getGravity().mul(delta)));
        setPosition(getPosition().add(getVelocity().mul(delta)));
        checkLife();
    }

    @Override
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        if(this.getSide() != instigator.getSide())
        {
            double value;
            switch(type)
            {
                case VOID:
                    setHealth(0);
                    return true;
                case FIRE:
                    value = modifyDamageTaken(amount);
                    setHealth(getHealth() - value);
                    return true;
                case WATER:
                    value = modifyHeal(amount);
                    setHealth(getHealth() + value);
                    if(getHealth() > getMaxhealth())
                    {
                        setHealth(getMaxhealth());
                    }
                    return true;
                default:
                    return super.hurt(instigator, type, amount, location);
            }
        }
        return super.hurt(instigator, type, amount, location);
    }

}
