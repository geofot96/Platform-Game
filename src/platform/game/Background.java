package platform.game;

import platform.util.*;

/**
 * Class name: Background.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 08/12/2016 at 10:43 AM
 **/
public class Background extends Actor
{
    private Sprite sprite;

    /**
     * constructor of the class Background that initiates the background sprite
     *
     * @param sprite
     */
    public Background(Sprite sprite)
    {
        this.sprite = sprite;
    }

    @Override
    public int getPriority()
    {
        return Integer.MIN_VALUE;
    }

    public Box getBox()
    {
        return new Box(new Vector(0, 0), 0, 0);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(sprite, output.getBox());
    }

}
