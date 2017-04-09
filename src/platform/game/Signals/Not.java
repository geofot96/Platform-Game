package platform.game.Signals;

/**
 * Class name: Not.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:00 AM
 **/
public class Not implements Signal
{
    private final Signal signal;

    /**
     * constructor of class Not
     *
     * @param signal the value of the signal
     */
    public Not(Signal signal)
    {
        if(signal == null)
            throw new NullPointerException();
        this.signal = signal;
    }

    @Override
    public boolean isActive()
    {
        return !signal.isActive();
    }
}
