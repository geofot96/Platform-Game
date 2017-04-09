package platform.game;

import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: Ball.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 30/11/2016 at 22:28
 **/
public abstract class Ball extends Actor
{
    private Vector position;
    private Vector velocity;
    public final static double SIZE = 0.4;
    private Actor owner;
    int counter;
    private Damage type;

    public Ball(Vector position, Vector velocity, Actor owner)
    {
        if(position == null || velocity == null)
            throw new NullPointerException();
        this.position = position;
        this.velocity = velocity;
        this.owner = owner;
        counter = 0;
    }

    @Override
    public Box getBox()
    {
        return new Box(position, SIZE, SIZE);
    }

    @Override
    public int getPriority()
    {
        return 666;
    }

    /**
     * method responsible for the movement of the ball
     *
     * @param input
     */
    @Override
    public void update(Input input)
    {
        super.update(input);
        double delta = input.getDeltaTime();
        velocity = velocity.add(getWorld().getGravity().mul(delta));
        position = position.add(velocity.mul(delta));
    }

    /**
     * collision handling
     *
     * @param other actor to interact
     */
    @Override
    public void interact(Actor other)
    {
        super.interact(other);
        if(other.isSolid())
        {
            if(other.getBox().isColliding(getBox()))
            {
                if(other.hurt(this, type, 1.0, getPosition()) && owner != other)
                    getWorld().unregister(this);
                if(other != owner)
                    counter++;
            }
            Vector delta = other.getBox().getCollision(position);
            if(delta != null)
            {
                position = position.add(delta);
                velocity = velocity.mirrored(delta);
            }
            if(counter >= 70)
                getWorld().unregister(this);
        }
        else if(other.getBox().isColliding(getBox()))
        {
            if(other.hurt(this, type, 1.0, getPosition()) && owner != other)
                getWorld().unregister(this);
        }
    }

    protected void setType(Damage type)
    { //is this thing correct for the "correct design"?
        this.type = type;
    }
}
