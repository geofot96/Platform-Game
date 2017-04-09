package platform.game;

import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: KeyGreen.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:36 AM
 **/
public class KeyGreen extends Key
{
    /**
     * constructor of class KeyGreen
     *
     * @param position the position of the key
     */
    public KeyGreen(Vector position)
    {
        super(position);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("key.green.png"), getBox());
    }
}
