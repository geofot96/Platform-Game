package platform.game;

import platform.game.level.Level;
import platform.game.level.Selection;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: Princess.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 09/12/2016 at 1:13 PM
 **/
public class Princess extends Actor
{
    Vector position;
    final static double SIZE = 0.5;

    /**
     * constructor of class princess
     *
     * @param position the initial position of the princess
     */
    public Princess(Vector position)
    {
        this.position = position;
    }

    @Override
    public int getPriority()
    {
        return 43;
    }

    @Override
    public Box getBox()
    {
        return new Box(position, SIZE, SIZE);
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(other.getBox().isColliding(getBox()))
        {
            getWorld().setNextLevel(new Level().createDefaultLevel());
            Win win = new Win(1);
            getWorld().register(win);
        }
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("princess.happy.png"), getBox());
    }
}
