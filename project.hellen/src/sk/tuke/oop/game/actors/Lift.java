package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 * Created by Martina on 12/10/2016.
 */
public class Lift extends AbstractActor {
        public Lift(String name) {
            super(name);
            Animation normalAnimation = new Animation("sprites/lift.png", 48, 48, 100);
            normalAnimation.setPingPong(true);
            // set actor's animation to just created Animation object
            setAnimation(normalAnimation);
        }
}
