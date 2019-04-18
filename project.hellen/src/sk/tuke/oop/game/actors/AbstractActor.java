package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;


import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by Martina on 11/5/2016.
 */
public abstract class AbstractActor implements Actor {
    private String name;
    private int x;
    private int y;
    private Animation animation;
    private transient World world;
    private List<Actor> actors;
    private Actor actor;

    public AbstractActor(String name){
        this.name=name;
    }


    public List getIntersectingActors(){
        return actors;
    }

    public void setIntersectingActors(List<Actor> actors ,Actor element){
       this.actors=actors;
        actors.add(element);
    }

    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }


    public int getWidth() {
        return this.animation.getWidth();
    }


    public int getHeight() {
        return this.animation.getHeight();
    }


    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Animation getAnimation() {
        return this.animation;
    }


    public void setAnimation(Animation animation) {
        this.animation = animation;
    }


    public boolean intersects(Actor actor) {
        return (new Rectangle2D.Float((float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight())).intersects((double)actor.getX(), (double)actor.getY(), (double)actor.getWidth(), (double)actor.getHeight());
    }


    public void addedToWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return this.world;
    }


    public String getName() {
        return this.name;
    }


    public String toString() {
        String name = "";
        if(this.name != null) {
            name = name + this.name;
        }

        name = name + ":" + this.getClass().getSimpleName() + " position:" + this.getX() + " " + this.getY() + " rotation:" + this.getAnimation().getRotation();
        return name;
    }

    public Actor getActorByName( String name){
        for (Iterator<Actor> iter = getWorld().iterator(); iter.hasNext(); ) {
            Actor element = iter.next();
            if (Objects.equals(element.getName(), name)) {
                actor=element;
            }
            }
            return actor;
        }


    public void act(){
       System.out.println("jej");

    }


}
