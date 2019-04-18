package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;

/**
 * Created by Martina on 11/25/2016.
 */
public class Buttonc3 extends AbstractActor implements Item {

    public Buttonc3(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/button_red.png", 16, 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }
}
