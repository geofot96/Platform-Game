package platform.game;

import platform.util.*;

/**
 * Class name: Fireball.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 25/11/2016 at 1:02 PM
 **/

public class Fireball extends Ball
{
    /**
     * constructor of class fireball
     *
     * @param position the initial position of the fireball
     * @param velocity the initial velocity of the fireball
     * @param owner    the owner of the fireball
     */
    public Fireball(Vector position, Vector velocity, Actor owner)
    {
        super(position, velocity, owner);
        super.setType(Damage.FIRE);
    }

    /**
     * method to draw a fireball
     *
     * @param input
     * @param output
     */
    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("fireball.png"), getBox(), input.getTime() * 42);
    }
}
