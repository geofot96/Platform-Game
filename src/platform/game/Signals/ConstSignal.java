package platform.game.Signals;

/**
 * Class name: ConstSignal.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 08/12/2016 at 1:10 PM
 **/
public class ConstSignal implements Signal
{
    boolean value;

    /**
     * constructor of the class ConstSignal
     *
     * @param value the value of the signal
     */
    public ConstSignal(boolean value)
    {
        this.value = value;
    }

    @Override
    public boolean isActive()
    {
        return value;
    }
}
