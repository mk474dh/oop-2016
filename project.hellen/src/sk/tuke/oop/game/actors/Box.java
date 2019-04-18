package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 * Created by Martina on 11/25/2016.
 */
public class Box extends AbstractActor {

    public Box(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/box_large.png", 16 , 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }
}
