package platform.game;

import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;

/**
 * Class name: Win.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 09/12/2016 at 1:47 PM
 **/
public class Win extends End
{
    /**
     * constructor of class Win
     *
     * @param duration duration of the win effect, even though you have to press enter to reload the default level
     */
    public Win(double duration)
    {
        super(duration);
    }

    public void draw(Input input, Output output)
    {
        Sprite sprite = getSprite("you.won.png");
        double transparency = Math.max(0.0, time - duration + 1.0);

        output.drawSprite(sprite, output.getBox(), 0.0, transparency);
    }
}
