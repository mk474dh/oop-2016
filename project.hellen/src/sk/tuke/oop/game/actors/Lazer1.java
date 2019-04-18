package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

import java.util.Iterator;


/**
 * Created by Martina on 11/25/2016.
 */
public class Lazer1 extends AbstractActor implements Observer {

    public Lazer1(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/laser.png", 48, 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }

    public void act(){
        for (Iterator<Actor> iter = getWorld().iterator(); iter.hasNext(); ) {
            Actor element = iter.next();
            if(element instanceof Reactor){
                ((Reactor) element).addObserver(this);
            }
        }}

    public void giveNotice() {
        getAnimation().stopAt(3);
    }
}
