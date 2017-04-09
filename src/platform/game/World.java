package platform.game;

import platform.util.Box;
import platform.util.Loader;
import platform.util.Vector;
import platform.game.level.Level;

/**
 * Represents an environment populated by actors.
 */
public interface World
{

    /**
     * @return associated loader, not null
     */
    public Loader getLoader();

    /**
     * Set viewport location and size.
     *
     * @param center viewport center , not null
     * @param radius viewport radius , positive
     */
    public void setView(Vector center, double radius);

    public void register(Actor actor);

    public void unregister(Actor actor);

    default public Vector getGravity()
    {
        return new Vector(0.0, -9.81);
    }

    // permet d'indiquer que la transition à un autre niveau
    // doit se faire :
    public void nextLevel();

    // permet de passer au niveau level :
    public void setNextLevel(Level level);

    /**
     * affect damage of a given type to all the actors in a specific area
     *
     * @param area       the area in which the actors will be affected
     * @param instigator the actor to cause the damage
     * @param type       the type of damage to be affected
     * @param amount     how much damage will be affected
     * @param location   location vector
     * @return the number of victims
     */
    public int hurt(Box area, Actor instigator, Actor.Damage type, double amount, Vector location);
}


