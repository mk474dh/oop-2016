package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 * Created by Martina on 11/25/2016.
 */
public class Computer extends AbstractActor {

    public Computer(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/computer.png", 48, 80, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }
}
