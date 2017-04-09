package platform.game.Characters;

import platform.game.Actor;
import platform.util.Box;
import platform.util.Input;
import platform.util.Output;
import platform.util.Vector;

/**
 * Class name: Character.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 07/12/2016 at 14:36
 **/
abstract public class Character extends Actor
{
    Vector position;
    Vector velocity;
    private boolean colliding;
    private double health;
    private double maxhealth;
    private double size;
    private Side side;

    /**
     * Constructor de Character
     *
     * @param position  the initial position of the character
     * @param velocity  the initial velocity of the character
     * @param health    the initial health of the character
     * @param maxhealth maxhealth of the character
     * @param size      size of the character
     * @param side      side of the character
     */
    public Character(Vector position, Vector velocity, double health, double maxhealth, double size, Side side)
    {
        if(position == null || velocity == null)
            throw new NullPointerException();
        this.position = position;
        this.velocity = velocity;
        this.health = health;
        this.maxhealth = maxhealth;
        assert (health > 0 && maxhealth >= health);
        this.size = size;
        this.side = side;
    }

    /**
     * Calculate the box of the Character and return it
     *
     * @return box of the Character
     */
    @Override
    public Box getBox()
    {
        return new Box(position, size, size);
    }

    /**
     * @return the priority of the Character
     */
    @Override
    public int getPriority()
    {
        return 55;
    }

    /**
     * Assign the side of a Character
     *
     * @param side
     */
    public void setSide(Side side)
    {
        this.side = side;
    }

    /**
     * @return the side of the Character
     */
    @Override
    public Side getSide()
    {
        return side;
    }

    /**
     * Enumeration of the possible sides that a Character can have
     */
    public enum Side
    {
        ALLIED, ENNEMY, NEUTRAL
    }

    /**
     * It defines how the Character interact with others Actors
     *
     * @param other the other actor
     */
    @Override
    public void interact(Actor other)
    {
        if(other.isSolid())
        {
            Vector delta = other.getBox().getCollision(getBox());
            if(delta != null)
            {
                colliding = true;
                position = position.add(delta);
                if(delta.getX() != 0.0)
                    velocity = new Vector(0.0, velocity.getY());
                if(delta.getY() != 0.0)
                    velocity = new Vector(velocity.getX(), 0.0);
            }
        }
    }

    /**
     * @return the position of the Character
     */
    @Override
    public Vector getPosition()
    {
        return position;
    }

    /**
     * check if a Character is solid or not
     *
     * @return true if solid and false otherwise
     */
    @Override
    public boolean isSolid()
    {
        return false;
    }

    /**
     * @return the actual health of the Character
     */
    public double getHealth()
    {
        return health;
    }

    /**
     * @return the maxim health of the Character
     */
    public double getMaxhealth()
    {
        return maxhealth;
    }

    /**
     * @return the vector velocity of the Character
     */
    @Override
    public Vector getVelocity()
    {
        return velocity;
    }

    /**
     * set the velocity of the Character
     *
     * @param velocity
     */
    public void setVelocity(Vector velocity)
    {
        this.velocity = velocity;
    }

    /**
     * set the position of the Character
     *
     * @param position
     */
    public void setPosition(Vector position)
    {
        this.position = position;
    }

    /**
     * Set the health of the Character
     *
     * @param health
     */
    public void setHealth(double health)
    {
        this.health = health;
    }

    /**
     * set the attribute colliding to a value
     *
     * @param value
     */
    public void setColliding(boolean value)
    {
        this.colliding = value;
    }

    /**
     * return true if the value colling is true
     *
     * @return true if colliding, false otherwise
     */
    public boolean getColliding()
    {
        return colliding;
    }

    /**
     * override of preUpdate, update the Character in a post phase
     * set the value of colliding to false
     *
     * @param input
     */
    @Override
    public void preUpdate(Input input)
    {
        setColliding(false);
    }
}
