package platform.game;

import platform.util.*;

import java.awt.event.KeyEvent;

/**
 * Class name: End.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 06/12/2016 at 7:20 PM
 **/
public class End extends Actor
{
    double duration;
    double time;

    /**
     * constructor of class End
     *
     * @param duration the duration of the end animation
     */
    public End(double duration)
    {
        this.duration = duration;
        time = duration;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        time -= input.getDeltaTime();
        if(time < 0.0 && input.getKeyboardButton(KeyEvent.VK_ENTER).isPressed())
        {
            getWorld().unregister(this);
            getWorld().nextLevel();
        }
    }

    @Override
    public int getPriority()
    {
        return 10303;
    }

    @Override
    public void draw(Input input, Output output)
    {
        Sprite sprite = getSprite("game.over.png");
        Sprite sprite2 = getSprite("game.press.png");
        double transparency = Math.max(0.0, time - duration + 1.0);

        if(time > 0.3)
        {
            output.drawSprite(sprite, output.getBox(), 0.0, transparency);
        }
        else
            output.drawSprite(sprite2, output.getBox(), 0.0, transparency);
    }
}
