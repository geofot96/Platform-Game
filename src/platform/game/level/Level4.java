package platform.game.level;

import platform.game.*;
import platform.game.Characters.*;
import platform.game.Characters.Character;
import platform.game.Signals.And;
import platform.game.Signals.Not;
import platform.util.Box;
import platform.util.Vector;

/**
 * Class name: Level4.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 12/12/2016 at 2:39 PM
 **/
public class Level4 extends Level
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

        Player player = new Player(new Vector(0, 0), new Vector(0, 0), 5, 5);
        world.register(player);
        world.register(new Overlay(player));

        // add background //
        world.register(new Background(world.getLoader().getSprite("sheet.old.paper.png")));

        // floor beginning //
        world.register(new Block(new Vector(-5, -20), new Vector(46, 0), world.getLoader().getSprite("grass.center.png")));

        // left wall beginning //
        world.register(new Block(new Vector(-30, -80), new Vector(-5, 50), world.getLoader().getSprite("grass.center.png")));

        //"roof" beginning //
        world.register(new Block(new Vector(-5, 5), new Vector(200, 30), world.getLoader().getSprite("grass.center.png")));

        // torches in the first room //
        Torch torch1 = new Torch(new Vector(-2, 3), false);
        Torch torch2 = new Torch(new Vector(2, 3), false);
        world.register(torch1);
        world.register(torch2);

        // first door //
        world.register(new Door(new Box(new Vector(5, 0), new Vector(6, 1)), world.getLoader().getSprite("lock.red.png"), new And(torch1, torch2)));

        // vertical wall //
        world.register(new Block(new Vector(5, 1), new Vector(6, 5), world.getLoader().getSprite("grass.center.png")));

        // frogs second room //
        Frog frog1 = new Frog(new Vector(10, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Frog frog2 = new Frog(new Vector(15, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        world.register(frog1);
        world.register(frog2);

        // lock second room //
        world.register(new Door(new Box(new Vector(25, 0), new Vector(26, 1)), world.getLoader().getSprite("lock.red.png"), new And(frog1, frog2)));

        // vertical wall //
        world.register(new Block(new Vector(25, 1), new Vector(26, 5), world.getLoader().getSprite("grass.center.png")));

        //--------------------THIRD ROOM-------------------//

        // frogs //
        Frog frog3_1 = new Frog(new Vector(30, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.NORMAL, Mob.Direction.LEFT);
        Frog frog3_2 = new Frog(new Vector(33, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.NORMAL, Mob.Direction.LEFT);
        Frog frog3_3 = new Frog(new Vector(36, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.NORMAL, Mob.Direction.LEFT);
        Frog frog3_4 = new Frog(new Vector(39, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.NORMAL, Mob.Direction.LEFT);
        Frog frog3_5 = new Frog(new Vector(42, 0), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.NORMAL, Mob.Direction.LEFT);

        world.register(frog3_1);
        world.register(frog3_2);
        world.register(frog3_3);
        world.register(frog3_4);
        world.register(frog3_5);

        Lever lever3_1 = new Lever(new Vector(45.5, 0.5), 7);
        world.register(lever3_1);

        // vertical wall //
        world.register(new Block(new Vector(45, 1), new Vector(46, 5), world.getLoader().getSprite("grass.center.png")));

        //-----------------FOURTH "ROOM" (space of the mover)-------------------//

        // mover //
        world.register(new Mover(new Vector(60, -1), new Vector(64, 0), world.getLoader().getSprite("stone.1.png"), new Vector(46, -1), new Vector(50, 0), lever3_1, 0.2));

        // Ground under the mover //
        world.register(new Block(new Vector(-46, -30), new Vector(64, -10), world.getLoader().getSprite("grass.center.png")));

        // Spikes under the mover //
        world.register(new Spikes(new Vector(46.25, -9.75), 1));
        world.register(new Spikes(new Vector(46.75, -9.75), 1));
        world.register(new Spikes(new Vector(47.25, -9.75), 1));
        world.register(new Spikes(new Vector(47.75, -9.75), 1));
        world.register(new Spikes(new Vector(48.25, -9.75), 1));
        world.register(new Spikes(new Vector(48.75, -9.75), 1));
        world.register(new Spikes(new Vector(49.25, -9.75), 1));
        world.register(new Spikes(new Vector(49.75, -9.75), 1));
        world.register(new Spikes(new Vector(50.25, -9.75), 1));
        world.register(new Spikes(new Vector(50.75, -9.75), 1));
        world.register(new Spikes(new Vector(51.25, -9.75), 1));
        world.register(new Spikes(new Vector(51.75, -9.75), 1));
        world.register(new Spikes(new Vector(52.25, -9.75), 1));
        world.register(new Spikes(new Vector(52.75, -9.75), 1));
        world.register(new Spikes(new Vector(53.25, -9.75), 1));
        world.register(new Spikes(new Vector(53.75, -9.75), 1));
        world.register(new Spikes(new Vector(54.25, -9.75), 1));
        world.register(new Spikes(new Vector(54.75, -9.75), 1));
        world.register(new Spikes(new Vector(55.25, -9.75), 1));
        world.register(new Spikes(new Vector(55.75, -9.75), 1));
        world.register(new Spikes(new Vector(56.25, -9.75), 1));
        world.register(new Spikes(new Vector(56.75, -9.75), 1));
        world.register(new Spikes(new Vector(57.25, -9.75), 1));
        world.register(new Spikes(new Vector(57.75, -9.75), 1));
        world.register(new Spikes(new Vector(58.25, -9.75), 1));
        world.register(new Spikes(new Vector(58.75, -9.75), 1));
        world.register(new Spikes(new Vector(59.25, -9.75), 1));
        world.register(new Spikes(new Vector(59.75, -9.75), 1));
        world.register(new Spikes(new Vector(60.25, -9.75), 1));
        world.register(new Spikes(new Vector(60.75, -9.75), 1));
        world.register(new Spikes(new Vector(61.25, -9.75), 1));
        world.register(new Spikes(new Vector(61.75, -9.75), 1));
        world.register(new Spikes(new Vector(62.25, -9.75), 1));
        world.register(new Spikes(new Vector(62.75, -9.75), 1));
        world.register(new Spikes(new Vector(63.25, -9.75), 1));
        world.register(new Spikes(new Vector(63.75, -9.75), 1));

        // vertical wall at the end of the mover //
        world.register(new Block(new Vector(64, -30), new Vector(69, 0), world.getLoader().getSprite("grass.center.png")));

        // Lever after the mover //
        Lever lever3_2 = new Lever(new Vector(67.5, 0.5), 15);
        world.register(lever3_2);

        // Mover going down //
        world.register(new Mover(new Vector(69, -1), new Vector(72, 0), world.getLoader().getSprite("stone.1.png"), new Vector(69, -16), new Vector(72, -15), lever3_2, 0.1));

        // vertical wall placed right at the mover (top) //
        world.register(new Block(new Vector(72, -10), new Vector(75, 0), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(75, -10), new Vector(200, 30), world.getLoader().getSprite("grass.center.png")));

        //-------------------------------FIFTH "ROOM"--------------------------------//

        //horizontal floor below the normal level and after the second mover //
        world.register(new Block(new Vector(75, -30), new Vector(200, -15), world.getLoader().getSprite("grass.center.png")));

        // torches //
        Torch torch5_1 = new Torch(new Vector(78, -12), true);
        Torch torch5_2 = new Torch(new Vector(80, -12), true);
        Torch torch5_3 = new Torch(new Vector(82, -12), true);
        world.register(torch5_1);
        world.register(torch5_2);
        world.register(torch5_3);

        // floor under the mover //
        world.register(new Block(new Vector(69, -40), new Vector(200, -20), world.getLoader().getSprite("grass.center.png")));

        // spikes under the mover //
        world.register(new Spikes(new Vector(69.25, -19.75), 1));
        world.register(new Spikes(new Vector(69.75, -19.75), 1));
        world.register(new Spikes(new Vector(70.25, -19.75), 1));
        world.register(new Spikes(new Vector(70.75, -19.75), 1));
        world.register(new Spikes(new Vector(71.25, -19.75), 1));
        world.register(new Spikes(new Vector(71.75, -19.75), 1));
        world.register(new Spikes(new Vector(72.25, -19.75), 1));
        world.register(new Spikes(new Vector(72.75, -19.75), 1));
        world.register(new Spikes(new Vector(73.25, -19.75), 1));
        world.register(new Spikes(new Vector(73.75, -19.75), 1));
        world.register(new Spikes(new Vector(74.25, -19.75), 1));
        world.register(new Spikes(new Vector(74.75, -19.75), 1));

        // block for jumping back //
        world.register(new Block(new Vector(69, -19), new Vector(70, -18), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(71, -17), new Vector(72, -16), world.getLoader().getSprite("grass.center.png")));

        // door for going to the sixth room //
        world.register(new Door(new Box(new Vector(85, -15), new Vector(86, -14)), world.getLoader().getSprite("lock.red.png"), new And(new And(torch5_1, torch5_3), new Not(torch5_2))));

        // vertical wall //
        world.register(new Block(new Vector(85, -14), new Vector(86, -10), world.getLoader().getSprite("grass.center.png")));

        // hearth //
        world.register(new Heart(new Vector(80, -14.5), 100));

        //--------------SEVENTH ROOM------------------------//

        // frogs (set to BIG in order to be stronger and bigger) //
        Frog frog7_1 = new Frog(new Vector(92, -14.5), new Vector(0, 0), 1, 4, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog7_2 = new Frog(new Vector(97, -14.5), new Vector(0, 0), 1, 4, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog7_3 = new Frog(new Vector(109, -14.5), new Vector(0, 0), 1, 4, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog7_4 = new Frog(new Vector(95, -14.5), new Vector(0, 0), 1, 4, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.RIGHT);
        world.register(frog7_1);
        world.register(frog7_2);
        world.register(frog7_3);
        world.register(frog7_4);

        // flies //
        Fly fly7_1 = new Fly(new Vector(92, -14.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_2 = new Fly(new Vector(94, -14.7), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_3 = new Fly(new Vector(96, -14.3), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_4 = new Fly(new Vector(98, -14.1), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_5 = new Fly(new Vector(100, -13.9), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_6 = new Fly(new Vector(102, -13.7), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_7 = new Fly(new Vector(97, -13.5), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_8 = new Fly(new Vector(94, -12.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_9 = new Fly(new Vector(96, -13.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_10 = new Fly(new Vector(103, -12.6), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_11 = new Fly(new Vector(106, -13.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_12 = new Fly(new Vector(110, -13.7), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        world.register(fly7_1);
        world.register(fly7_2);
        world.register(fly7_3);
        world.register(fly7_4);
        world.register(fly7_5);
        world.register(fly7_6);
        world.register(fly7_7);
        world.register(fly7_8);
        world.register(fly7_9);
        world.register(fly7_10);
        world.register(fly7_11);
        world.register(fly7_12);

        // vertical wall //
        world.register(new Block(new Vector(110, -14), new Vector(111, -10), world.getLoader().getSprite("grass.center.png")));

        //------------EIGHT ROOM-------------//

        // hearts //
        world.register(new Heart(new Vector(113, -14.5), 100));
        world.register(new Heart(new Vector(113, -13.5), 100));
        world.register(new Heart(new Vector(113, -12.5), 100));

        // frog boss //
        Frog frog8 = new Frog(new Vector(120, -13.5), new Vector(0, 0), 2, 10, 3, Character.Side.ENNEMY, Mob.Category.BOSS, Mob.Direction.LEFT);
        world.register(frog8);

        // vertical wall //
        world.register(new Block(new Vector(130, -14), new Vector(136, -10), world.getLoader().getSprite("grass.center.png")));

        //------------FINAL ROOM---------------//

        // exit //
        world.register(new Exit(new Vector(135.5, -14.5), new FinalLevel(), frog8));

        // vertical wall //
        world.register(new Block(new Vector(136, -15), new Vector(150, -10), world.getLoader().getSprite("grass.center.png")));
    }
}
