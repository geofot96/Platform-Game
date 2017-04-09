package platform.game.Characters;

import platform.game.Actor;
import platform.game.Characters.Character;
import platform.game.End;
import platform.game.Fireball;
import platform.game.Waterball;
import platform.game.level.Level;
import platform.util.*;

import java.awt.event.KeyEvent;

/**
 * Class name: Player.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 26/11/2016 at 3:19 PM
 **/
public class Player extends Character
{
    final static double SIZE = 0.5;

    /**
     * constructor of class Player
     *
     * @param position  the initial position of the player
     * @param velocity  the initial velocity of the player
     * @param health    health of the player
     * @param maxhealth health of the player
     */
    public Player(Vector position, Vector velocity, double health, double maxhealth)
    {
        super(position, velocity, health, maxhealth, SIZE, Side.ALLIED);
    }

    @Override
    public int getPriority()
    {
        return 42;
    }

    @Override
    public void draw(Input input, Output output)
    {
        if(getHealth() == 0)
            output.drawSprite(getSprite("blocker.dead.png"), getBox());
        else if(getHealth() <= 2)
            output.drawSprite(getSprite("blocker.sad.png"), getBox());
        else
            output.drawSprite(getSprite("blocker.happy.png"), getBox());

    }

    /**
     * method responsible for the method of the player, depending on different keys being pushed from the keyboard
     *
     * @param input
     */
    @Override
    public void update(Input input)
    {
        super.update(input);
        double delta = input.getDeltaTime();
        double maxSpeed = 10.0;
        if(getColliding())
        {
            double scale = Math.pow(0.001, input.getDeltaTime());
            setVelocity(getVelocity().mul(scale));
        }
        if(input.getKeyboardButton(KeyEvent.VK_RIGHT).isDown())
        {
            if(getVelocity().getX() < maxSpeed)
            {
                double increase = 20.0 * input.getDeltaTime();
                double speed = getVelocity().getX() + increase;
                if(speed > maxSpeed)
                    speed = maxSpeed;
                setVelocity(new Vector(speed, getVelocity().getY()));
            }
        }
        else if(input.getKeyboardButton(KeyEvent.VK_LEFT).isDown())
        {
            if(-getVelocity().getX() < maxSpeed)
            {
                double increase = 20.0 * input.getDeltaTime();
                double speed = getVelocity().getX() - increase;
                if(-speed > maxSpeed)
                    speed = -maxSpeed;
                setVelocity(new Vector(speed, getVelocity().getY()));
            }
        }
        if(input.getKeyboardButton(KeyEvent.VK_UP).isPressed())
        {
            if(getColliding())
            {
                setVelocity(new Vector(getVelocity().getX(), 7.0));
            }
        }
        setVelocity(getVelocity().add(getWorld().getGravity().mul(delta)));
        setPosition(getPosition().add(getVelocity().mul(delta)));
        if(input.getKeyboardButton(KeyEvent.VK_SPACE).isPressed())
        {
            Vector v = getVelocity().add(getVelocity().resized(2.0));
            Fireball fireball = new Fireball(getPosition(), v, this);
            getWorld().register(fireball);
        }
        if(input.getKeyboardButton(KeyEvent.VK_W).isPressed())
        {
            Vector v1 = getVelocity().add(getVelocity().resized(2.0));
            Waterball waterball = new Waterball(getPosition(), v1, this);
            getWorld().register(waterball);
        }
        if(input.getKeyboardButton(KeyEvent.VK_B).isPressed())
            getWorld().hurt(getBox(), this, Damage.AIR, 1.0, getPosition());
        if(input.getKeyboardButton(KeyEvent.VK_E).isPressed())
            getWorld().hurt(getBox(), this, Damage.ACTIVATION, 1.0, getPosition());
        if(getHealth() <= 0)
        {
            getWorld().setNextLevel(new Level().createDefaultLevel());
            End end = new End(1);
            getWorld().register(end);
        }
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
    }

    @Override
    public void postUpdate(Input input)
    {
        getWorld().setView(getPosition(), 8.0);
    }

    @Override
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        switch(type)
        {
            case AIR:
                if(instigator != this)
                {
                    setVelocity(getPosition().sub(location).resized(amount));
                    return true;
                }
                return true;

            case VOID:
                setHealth(0);
                return true;
            case HEAL:
                setHealth(getHealth() + amount);
                if(getHealth() >= getMaxhealth())
                    setHealth(getMaxhealth());
                return true;
            case PHYSICAL:
                setHealth(getHealth() - amount);
                if(getHealth() <= 0)
                    setHealth(0);
                return true;
            default:
                return super.hurt(instigator, type, amount, location);
        }
    }
}
