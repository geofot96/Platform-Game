package platform.game;

import platform.util.*;

/**
 * Simple solid actor that does nothing.
 */
public class Block extends Actor
{
    private Box box;
    private Sprite sprite;
    Vector center;
    final static double SIZE = 1;

    /**
     * constructor of block in case the user inserts the coordinates as doubles
     *
     * @param x1     first coordinate of first box
     * @param x2     second coordinate of first box
     * @param x3     first coordinate of second box
     * @param x4     second coordinate of second box
     * @param sprite sprite of the block
     */
    public Block(double x1, double x2, double x3, double x4, Sprite sprite)
    {
        box = new Box(new Vector(x1, x2), new Vector(x3, x4));
        this.sprite = sprite;
    }

    /**
     * constructor of block in case the user inserts the coordinates as a box
     *
     * @param b gives value to box
     * @param s gives value to sprite
     */
    public Block(Box b, Sprite s)
    {
        box = b;
        sprite = s;
    }

    /**
     * constructor of block in case the user inserts the coordinates as Vectors
     *
     * @param v1 first vector coordinate
     * @param v2 second vector coordinate
     * @param s  gives value to sprite
     */
    public Block(Vector v1, Vector v2, Sprite s)
    {
        box = new Box(v1, v2);
        sprite = s;
    }

    /**
     * constructor of Block to create a 1 by 1 block at a specific point determined by it's center
     *
     * @param center the center of the box
     * @param s      the sprite of the block
     */
    public Block(Vector center, Sprite s)
    {
        box = new Box(center, SIZE, SIZE);
        sprite = s;
    }

    /**
     * constructor of Block to create a rectangular block at a specific point determined by it's center
     *
     * @param center the center of the block
     * @param s      sprite of the block
     * @param size   the length of the block's sides
     */
    public Block(Vector center, Sprite s, double size)
    {
        box = new Box(center, size, size);
        sprite = s;
    }

    /**
     * constructor of Block to create a block at a specific point determined by it's center giving directly the length and with
     *
     * @param center the center of the block
     * @param s      sprite of the block
     * @param width  the width of the block
     * @param height the height of the block
     */
    public Block(Vector center, Sprite s, double width, double height)
    {
        box = new Box(center, width, height);
        sprite = s;
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(sprite, box);
    }

    @Override
    public boolean isSolid()
    {
        return true;
    }

    @Override
    public Box getBox()
    {
        return box;
    }

    @Override
    public Vector getPosition()
    {
        Box box = getBox();
        if(box == null)
            return null;
        return box.getCenter();
    }

    @Override
    public int getPriority()
    {
        return 0;
    }

    /**
     * public method to return the sprite of the block because the sprite is a private attribute
     *
     * @return the sprite of the block
     */
    public Sprite returnSprite()
    {
        return sprite;
    }
}
