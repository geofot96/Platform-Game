package platform.game;

import platform.util.*;

/**
 * Class name: Waterball.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 29/11/2016 at 7:46 PM
 **/
public class Waterball extends Ball
{

    public Waterball(Vector position, Vector velocity, Actor owner)
    {
        super(position, velocity, owner);
        super.setType(Damage.WATER);
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(getSprite("waterball.png"), getBox(), input.getTime() * 42);
    }
}
