package platform.game;

import platform.game.level.BasicLevel;
import platform.util.*;

/**
 * Class name: Limits.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 26/11/2016 at 7:30 PM
 **/
public class Limits extends Actor
{
    Box box;

    /**
     * constructor of the class limits
     *
     * @param box the limits box
     */
    public Limits(Box box)
    {
        this.box = box;
    }

    @Override
    public int getPriority()
    {
        return 50;
    }

    @Override
    public Vector getPosition()
    {
        Box box = getBox();
        if(box == null)
            return null;
        return box.getCenter();
    }

    @Override
    public Box getBox()
    {
        return box;
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(other.getBox().isColliding(getBox()))
            other.hurt(this, Damage.VOID, Double.POSITIVE_INFINITY, Vector.ZERO);
    }
}
