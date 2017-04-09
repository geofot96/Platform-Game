package platform.game;

import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: KeyBlue.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:34 AM
 **/
public class KeyBlue extends Key
{
    /**
     * constructor of class KeyBlue
     *
     * @param position the position of the key
     */
    public KeyBlue(Vector position)
    {
        super(position);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("key.blue.png"), getBox());
    }
}
