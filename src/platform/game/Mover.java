package platform.game;

import platform.game.Signals.Signal;
import platform.util.*;

/**
 * Class name: Mover.class
 * Created by: Georgios Fotiadis and Francesco Berla
 * Date: 05/12/2016 at 1:19 PM
 **/
public class Mover extends Block implements Signal
{
    Vector on;
    Vector off;
    Signal signal;
    Vector position;
    double current;
    double velocity;

    /**
     * constructor of the class Mover
     *
     * @param off1 the position of the lower left corner of the box containing the mover in it's initial position
     * @param off2 the position of the higher right corner of the box containing the mover in it's initial position
     * @param s the sprite of the mover
     * @param on1 the position of the lower left corner of the box containing the mover in it's final position
     * @param on2 the position of the higher right corner of the box containing the mover in it's final position
     * @param signal the signal to determine oif the mover should be moving or not
     * @param velocity the velocity with which the mover moves
     */
    public Mover(Vector off1, Vector off2, Sprite s, Vector on1, Vector on2, Signal signal, double velocity)
    {
        super(off1, off2, s);
        this.on = on1;
        this.off = super.getBox().getCenter();
        this.on = new Box(on1, on2).getCenter();
        position = this.off;
        this.current = 0;
        this.signal = signal;
        this.velocity = velocity;
    }

    @Override
    public void update(Input input)
    {
        super.update(input);
        if(signal.isActive())
        {
            current += input.getDeltaTime() * velocity;
            if(current > 1.0)
                current = 1.0;
        }
        else
        {
            current -= input.getDeltaTime() * velocity;
            if(current < 0.0)
                current = 0.0;
        }
    }

    @Override
    public Box getBox()
    {
        Vector diff = on.sub(off);
        return new Box(new Vector(current * diff.getX() + position.getX(), current * diff.getY() + position.getY()), super.getBox().getWidth(), super.getBox().getHeight());
    }

    @Override
    public void draw(Input input, Output output)
    {
        output.drawSprite(returnSprite(), getBox());
    }

    @Override
    public boolean isActive()
    {
        return signal.isActive();
    }
}
