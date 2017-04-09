package platform.game;

import platform.util.*;

/**
 * Class name: Jumper.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 26/11/2016 at 6:00 PM
 **/
public class Jumper extends Actor
{
    double cooldown;
    Vector position;
    Box box;
    final static int SIZE = 1;

    /**
     * constructor of the class jumper
     *
     * @param position position vector
     * @param cooldown cooldown time
     */
    public Jumper(Vector position, double cooldown)
    {
        if(position == null)
            throw new NullPointerException();
        this.position = position;
        this.cooldown = cooldown;
        box = getBox();
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        cooldown -= input.getDeltaTime();
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(cooldown <= 0 && getBox().isColliding(other.getBox()))
        {
            Vector below = new Vector(position.getX(), position.getY() - 1.0);
            if(other.hurt(this, Damage.AIR, 10.0, below))
                cooldown = 0.5;
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
        return true;
    }

    @Override
    public void draw(Input input, Output output)
    {
        if(cooldown < 0)
            output.drawSprite(getSprite("jumper.extended.png"), getBox());
        else
            output.drawSprite(getSprite("jumper.normal.png"), getBox());
    }
}
