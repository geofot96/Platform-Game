package platform.game;

import platform.game.Signals.Signal;
import platform.util.Box;
import platform.util.Input;
import platform.util.Sprite;

/**
 * Class name: Door.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 02/12/2016 at 13:11
 **/
public class Door extends Block implements Signal
{
    private boolean locked;
    private Signal key;

    /**
     * constructor of the class door
     * @param b box attribute of door
     * @param s sprite attribute of door
     * @param key signal attribute of door
     */
    public Door(Box b, Sprite s, Signal key)
    {
        super(b, s);
        locked = true;
        this.key = key;
    }

    @Override
    public boolean isActive()
    {
        return key.isActive();
    }

    @Override
    public int getPriority()
    {
        return 35;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        if(isActive())
            getWorld().unregister(this);
    }
}
