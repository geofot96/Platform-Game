package platform.game;

import platform.game.Signals.Signal;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: Lever.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 02/12/2016 at 14:27
 **/
public class Lever extends Actor implements Signal
{
    private boolean value;
    private Vector position;
    private double duration;
    private double time;
    private final double SIZE = 1.0;

    /**
     * constructor of the class Lever
     *
     * @param position the position of the center of the box containing the lever
     * @param duration the duration of the lever animation
     */
    public Lever(Vector position, double duration)
    {
        this.position = position;
        this.duration = duration;
        this.value = false;

    }

    @Override
    public boolean isActive()
    {
        return value;
    }

    @Override
    public int getPriority()
    {
        return 17;
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
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
        if(value)
            output.drawSprite(getSprite("lever.left.png"), getBox());
        else
            output.drawSprite(getSprite("lever.right.png"), getBox());
    }

    @Override
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        super.hurt(instigator, type, amount, location);
        switch(type)
        {
            case ACTIVATION:
                if(amount > 0)
                {
                    value = !value;
                    time = duration;

                }
                return true;
            default:
                return super.hurt(instigator, type, amount, location);
        }
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        if(time > 0)
        {
            time -= input.getDeltaTime();
            if(time <= 0)
            {
                value = !value;
            }
        }
    }
}
