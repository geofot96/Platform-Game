package platform.game.Characters;

import platform.game.Actor;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: Fly.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 10/12/2016 at 16:21
 **/
public class Fly extends Mob
{
    private Direction direction;
    private double cooldown;
    private double variation;

    /**
     * constructor of the class Fly
     *
     * @param position  the initial position of the fly
     * @param velocity  the initial velocity of the fly
     * @param health    the initial health of the fly
     * @param maxhealth maxhealth of the fly
     * @param size      size of the fly
     * @param side      side of the fly
     * @param category  category of the fly
     * @param direction direction of the fly
     */
    public Fly(Vector position, Vector velocity, double health, double maxhealth, double size, Side side, Category category, Direction direction)
    {
        super(position, velocity, health, maxhealth, size, side, category);
        this.direction = direction;
        cooldown = 0;
        variation = 0;
        setBaseValue(1.0);
    }

    @Override
    public int getPriority()
    {
        return 51;
    }

    @Override
    public void draw(Input input, Output output)
    {
        String name = "";
        if(direction == Direction.LEFT)
        {
            if(variation < 0.05)
            {
                name = "fly.left.1.png";
            }
            else
            {
                name = "fly.left.2.png";
            }
        }
        else if(direction == Direction.RIGHT)
        {
            if(variation < 0.05)
            {
                name = "fly.right.1.png";
            }
            else
            {
                name = "fly.right.2.png";
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
        super.update(input);
        cooldown -= input.getDeltaTime();
        double delta = input.getDeltaTime();
        variation -= input.getDeltaTime();
        if(variation < 0.0)
        {
            variation = 0.1;
        }
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
                default:
                    return super.hurt(instigator, type, amount, location);
            }
        }
        return super.hurt(instigator, type, amount, location);
    }
}
