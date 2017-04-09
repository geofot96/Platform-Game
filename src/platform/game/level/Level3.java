package platform.game.level;

import platform.game.*;
import platform.game.Characters.Player;
import platform.game.Signals.And;
import platform.util.Box;
import platform.util.Vector;

/**
 * Class name: Level3.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 12/12/2016 at 2:39 PM
 **/
public class Level3 extends Level
{

    @Override
    public int getPriority()
    {
        return Integer.MAX_VALUE;
    }

    @Override
    public void register(World world)
    {
        super.register(world);

        // Create player //
        Player player = new Player(new Vector(-3, 4), new Vector(0, 3), 5, 5);
        world.register(player);

        world.register(new Overlay(player));

        world.register(new Limits(new Box(new Vector(0, -16), Integer.MAX_VALUE, 30)));

        //add background //
        world.register(new Background(world.getLoader().getSprite("colored_desert.png")));

        world.register(new Block(new Vector(0, 0), world.getLoader().getSprite("grass.middle.png"), 7.5, 1));

        world.register(new Spikes(new Vector(-0.5, 0.75), 1));
        world.register(new Spikes(new Vector(-1, 0.75), 1));
        world.register(new Spikes(new Vector(-1.5, 0.75), 1));
        world.register(new Spikes(new Vector(-2, 0.75), 1));
        world.register(new Spikes(new Vector(-3.5, 0.75), 1));
        world.register(new Spikes(new Vector(-3, 0.75), 1));
        world.register(new Spikes(new Vector(-2.5, 0.75), 1));

        world.register(new Jumper(new Vector(0, 1), 0.5));

        world.register(new Spikes(new Vector(0.5, 0.75), 1));
        world.register(new Spikes(new Vector(1, 0.75), 1));
        world.register(new Spikes(new Vector(1.5, 0.75), 1));
        world.register(new Spikes(new Vector(2, 0.75), 1));
        world.register(new Spikes(new Vector(3.5, 0.75), 1));
        world.register(new Spikes(new Vector(3, 0.75), 1));
        world.register(new Spikes(new Vector(2.5, 0.75), 1));

        world.register(new Block(new Vector(0, 6), world.getLoader().getSprite("grass.middle.png"), 3.5, 1));

        world.register(new Spikes(new Vector(0.0, 5.25), 1, Math.PI));
        world.register(new Spikes(new Vector(0.5, 5.25), 1, Math.PI));
        world.register(new Spikes(new Vector(-0.5, 5.25), 1, Math.PI));
        world.register(new Spikes(new Vector(1, 5.25), 1, Math.PI));
        world.register(new Spikes(new Vector(-1, 5.25), 1, Math.PI));
        world.register(new Spikes(new Vector(1.5, 5.25), 1, Math.PI));
        world.register(new Spikes(new Vector(-1.5, 5.25), 1, Math.PI));

        Key keygreen = new KeyGreen(new Vector(4.25, 1.5));
        world.register(keygreen);
        world.register(new Door(new Box(new Vector(3.75, -0.5), new Vector(4.75, 0.5)), world.getLoader().getSprite("lock.green.png"), keygreen));

        Torch torch1 = new Torch(new Vector(5, 2), false);
        world.register(torch1);

        Torch torch2 = new Torch(new Vector(0, 7.5), false);
        world.register(torch2);

        Star star = new Star(new Vector(9, 8));
        world.register(star);

        world.register(new Exit(new Vector(20, 9), new Level4(), star));
        world.register(new Block(new Vector(20, 8), world.getLoader().getSprite("grass.middle.png"), 3, 1));

        world.register(new Mover(new Vector(6.5, 0.5), new Vector(7.5, 6), world.getLoader().getSprite("stone.1.png"), new Vector(15.5, 0.5), new Vector(16.5, 6), new And(torch1, torch2), 0.2));
    }


}
