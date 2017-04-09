package platform.game.level;

import platform.game.*;
import platform.game.Characters.Player;
import platform.util.Box;
import platform.util.Vector;

public class BasicLevel extends Level
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

        world.register(new Background(world.getLoader().getSprite("colored_grass")));

        // blocks creation //

        world.register(new Block(new Box(new Vector(0, 0), 5, 2), world.getLoader().getSprite("stone.broken.2")));
        world.register(new Block(new Box(new Vector(-1.5, 1.5), 1, 1), world.getLoader().getSprite("stone.broken.1")));
        world.register(new Block(new Box(new Vector(7, 8), 4, 2), world.getLoader().getSprite("stone.broken.2")));

        // Create player //
        Player player = new Player(new Vector(0, 4), new Vector(0, 0), 5, 5);
        world.register(player);

        world.register(new Overlay(player));
        world.register(new Limits(new Box(new Vector(0, -16), Integer.MAX_VALUE, 30)));

        // key and doors creation //
        Key keyred = new KeyRed(new Vector(0, 5));
        world.register(keyred);
        world.register(new Door(new Box(new Vector(-0.5, 1), new Vector(0.5, 2)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(-0.5, 2), new Vector(0.5, 3)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(0.5, 2), new Vector(1.5, 3)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(0.5, 2), new Vector(1.5, 3)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(1.5, 2), new Vector(2.5, 3)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(1.5, 1), new Vector(2.5, 2)), world.getLoader().getSprite("lock.red.png"), keyred));

        Lever lever = new Lever(new Vector(1, 1.25), 6);
        world.register(lever);

        world.register(new Mover(new Vector(3, -1), new Vector(5, 1), world.getLoader().getSprite("stone.1.png"), new Vector(3, 7), new Vector(5, 9), lever, 0.3));

        Star star = new Star(new Vector(7, 10));
        world.register(star);

        world.register(new Exit(new Vector(-1.5, 2.5), new Level2(), star));
    }

}
