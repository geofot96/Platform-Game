package platform.game.level;

import platform.game.*;
import platform.game.Characters.*;
import platform.game.Characters.Character;
import platform.game.Signals.And;
import platform.game.Signals.Not;
import platform.util.Box;
import platform.util.Vector;

/**
 * Class name: FinalLevel.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 12/12/2016 at 8:08 PM
 **/
public class FinalLevel extends Level
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
        world.register(new Background(world.getLoader().getSprite("background-brown3.png")));

        world.register(new Block(new Vector(-5, -20), new Vector(10, 0), world.getLoader().getSprite("grass.center.png")));

        world.register(new Block(new Vector(-30, -80), new Vector(-5, 50), world.getLoader().getSprite("grass.center.png")));

        world.register(new Block(new Vector(-30, 25), new Vector(33, 50), world.getLoader().getSprite("grass.center.png")));

        world.register(new Block(new Vector(-5, 100), new Vector(200, 150), world.getLoader().getSprite("grass.center.png")));

        // escaliers down //

        world.register(new Block(new Vector(10, -40), new Vector(11, -0.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(11, -40), new Vector(12, -1), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(12, -40), new Vector(13, -1.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(13, -40), new Vector(14, -2), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(14, -40), new Vector(15, -2.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(15, -40), new Vector(16, -3), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(16, -40), new Vector(17, -3.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(17, -40), new Vector(18, -4), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(18, -40), new Vector(19, -4.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(19, -40), new Vector(20, -5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(20, -40), new Vector(21, -5.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(21, -40), new Vector(22, -6), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(22, -40), new Vector(23, -6.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(23, -40), new Vector(24, -7), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(24, -40), new Vector(25, -7.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(25, -40), new Vector(26, -8), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(26, -40), new Vector(27, -8.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(27, -40), new Vector(28, -9), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(28, -40), new Vector(29, -9.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(29, -40), new Vector(30, -10), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(30, -40), new Vector(31, -10.5), world.getLoader().getSprite("grass.center.png")));

        // torches //

        world.register(new Torch(new Vector(11.5, 0), true));
        world.register(new Torch(new Vector(12.5, -0.5), true));
        world.register(new Torch(new Vector(13.5, -1), true));
        world.register(new Torch(new Vector(14.5, -1.5), true));
        world.register(new Torch(new Vector(15.5, -2), true));
        world.register(new Torch(new Vector(16.5, -2.5), true));
        world.register(new Torch(new Vector(17.5, -3), true));
        world.register(new Torch(new Vector(18.5, -3.5), true));
        world.register(new Torch(new Vector(19.5, -4), true));
        world.register(new Torch(new Vector(20.5, -4.5), true));
        world.register(new Torch(new Vector(21.5, -5), true));
        world.register(new Torch(new Vector(22.5, -5.5), true));
        world.register(new Torch(new Vector(23.5, -6), true));
        world.register(new Torch(new Vector(24.5, -6.5), true));
        world.register(new Torch(new Vector(25.5, -7), true));

        // escaliers up //

        world.register(new Block(new Vector(11, 0.5), new Vector(12, 1), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(12, 0), new Vector(13, 1.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(13, -0.5), new Vector(14, 2), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(14, -1), new Vector(15, 2.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(15, -1.5), new Vector(16, 3), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(16, -2), new Vector(17, 3.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(17, -2.5), new Vector(18, 4), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(18, -3), new Vector(19, 4.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(19, -3.5), new Vector(20, 5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(20, -4), new Vector(21, 5.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(21, -4.5), new Vector(22, 6), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(22, -5), new Vector(23, 6.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(23, -5.5), new Vector(24, 7), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(24, -6), new Vector(25, 7.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(25, -6.5), new Vector(26, 8), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(26, -7), new Vector(27, 8.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(27, -7.5), new Vector(28, 9), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(28, -8), new Vector(29, 9.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(29, -8.5), new Vector(30, 10), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(30, -9), new Vector(31, 10.5), world.getLoader().getSprite("grass.center.png")));


        // hell room //

        world.register(new Block(new Vector(31, -2), new Vector(61, 10.5), world.getLoader().getSprite("grass.center.png")));

        KeyRed keyred = new KeyRed(new Vector(36, 11));
        world.register(keyred);

        world.register(new Door(new Box(new Vector(10, 0), new Vector(11, 1)), world.getLoader().getSprite("lock.red.png"), keyred));

        world.register(new Block(new Vector(33, 12.5), new Vector(34, 200), world.getLoader().getSprite("grass.center.png")));


        world.register(new Block(new Vector(60, 10.5), new Vector(61, 200), world.getLoader().getSprite("grass.center.png")));


        // death wall //
        world.register(new Door(new Box(new Vector(50, 10.5), new Vector(51, 11.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 11.5), new Vector(51, 12.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 12.5), new Vector(51, 13.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 13.5), new Vector(51, 14.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 14.5), new Vector(51, 15.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 15.5), new Vector(51, 16.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 16.5), new Vector(51, 17.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 17.5), new Vector(51, 18.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 18.5), new Vector(51, 19.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Door(new Box(new Vector(50, 19.5), new Vector(51, 20.5)), world.getLoader().getSprite("lock.red.png"), keyred));
        world.register(new Block(new Vector(34, 20.5), new Vector(61, 200), world.getLoader().getSprite("grass.center.png")));

        // enemies //

        Frog frog3_1 = new Frog(new Vector(52, 11), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_2 = new Frog(new Vector(52.5, 11), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.RIGHT);
        Frog frog3_3 = new Frog(new Vector(53, 12), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_4 = new Frog(new Vector(53.5, 12), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_5 = new Frog(new Vector(54, 13), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.RIGHT);
        Frog frog3_6 = new Frog(new Vector(54.5, 13), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_7 = new Frog(new Vector(55, 14), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_8 = new Frog(new Vector(56, 14), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.RIGHT);
        Frog frog3_9 = new Frog(new Vector(56.5, 15), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_10 = new Frog(new Vector(57, 15), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_11 = new Frog(new Vector(57.5, 16), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_12 = new Frog(new Vector(58, 16), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.RIGHT);
        Frog frog3_13 = new Frog(new Vector(58.5, 17), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_14 = new Frog(new Vector(59, 17), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.RIGHT);
        Frog frog3_15 = new Frog(new Vector(59.5, 18), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);
        Frog frog3_16 = new Frog(new Vector(60, 18), new Vector(0, 0), 1, 2, 1, Character.Side.ENNEMY, Mob.Category.BIG, Mob.Direction.LEFT);

        world.register(frog3_1);
        world.register(frog3_2);
        world.register(frog3_3);
        world.register(frog3_4);
        world.register(frog3_5);
        world.register(frog3_6);
        world.register(frog3_7);
        world.register(frog3_8);
        world.register(frog3_9);
        world.register(frog3_10);
        world.register(frog3_11);
        world.register(frog3_12);
        world.register(frog3_13);
        world.register(frog3_14);
        world.register(frog3_15);
        world.register(frog3_16);

        Fly fly7_1 = new Fly(new Vector(52, 11), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_2 = new Fly(new Vector(52.5, 11.25), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_3 = new Fly(new Vector(53, 11.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_4 = new Fly(new Vector(53.5, 11.75), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_5 = new Fly(new Vector(54, 12), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_6 = new Fly(new Vector(54.5, 12.25), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_7 = new Fly(new Vector(55, 12.5), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_8 = new Fly(new Vector(55.5, 12.75), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_9 = new Fly(new Vector(56, 13), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_10 = new Fly(new Vector(56.5, 13.25), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_11 = new Fly(new Vector(57, 13.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_12 = new Fly(new Vector(57.5, 13.75), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);

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

        Fly fly7_13 = new Fly(new Vector(52, 14), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_14 = new Fly(new Vector(52.5, 14.25), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_15 = new Fly(new Vector(53, 14.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_16 = new Fly(new Vector(53.5, 14.75), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_17 = new Fly(new Vector(54, 15), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);
        Fly fly7_18 = new Fly(new Vector(54.4, 11.75), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_19 = new Fly(new Vector(55, 12.25), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_20 = new Fly(new Vector(55.5, 12), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_21 = new Fly(new Vector(56, 12.5), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_22 = new Fly(new Vector(56.5, 13), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_23 = new Fly(new Vector(57, 13.5), new Vector(-4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.LEFT);
        Fly fly7_24 = new Fly(new Vector(57.5, 11.5), new Vector(4, 0), 1, 1, 0.3, Character.Side.ENNEMY, Mob.Category.SMALL, Mob.Direction.RIGHT);

        world.register(fly7_13);
        world.register(fly7_14);
        world.register(fly7_15);
        world.register(fly7_16);
        world.register(fly7_17);
        world.register(fly7_18);
        world.register(fly7_19);
        world.register(fly7_20);
        world.register(fly7_21);
        world.register(fly7_22);
        world.register(fly7_23);
        world.register(fly7_24);

        world.register(new Mover(new Vector(32, 100), new Vector(33, 110), world.getLoader().getSprite("stone.7.png"), new Vector(32, 10.5), new Vector(33, 20.5), new And(keyred, new Not(fly7_16)), 2));


        world.register(new Heart(new Vector(27, -8), 100));
        world.register(new Heart(new Vector(28, -8.5), 100));
        world.register(new Heart(new Vector(29, -9), 100));
        world.register(new Heart(new Vector(30, -9.5), 100));

        world.register(new Block(new Vector(30, -40), new Vector(50, -20), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(31, -9), new Vector(50, -2), world.getLoader().getSprite("grass.center.png")));

        // vertical spikes 1 //

        world.register(new Spikes(new Vector(31.25, -10.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -11.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -11.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -12.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -12.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -13.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -13.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -14.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -14.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -15.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -15.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -16.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -16.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -17.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -17.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -18.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -18.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(31.25, -19.25), 1, 3 * Math.PI / 2));


        //horizontal spikes

        world.register(new Spikes(new Vector(31.25, -19.75), 1));
        world.register(new Spikes(new Vector(31.75, -19.75), 1));
        world.register(new Spikes(new Vector(32.25, -19.75), 1));
        world.register(new Spikes(new Vector(32.75, -19.75), 1));
        world.register(new Spikes(new Vector(33.25, -19.75), 1));
        world.register(new Spikes(new Vector(33.75, -19.75), 1));
        world.register(new Spikes(new Vector(34.25, -19.75), 1));
        world.register(new Spikes(new Vector(34.75, -19.75), 1));
        world.register(new Spikes(new Vector(35.25, -19.75), 1));
        world.register(new Spikes(new Vector(35.75, -19.75), 1));
        world.register(new Spikes(new Vector(36.25, -19.75), 1));
        world.register(new Spikes(new Vector(36.75, -19.75), 1));
        world.register(new Spikes(new Vector(37.25, -19.75), 1));
        world.register(new Spikes(new Vector(37.75, -19.75), 1));
        world.register(new Spikes(new Vector(38.25, -19.75), 1));
        world.register(new Spikes(new Vector(38.75, -19.75), 1));
        world.register(new Spikes(new Vector(39.25, -19.75), 1));
        world.register(new Spikes(new Vector(39.75, -19.75), 1));
        world.register(new Spikes(new Vector(40.25, -19.75), 1));
        world.register(new Spikes(new Vector(40.75, -19.75), 1));
        world.register(new Spikes(new Vector(41.25, -19.75), 1));
        world.register(new Spikes(new Vector(41.75, -19.75), 1));
        world.register(new Spikes(new Vector(42.25, -19.75), 1));
        world.register(new Spikes(new Vector(42.75, -19.75), 1));
        world.register(new Spikes(new Vector(43.25, -19.75), 1));
        world.register(new Spikes(new Vector(43.75, -19.75), 1));
        world.register(new Spikes(new Vector(44.25, -19.75), 1));
        world.register(new Spikes(new Vector(44.75, -19.75), 1));
        world.register(new Spikes(new Vector(45.25, -19.75), 1));
        world.register(new Spikes(new Vector(45.75, -19.75), 1));
        world.register(new Spikes(new Vector(46.25, -19.75), 1));
        world.register(new Spikes(new Vector(46.75, -19.75), 1));
        world.register(new Spikes(new Vector(47.25, -19.75), 1));
        world.register(new Spikes(new Vector(47.75, -19.75), 1));
        world.register(new Spikes(new Vector(48.25, -19.75), 1));
        world.register(new Spikes(new Vector(48.75, -19.75), 1));
        world.register(new Spikes(new Vector(49.25, -19.75), 1));
        world.register(new Spikes(new Vector(49.75, -19.75), 1));

        // vertical spikes 2
        world.register(new Spikes(new Vector(49.75, -10.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -11.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -11.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -12.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -12.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -13.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -13.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -14.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -14.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -15.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -15.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -16.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -16.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -17.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -17.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -18.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -18.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(49.75, -19.25), 1, Math.PI / 2));

        world.register(new Block(new Vector(50, -40), new Vector(100, -10.5), world.getLoader().getSprite("grass.center.png")));

        world.register(new Block(new Vector(55, -10.5), new Vector(100, -4), world.getLoader().getSprite("grass.center.png")));

        world.register(new Spikes(new Vector(54.75, -10.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -9.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -9.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -8.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -8.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -7.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -7.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -6.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -6.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -5.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -5.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -4.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(54.75, -4.25), 1, Math.PI / 2));


        Oscillator oscillator1 = new Oscillator(2, false);
        world.register(oscillator1);
        world.register(new Mover(new Vector(34, -16), new Vector(35, -15), world.getLoader().getSprite("stone.broken.2.png"), new Vector(37, -13), new Vector(38, -12), oscillator1, 1));
        world.register(new Mover(new Vector(42, -19), new Vector(43, -18), world.getLoader().getSprite("stone.broken.2.png"), new Vector(42, -13), new Vector(43, -12), oscillator1, 1));


        world.register(new Jumper(new Vector(53, -10), 0.5));
        world.register(new Block(new Vector(51, -5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Heart(new Vector(51, -4), 3));

        Lever lever = new Lever(new Vector(58, -3.5), 2.5);
        world.register(lever);

        world.register(new Mover(new Vector(61, -4), new Vector(62, 4), world.getLoader().getSprite("stone.7.png"), new Vector(61, 4), new Vector(62, 8), lever, 1));
        world.register(new Spikes(new Vector(61.5, -3.75), 1));

        // vertical spikes 3

        world.register(new Spikes(new Vector(61.25, 4.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 4.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 5.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 5.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 6.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 6.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 7.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 7.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 8.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 8.75), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 9.25), 1, 3 * Math.PI / 2));
        world.register(new Spikes(new Vector(61.25, 9.75), 1, 3 * Math.PI / 2));

        // vertical spikes 4

        world.register(new Spikes(new Vector(99.75, -3.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -3.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -2.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -2.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -1.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -1.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -0.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, -0.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, 0.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, 0.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, 1.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, 1.75), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, 2.25), 1, Math.PI / 2));
        world.register(new Spikes(new Vector(99.75, 2.75), 1, Math.PI / 2));

        world.register(new Block(new Vector(100, -40), new Vector(130, 20.5), world.getLoader().getSprite("grass.center.png")));
        world.register(new Block(new Vector(61, 20.5), new Vector(130, 42), world.getLoader().getSprite("grass.center.png")));

        //boses and ultra boss //

        Frog frog8 = new Frog(new Vector(70, -4), new Vector(0, 0), 2, 10, 3, Character.Side.ENNEMY, Mob.Category.BOSS, Mob.Direction.LEFT);
        world.register(frog8);
        Frog frog9 = new Frog(new Vector(90, -4), new Vector(0, 0), 2, 10, 3, Character.Side.ENNEMY, Mob.Category.BOSS, Mob.Direction.RIGHT);
        world.register(frog9);
        Frog frog10 = new Frog(new Vector(80, -4), new Vector(0, 0), 2, 10, 5, Character.Side.ENNEMY, Mob.Category.SUPERBOSS, Mob.Direction.LEFT);
        world.register(frog10);

        world.register(new Mover(new Vector(62, -6), new Vector(100, -4), world.getLoader().getSprite("stone.3.png"), new Vector(62, 12.5), new Vector(100, 14.5), new And(new And(frog8, frog9), frog10), 0.3));

        // princess prison //

        world.register(new Block(new Vector(76, 16.5), new Vector(84, 17.5), world.getLoader().getSprite("stone.3.png")));
        world.register(new Block(new Vector(83, 17.5), new Vector(84, 20.5), world.getLoader().getSprite("stone.7.png")));
        world.register(new Block(new Vector(76, 19.5), new Vector(83, 20.5), world.getLoader().getSprite("stone.3.png")));
        world.register(new Princess(new Vector(82.75, 17.75)));

        world.register(new WoodBox(new Vector(77.5, 18), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(78.5, 18), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(79.5, 18), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(80.5, 18), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(81.5, 18), world.getLoader().getSprite("box.empty.png")));

        world.register(new WoodBox(new Vector(77.5, 19), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(78.5, 19), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(79.5, 19), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(80.5, 19), world.getLoader().getSprite("box.empty.png")));
        world.register(new WoodBox(new Vector(81.5, 19), world.getLoader().getSprite("box.empty.png")));
    }
}
