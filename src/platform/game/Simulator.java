package platform.game;

import platform.game.level.FinalLevel;
import platform.game.level.Level4;
import platform.util.SortedCollection;
import platform.game.level.Selection;
import platform.game.level.Level;

import java.util.ArrayList;
import java.util.List;

import platform.util.*;

/**
 * Basic implementation of world, managing a complete collection of actors.
 */
public class Simulator implements World
{

    private Loader loader;
    private Vector currentCenter;
    private double currentRadius;
    private Vector expectedCenter;
    private double expectedRadius;
    SortedCollection<Actor> actors = new SortedCollection<Actor>();
    List<Actor> registered;
    List<Actor> unregistered;
    Level next = new Selection();
    boolean transition = true;

    /**
     * Create a new simulator.
     *
     * @param loader associated loader, not null
     * @param args   level arguments, not null
     */
    public Simulator(Loader loader, String[] args)
    {
        if(loader == null)
            throw new NullPointerException();
        this.loader = loader;
        expectedCenter = Vector.ZERO;
        expectedRadius = 10.0;
        currentCenter = Vector.ZERO;
        currentRadius = 10.0;
        registered = new ArrayList<Actor>();
        unregistered = new ArrayList<Actor>();
    }

    @Override
    public void setView(Vector center, double radius)
    {
        if(center == null)
            throw new NullPointerException();
        if(radius <= 0.0)
            throw new IllegalArgumentException("radius must be positive");
        currentCenter = center;
        currentRadius = radius;
    }

    /**
     * register an actor in a list of actors waiting to be registered to the world
     *
     * @param actor the actor to be registered
     */
    @Override
    public void register(Actor actor)
    {
        registered.add(actor);
    }

    /**
     * register an actor in a list of actors waiting to be unregistered from the world
     *
     * @param actor the actor to be unregistered
     */
    @Override
    public void unregister(Actor actor)
    {
        unregistered.add(actor);
    }

    /**
     * Simulate a single step of the simulation.
     *
     * @param input  input object to use, not null
     * @param output output object to use, not null
     */
    public void update(Input input, Output output)
    {

        // si un acteur a mis transition à true pour demander le passage
        // à un autre niveau :
        if(transition)
        {
            if(next == null)
                next = Level.createDefaultLevel();
            // si un acteur a appelé setNextLevel , next ne sera pas null :
            Level level = next;
            transition = false;
            next = null;
            actors.clear();
            registered.clear();
            // tous les anciens acteurs sont désenregistrés ,
            // y compris le Level précédent :
            unregistered.clear();
            register(level);
        }

        View view = new View(input, output);

        view.setTarget(currentCenter, currentRadius);
        for(Actor a : actors)
            a.preUpdate(input);
        for(Actor actor : actors)
            for(Actor other : actors)
                if(actor.getPriority() > other.getPriority())
                    actor.interact(other);
        // Apply update
        for(Actor a : actors)
            a.update(view);
        // Draw everything
        for(Actor a : actors.descending())
            a.draw(view, view);
        for(Actor a : actors)
            a.postUpdate(input);
        //register all actors from the list registered to the list actors
        for(int i = 0; i < registered.size(); ++i)
        {
            Actor actor = registered.get(i);
            if(!actors.contains(actor))
            {
                actors.add(actor);
                actor.register(this);
            }
        }
        registered.clear();
        //unregister all actors from the list unregistered from the list actors
        for(int i = 0; i < unregistered.size(); ++i)
        {
            Actor actor = unregistered.get(i);
            actors.remove(actor);
            actor.unregister();
        }
        unregistered.clear();
    }

    @Override
    public void nextLevel()
    {
        transition = true;
    }

    @Override
    public void setNextLevel(Level level)
    {
        next = level;
    }

    @Override
    public Loader getLoader()
    {
        return loader;
    }

    @Override
    public int hurt(Box area, Actor instigator, Actor.Damage type, double amount, Vector location)
    {
        int victims = 0;
        for(Actor actor : actors)
            if(area.isColliding(actor.getBox()))
                if(actor.hurt(instigator, type, amount, location))
                    ++victims;
        return victims;
    }

}
