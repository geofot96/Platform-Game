package platform.game;

import platform.game.Actor;
import platform.game.Characters.Character;
import platform.util.*;

/**
 * Class name: Overlay.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 26/11/2016 at 8:39 PM
 **/
public class Overlay extends Actor
{
    Character player;
    String[] name;

    /**
     * constructor of the class overlay
     *
     * @param player the player attribute
     */
    public Overlay(Character player)
    {
        this.player = player;
        name = new String[5];
    }

    @Override
    public void update(Input input)
    {
        double health = 5.0 * player.getHealth() / player.getMaxhealth();
        for(int i = 1; i <= 5; ++i)
        {
            //String name;
            if(health >= i)
                name[i - 1] = "heart.full.png";
            else if(health >= i - 0.5)
                name[i - 1] = "heart.half.png";
            else
                name[i - 1] = "heart.empty.png";
        }
    }

    @Override
    public int getPriority()
    {
        return 1;
    }

    @Override
    public void interact(Actor other)
    {
        super.interact(other);
    }

    @Override
    public void draw(Input input, Output output)
    {
        double temp;
        for(int i = 0; i < 5; i++)
        {
            temp = (double) i;
            output.drawSprite(getSprite(name[i]), getBox().add(new Vector((temp - 2) / 4, 0)));
        }
    }

    @Override
    public Box getBox()
    {
        return new Box(player.getPosition().add(new Vector(0.0, 0.5)), 0.25, 0.25);
    }
}
