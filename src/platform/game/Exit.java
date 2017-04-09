package platform.game;

import platform.game.Signals.Signal;
import platform.game.level.Level;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: Exit.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 05/12/2016 at 3:00 PM
 **/
public class Exit extends Actor implements Signal
{
    Vector position;
    Level next;
    Signal signal;

    /**
     * constructor of class Exit
     *
     * @param position the position of the center of the box containing the exit
     * @param next the next level to go to
     * @param signal signal to determine if the door is open or not
     */
    public Exit(Vector position, Level next, Signal signal)
    {
        this.position = position;
        this.next = next;
        this.signal = signal;
    }

    @Override
    public boolean isActive()
    {
        return signal.isActive();
    }

    @Override
    public Vector getPosition()
    {
        return position;
    }

    @Override
    public Box getBox()
    {
        return new Box(position, 1, 1);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }

    @Override
    public int getPriority()
    {
        return 3;
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(getBox().isColliding(other.getBox()) && signal.isActive())
        {
            getWorld().setNextLevel(next);
            getWorld().nextLevel();
        }
    }

    @Override
    public void draw(Input input, Output output)
    {
        if(signal.isActive())
            output.drawSprite(getSprite("door.open.png"), getBox());
        else
            output.drawSprite(getSprite("door.closed.png"), getBox());
    }
}
