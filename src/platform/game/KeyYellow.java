package platform.game;

/**
 * Class name: KeyYellow.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 01/12/2016 at 11:40
 **/

import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

public class KeyYellow extends Key
{
    /**
     * constructor of class KeyYellow
     *
     * @param position the position of the key
     */
    public KeyYellow(Vector position)
    {
        super(position);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("key.yellow.png"), getBox());
    }
}
