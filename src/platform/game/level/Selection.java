package platform.game.level;

import platform.game.*;
import platform.game.Characters.Player;
import platform.game.Signals.ConstSignal;
import platform.util.Box;
import platform.util.Vector;

/**
 * Class name: Selection.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 08/12/2016 at 11:59 AM
 **/
public class Selection extends Level
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

        Welcome welcome = new Welcome(2);
        world.register(welcome);

        //add background //
        world.register(new Background(world.getLoader().getSprite("urban-landscape-background-Preview-modified.png")));

        // Create blocks //
        world.register(new Block(new Box(new Vector(0, 4), 12, 2), world.getLoader().getSprite("stone.2.png")));
        world.register(new Block(new Vector(0, 7.5), world.getLoader().getSprite("stone.1.png")));

        // first level //
        world.register(new Block(new Box(new Vector(-4, 6.5), 0.5, 0.7), world.getLoader().getSprite("digit.1.png")));
        world.register(new Block(new Vector(-4, 6.5), world.getLoader().getSprite("box.item.png")));
        world.register(new Exit(new Vector(-4, 7.5), new BasicLevel(), new ConstSignal(true)));

        // second level //
        world.register(new Block(new Box(new Vector(4, 6.5), 0.5, 0.7), world.getLoader().getSprite("digit.2.png")));
        world.register(new Block(new Vector(4, 6.5), world.getLoader().getSprite("box.item.png")));
        world.register(new Exit(new Vector(4, 7.5), new Level2(), new ConstSignal(true)));

        // third level //
        world.register(new Block(new Box(new Vector(-2, 8.5), 0.5, 0.7), world.getLoader().getSprite("digit.3.png")));
        world.register(new Block(new Vector(-2, 8.5), world.getLoader().getSprite("box.item.png")));
        world.register(new Exit(new Vector(-2, 9.5), new Level3(), new ConstSignal(true)));

        // fourth level //
        world.register(new Block(new Box(new Vector(2, 8.5), 0.5, 0.7), world.getLoader().getSprite("digit.4.png")));
        world.register(new Block(new Vector(2, 8.5), world.getLoader().getSprite("box.item.png")));
        world.register(new Exit(new Vector(2, 9.5), new Level4(), new ConstSignal(true)));

        // final level //
        world.register(new Exit(new Vector(0, 11.5), new FinalLevel(), new ConstSignal(true)));

        // Create player //
        Player player = new Player(new Vector(0, 5), new Vector(0, 0), 5, 5);
        world.register(player);
        world.register(new Limits(new Box(new Vector(0, -12), Integer.MAX_VALUE, 30)));
        world.register(new Overlay(player));

    }
}
