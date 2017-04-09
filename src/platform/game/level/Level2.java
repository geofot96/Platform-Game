package platform.game.level;

import platform.game.*;
import platform.game.Characters.Player;
import platform.game.Signals.And;
import platform.game.Signals.Or;
import platform.util.Box;
import platform.util.Vector;

/**
 * Class name: Level2.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 05/12/2016 at 3:18 PM
 **/
public class Level2 extends Level
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

        // add background //
        world.register(new Background(world.getLoader().getSprite("blue_land.png")));

        // Create blocks //
        world.register(new Block(new Box(new Vector(0, 0), 6, 2), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(2, 1.5), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(2, 2.5), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(1, 2.5), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(0, 2.5), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(-1, 2.5), world.getLoader().getSprite("stone.broken.2")));

        world.register(new WoodBox(new Vector(-1, 1.5), world.getLoader().getSprite("box.empty.png")));

        world.register(new Block(new Vector(-7, 0), world.getLoader().getSprite("stone.broken.2"), 3, 2));
        world.register(new Block(new Vector(-12, -3), world.getLoader().getSprite("stone.broken.2"), 3, 2));

        world.register(new Spikes(new Vector(-8, 1.25), 1));
        world.register(new Spikes(new Vector(-6, 1.25), 1));
        world.register(new Spikes(new Vector(-7.5, 1.25), 1));
        world.register(new Spikes(new Vector(-6.5, 1.25), 1));
        world.register(new Jumper(new Vector(-7, 1.25), 0.5));

        world.register(new Spikes(new Vector(-13, -1.75), 1));
        world.register(new Spikes(new Vector(-11, -1.75), 1));
        world.register(new Spikes(new Vector(-12.5, -1.75), 1));
        world.register(new Spikes(new Vector(-11.5, -1.75), 1));
        world.register(new Jumper(new Vector(-12, -1.75), 0.5));

        // Create player //
        Player player = new Player(new Vector(0, 0), new Vector(4, 2), 5, 5);
        world.register(player);

        world.register(new Limits(new Box(new Vector(0, -16), Integer.MAX_VALUE, 20)));
        world.register(new Overlay(player));

        Star star = new Star(new Vector(14.5, -1.25));
        world.register(star);

        world.register(new Block(new Vector(13.5, 5.5), world.getLoader().getSprite("stone.broken.2"), 3, 1));
        world.register(new Exit(new Vector(13.5, 6.5), new Level3(), star));

        world.register(new Block(new Vector(14, -2.5), world.getLoader().getSprite("stone.broken.2"), 5, 2));
        world.register(new Block(new Vector(15.5, -1), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(12.5, -1), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(15.5, 0), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Vector(12.5, 0), world.getLoader().getSprite("stone.broken.2")));

        Key keyblue = new KeyBlue(new Vector(-7, 7));
        world.register(keyblue);
        Key keyred2 = new KeyRed(new Vector(-12, 0));
        world.register(keyred2);

        world.register(new Door(new Box(new Vector(13, -0.5), new Vector(14, 0.5)), world.getLoader().getSprite("lock.blue.png"), new And(keyblue, keyred2)));
        world.register(new Door(new Box(new Vector(14, -0.5), new Vector(15, 0.5)), world.getLoader().getSprite("lock.red.png"), new And(keyblue, keyred2)));

        Lever lever = new Lever(new Vector(0.25, 3.5), 3);
        world.register(lever);
        Lever lever1 = new Lever(new Vector(13.5, -1.25), 3);
        world.register(lever1);

        world.register(new Mover(new Vector(6, 3.5), new Vector(10, 5.5), world.getLoader().getSprite("stone.1.png"), new Vector(6, -0.5), new Vector(10, 0.5), new Or(lever1, lever), 0.5));
    }
}
