package platform.game.Signals;

/**
 * Class name: And.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:03 AM
 **/
public class And implements Signal
{
    private final Signal left;
    private final Signal right;

    /**
     * constructor of class And
     *
     * @param s1 the first signal
     * @param s2 the second signal
     */
    public And(Signal s1, Signal s2)
    {
        if(s1 == null || s2 == null)
            throw new NullPointerException();
        left = s1;
        right = s2;
    }

    @Override
    public boolean isActive()
    {
        return left.isActive() && right.isActive();
    }
}
