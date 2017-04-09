package platform.game;

import platform.util.*;

/**
 * Class name: Spikes.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 28/11/2016 at 2:45 PM
 **/
public class Spikes extends Actor
{
    double cooldown;
    Vector position;
    Box box;
    double angle;
    final static double SIZE = 0.5;

    /**
     * constructor of class spikes
     *
     * @param position the position of the spikes
     * @param cooldown the time to pass in order for the spikes to affect damage to the player for the second time
     */
    public Spikes(Vector position, double cooldown)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        this.cooldown = cooldown;
        box = getBox();
        angle = 0;
    }

    /**
     * constructor of the class spikes with the angle attribute
     *
     * @param position the position of the spikes
     * @param cooldown the time to pass in order for the spikes to affect damage to the player for the second time
     * @param angle    the angle in which the spikes will be drawn
     */
    public Spikes(Vector position, double cooldown, double angle)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        this.cooldown = cooldown;
        box = getBox();
        this.angle = angle;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        cooldown -= input.getDeltaTime();
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(cooldown <= 0 && getBox().isColliding(other.getBox()))
        {
            Vector below = new Vector(position.getX(), position.getY() - 1.0);
            if(other.getVelocity().getY() < -1)
            {
                if(other.hurt(this, Damage.PHYSICAL, 1, below))
                    cooldown = 0.5;
            }
            else
            {
                if(other.hurt(this, Damage.PHYSICAL, 0.5, below))
                    cooldown = 1;
            }
        }
    }

    @Override
    public int getPriority()
    {
        return 45;
    }

    @Override
    public Vector getPosition()
    {
        return position;
    }

    @Override
    public Box getBox()
    {
        return new Box(position, SIZE, SIZE);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("spikes.png"), getBox(), angle);
    }
}
