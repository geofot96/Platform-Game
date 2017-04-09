package platform.game;

/**
 * Class name: KeyRed.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:40
 **/

import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class KeyRed extends Key
{
    /**
     * constructor of class KeyRed
     *
     * @param position the position of the key
     */
    public KeyRed(Vector position)
    {
        super(position);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("key.red.png"), getBox());
    }
}
