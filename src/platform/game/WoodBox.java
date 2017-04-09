package platform.game;

import platform.util.Input;
import platform.util.Output;
import platform.util.Sprite;
import platform.util.Vector;

/**
 * Class name: WoodBox.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 06/12/2016 at 6:31 PM
 **/
public class WoodBox extends Block
{
    boolean destructed;
    double counter;

    /**
     * constructor of the class Woodbox
     *
     * @param v1 the position of the lower left corner of the box that contains the Woodbox
     * @param v2 the position of the higher right corner of the box that contains the Woodbox
     * @param s  the sprite of the Woodbox
     */
    public WoodBox(Vector v1, Vector v2, Sprite s)
    {
        super(v1, v2, s);
        destructed = false;
    }

    /**
     * constructor of the class Woodbox that creates a 1 by 1 Woodbox on a specific point determined by the woodboxe's center
     *
     * @param center center of the box that contains the woodbox
     * @param s      sprite of the woodbox
     */
    public WoodBox(Vector center, Sprite s)
    {
        super(center, s);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(returnSprite(), getBox());
    }

    @Override
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        super.hurt(instigator, type, amount, location);
        switch(type)
        {
            case FIRE:
                destructed = true;
                return true;
            default:
                return super.hurt(instigator, type, amount, location);
        }
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        if(destructed)
        {
            Particle smoke = new Particle();
            smoke.setPosition(getPosition());
            smoke.setDuration(0.02);
            smoke.setSize(counter);
            String name = "smoke.white.1.png";
            Sprite sprite = getWorld().getLoader().getSprite(name);
            smoke.setSprite(sprite);
            getWorld().register(smoke);
            if(counter >= 2)
            {
                smoke.setDuration(0.4);
                getWorld().unregister(this);
            }
            counter += 0.05;
        }
    }
}


