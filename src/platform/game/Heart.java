package platform.game;

import platform.util.*;

/**
 * Class name: Heart.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 28/11/2016 at 1:59 PM
 **/
public class Heart extends Actor
{
    double cooldown;
    double counter;
    Vector position;
    Box box;
    final static double SIZE = 0.5;

    /**
     * constructor of class Heart
     *
     * @param position the position of the heart
     * @param cooldown the time to pass before the heart reappears if it has disappeared
     */
    public Heart(Vector position, double cooldown)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        this.cooldown = cooldown;
        box = getBox();
        counter = 0.0;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        counter -= input.getDeltaTime();
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(counter <= 0 && getBox().isColliding(other.getBox()))
        {
            if(other.hurt(this, Damage.HEAL, 1, getPosition()))
                counter = cooldown;
        }
    }

    @Override
    public int getPriority()
    {
        return 43;
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
        if(counter < 0)
            output.drawSprite(getSprite("heart.full.png"), getBox());
    }
}
