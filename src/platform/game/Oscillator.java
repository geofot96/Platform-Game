package platform.game;

import platform.game.Signals.Signal;
import platform.util.Box;
import platform.util.Input;
import platform.util.Vector;

/**
 * Class name: Oscillator.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 12/12/2016 at 22:25
 **/
public class Oscillator extends Actor implements Signal
{

    private boolean value;
    private double cooldown;
    private double temp;

    /**
     * Create a new Oscillator
     *
     * @param cooldown
     * @param initialValue
     */
    public Oscillator(double cooldown, boolean initialValue)
    {
        this.cooldown = cooldown;
        this.temp = cooldown;
        this.value = initialValue;
    }


    @Override
    public boolean isActive()
    {
        if(temp <= 0)
        {
            temp = cooldown;
            value = !value;
        }
        return value;
    }

    @Override
    public int getPriority()
    {
        return -10;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        temp -= input.getDeltaTime();
    }

    @Override
    public Box getBox()
    {
        return new Box(new Vector(0, 0), 0, 0);
    }


}
