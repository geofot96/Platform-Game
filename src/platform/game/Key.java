package platform.game;

import platform.game.Signals.Signal;
import platform.util.*;

/**
 * Class name: Key.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:21 AM
 **/
public abstract class Key extends Actor implements Signal
{
    boolean taken;
    Vector position;
    final static double SIZE = 0.5;


    /**
     * constructor of class key, initializes it's position attribute to specific value and the signal taken to false
     *
     * @param position the position of the key
     */
    public Key(Vector position)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        taken = false;
    }

    @Override
    public boolean isActive()
    {
        return taken;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        if(isActive())
        {
            getWorld().unregister(this);
        }
    }

    @Override
    public void interact(Actor other)
    {
        if(other.getBox().isColliding(getBox()))
            taken = true;
    }

    @Override
    public int getPriority()
    {
        return 47;
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
        return false;
    }

    @Override
    public abstract void draw(Input input, Output output);

}
