package platform.game.Characters;

import platform.game.Signals.Signal;
import platform.util.Vector;

/**
 * Class name: Mob.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 07/12/2016 at 15:33
 **/
public abstract class Mob extends Character implements Signal
{

    private Category category;
    private double baseValue;

    /**
     * Constructor of Mob, set all the arguments to attributes
     *
     * @param position  initial position of the mob
     * @param velocity  initial velocity of the mob
     * @param health    initial health of the mob
     * @param maxhealth maxhealth of the mob
     * @param size      size of the mob
     * @param side      side of the mob
     * @param category  category of the mob
     */
    public Mob(Vector position, Vector velocity, double health, double maxhealth, double size, Side side, Category category)
    {
        super(position, velocity, health, maxhealth, size, side);
        this.category = category;
    }

    /**
     * @return the Category of the mob
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * set the category of the Mob
     *
     * @param category
     */
    public void setCategory(Category category)
    {
        this.category = category;
    }

    /**
     * Check if the value of health is above 0, otherwise it unregister the Mob
     */
    public void checkLife()
    {
        if(getHealth() <= 0)
        {
            getWorld().unregister(this);
        }
    }

    /**
     * Enumeration for the category where a Mob can belong to
     */
    public enum Category
    {
        SMALL, NORMAL, BIG, BOSS, SUPERBOSS;
    }

    /**
     * Enumeration for the direction of the movement of a Mob
     */
    public enum Direction
    {
        LEFT, RIGHT
    }

    /**
     * @return true if active, false otherwise
     */
    public boolean isActive()
    {
        if(getHealth() <= 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Modifies the value based on the category of the mob
     *
     * @param value
     * @return (damage) value modified
     */
    public double modifyDamageTaken(double value)
    {
        switch(category)
        {
            case SMALL:
                return value * 2;
            case NORMAL:
                return value;
            case BIG:
                return value * 0.5;
            case BOSS:
                return value * 0.2;
            case SUPERBOSS:
                return value * 0.1;
            default:
                return value;
        }
    }

    /**
     * Modifies the value based on the category of the mob
     *
     * @param value
     * @return (heal) value modified
     */
    public double modifyHeal(double value)
    {
        switch(category)
        {
            case SMALL:
                return value * 0.5;
            case NORMAL:
                return value;
            case BIG:
                return value * 2;
            case BOSS:
                return value * 5;
            case SUPERBOSS:
                return value * 10;
            default:
                return value;
        }
    }

    /**
     * Modifies the value based on the category of the Mob
     *
     * @param value
     * @return (damage) value modified
     */
    public double modifyDamageInflicted(double value)
    {
        switch(category)
        {
            case SMALL:
                return value * 0.5;
            case NORMAL:
                return value;
            case BIG:
                return value * 1.5;
            case BOSS:
                return value * 2;
            case SUPERBOSS:
                return value * 4;
            default:
                return value;
        }
    }

    /**
     * Set the base value for the Mob, this value is the one that is then used for the modifiers
     *
     * @param value that we want to set as base value
     */
    public void setBaseValue(double value)
    {
        this.baseValue = value;
    }

    /**
     * @return the baseValue of the Mob
     */
    public double getBaseValue()
    {
        return baseValue;
    }
}
