package platform.game;

import platform.game.Actor;
import platform.game.World;
import platform.util.*;

/**
 * Class name: Particle.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 06/12/2016 at 18:56
 **/
public class Particle extends Actor
{
    private Sprite sprite;
    private Vector position;
    private double size;
    private double angle;
    private double duration;
    private double time;

    /**
     * Create a new Particle
     *
     * @param sprite
     */
    public Particle(Sprite sprite)
    {
        this.time = 0;
        this.angle = 0;
        this.sprite = sprite;
    }

    /**
     * Create a new Particle without a Sprite
     */
    public Particle()
    {
        this.time = 0;
        this.angle = 0;
    }

    @Override
    public Box getBox()
    {
        return new Box(position, size, size);
    }

    @Override
    public int getPriority()
    {
        return 1337;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        time += input.getDeltaTime();
        if(time >= duration)
        {
            getWorld().unregister(this);
        }

    }

    /**
     * Set the position of the Particle
     *
     * @param position
     */
    public void setPosition(Vector position)
    {
        this.position = position;
    }

    /**
     * Set the living time of the Particle
     *
     * @param duration
     */
    public void setDuration(double duration)
    {
        this.duration = duration;
    }

    /**
     * set the sprite of the Particle with a String of it's name
     *
     * @param name of the sprite
     */
    public void setSprite(String name)
    {
        System.out.println(getWorld());
        this.sprite = getWorld().getLoader().getSprite("smoke.white.1.png");
    }

    /**
     * set the sprite of the Particle with a sprite
     *
     * @param sprite
     */
    public void setSprite(Sprite sprite)
    {
        this.sprite = sprite;
    }

    /**
     * set the size of the Particle
     *
     * @param size
     */
    public void setSize(double size)
    {
        this.size = size;
    }

    /**
     * set the angle (for the draw method) of the Particle
     *
     * @param angle
     */
    public void setAngle(double angle)
    {
        this.angle = angle;
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(sprite, getBox(), angle);
    }
}
