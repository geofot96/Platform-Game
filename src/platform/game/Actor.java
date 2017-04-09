package platform.game;

import platform.game.Characters.Character;
import platform.util.*;

/**
 * Base class of all simulated actors, attached to a world.
 */
public abstract class Actor implements Comparable<Actor>
{
    private World world;

    // pour évoluer au cours du temps :
    public void update(Input input)
    {
    }

    // pour être dessiné
    public void draw(Input input, Output output)
    {
    }

    /**
     * defines how an actor interacts with another actor
     *
     * @param other the other actor
     */
    public void interact(Actor other)
    {
    }

    //to do some things that need to be done before the update
    public void preUpdate(Input input)
    {
    }

    //to do some things that need to be done after the update
    public void postUpdate(Input input)
    {
    }

    protected World getWorld()
    {
        return this.world;
    }

    /**
     * checks if an actor is solid or not
     *
     * @return true if solid and false if not solid
     */
    public boolean isSolid()
    {
        return false;
    }

    /**
     * returns the box that contains an actor
     *
     * @return null by default but is overridden by other classes to return a box
     */
    public Box getBox()
    {
        return null;
    }

    /**
     * returns the position of an actor
     *
     * @return null the actor doesn't have box, the position vector otherwise
     */
    public Vector getPosition()
    {
        Box box = getBox();
        if(box == null)
            return null;
        return box.getCenter();
    }

    /**
     * compares the priorities between two actors
     *
     * @param other the other actor
     * @return a value depending on which actor has a bigger priority
     */
    @Override
    public int compareTo(Actor other)
    {
        if(this.getPriority() > other.getPriority())
            return -1;
        else if(this.getPriority() == other.getPriority())
            return 0;
        else
            return 1;
    }

    /**
     * register a world
     *
     * @param world the world to be registered
     */
    public void register(World world)
    {
        this.world = world;
    }

    /**
     * unregister a world
     */
    public void unregister()
    {
        world = null;
    }

    /**
     * takes an images name and returns the sprite corresponding to it
     *
     * @param name the name of an image
     * @return the sprite corresponding to the image
     */
    protected Sprite getSprite(String name)
    {
        Sprite sprite = world.getLoader().getSprite(name);
        return sprite;
    }

    //returns the priority of an actor
    public abstract int getPriority();

    //type of damage
    public enum Damage
    {
        FIRE, PHYSICAL, AIR, VOID, ACTIVATION, HEAL, WATER;
    }

    /**
     * defines if an actor is affected by a type of damge or not
     *
     * @param instigator the actor to cause the damage
     * @param type       the type of damage
     * @param amount     how much damage will be affected
     * @param location   the location vector
     * @return true if the damage has an effect and false otherwise
     */
    public boolean hurt(Actor instigator, Damage type, double amount, Vector location)
    {
        return false;
    }

    /**
     * @return the velocity vector
     */
    public Vector getVelocity()
    {
        return new Vector(0.0, 0.0);
    }

    /**
     * defines the side that a character has, that is allied, enemy and neutral
     *
     * @return the side of the character
     */
    public Character.Side getSide()
    {
        return Character.Side.NEUTRAL;
    }
}