package platform.game;

import platform.game.Signals.Signal;
import platform.util.*;

/**
 * Class name: Torch.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 28/11/2016 at 3:04 PM
 **/
public class Torch extends Actor implements Signal
{
    Vector position;
    Box box;
    boolean lit;
    double variation;
    final static double SIZE = 0.8;

    /**
     * constructor of the class Torch
     *
     * @param position the position of the torch
     * @param lit      signal to decide if the torch is on or off
     */
    public Torch(Vector position, boolean lit)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        box = new Box(position, SIZE, SIZE);
        this.lit = lit;
        this.variation = 0;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        variation -= input.getDeltaTime();
        if(variation < 0.0)
        {
            variation = 0.6;
        }
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
    }

    @Override
    public int getPriority()
    {
        return 34;
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
    public void draw(Input input, Output output)
    {
        String name = "torch.lit.1";
        if(variation < 0.3)
            name = "torch.lit.2";
        if(lit)
            output.drawSprite(getSprite(name), getBox());
        else
            output.drawSprite(getSprite("torch.png"), getBox());
    }

    @Override
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        super.hurt(instigator, type, amount, location);
        switch(type)
        {
            case AIR:
                lit = false;
                return true;
            case FIRE:
                lit = true;
                return true;
            case WATER:
                lit = false;
                return true;
            default:
                return super.hurt(instigator, type, amount, location);
        }
    }

    @Override
    public boolean isActive()
    {
        return lit;
    }

}
