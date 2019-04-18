package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 * Created by Martina on 11/25/2016.
 */
public class Electricity extends AbstractActor {

    public Electricity(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/electricity.png", 16, 48, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }
}
