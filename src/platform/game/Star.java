package platform.game;

import platform.game.Signals.Signal;
import platform.util.*;

/**
 * Class name: Star.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 05/12/2016 at 3:27 PM
 **/
public class Star extends Actor implements Signal
{
    boolean taken;
    Vector position;
    final static double SIZE = 0.5;
    private double counter = 0;


    /**
     * constructor of the class star
     *
     * @param position the position of the star
     */
    public Star(Vector position)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        taken = false;
    }

    @Override
    public boolean isActive()
    {
        return taken;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        if(isActive())
        {
            Particle starRing = new Particle();
            starRing.setPosition(getPosition());
            starRing.setDuration(0.02);
            String name = "star.ring.png";
            Sprite sprite = getWorld().getLoader().getSprite(name);
            starRing.setSprite(sprite);
            getWorld().register(starRing);
            starRing.setSize(counter);
            if(counter >= 2)
            {
                getWorld().unregister(this);
            }
            counter += 0.03;
        }
    }

    @Override
    public void interact(Actor other)
    {
        if(other.getBox().isColliding(getBox()))
        {
            taken = true;
        }
    }

    @Override
    public int getPriority()
    {
        return 47;
    }

    @Override
    public Vector getPosition()
    {
        return position;
    }

    @Override
    public Box getBox()
    {
        return new Box(position, SIZE, SIZE);
    }

    @Override
    public boolean isSolid()
    {
        return false;
    }

    @Override
    public void draw(Input input, Output output)
    {
        if(!taken)
            output.drawSprite(getSprite("star.png"), getBox());
    }
}
