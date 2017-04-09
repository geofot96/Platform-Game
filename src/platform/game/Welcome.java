package platform.game;

import platform.util.*;

/**
 * Class name: Welcome.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 06/12/2016 at 7:53 PM
 **/
public class Welcome extends Actor
{
    double duration;
    double time;

    /**
     * constructor of the class Welcome
     *
     * @param duration duration of the welcome animation
     */
    public Welcome(double duration)
    {
        this.duration = duration;
        time = duration + 1.7;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        time -= input.getDeltaTime();
        if(time <= 0.0)
        {
            getWorld().unregister(this);
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
        Sprite sprite = getSprite("welcome.png");
        double transparency = Math.max(0.0, time - duration + 1.0);
        output.drawSprite(sprite, output.getBox(), 0.0, transparency);
    }

}
