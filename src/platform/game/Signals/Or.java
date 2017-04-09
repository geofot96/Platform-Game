package platform.game.Signals;

/**
 * Class name: Or.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:08 AM
 **/
public class Or implements Signal
{
    private final Signal left;
    private final Signal right;

    /**
     * constructor of class Or
     *
     * @param s1 the first signal
     * @param s2 the second signal
     */
    public Or(Signal s1, Signal s2)
    {
        if(s1 == null || s2 == null)
            throw new NullPointerException();
        left = s1;
        right = s2;
    }

    @Override
    public boolean isActive()
    {
        return left.isActive() || right.isActive();
    }
}
