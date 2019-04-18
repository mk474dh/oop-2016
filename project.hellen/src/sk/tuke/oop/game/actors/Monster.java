package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;


/**
 * Created by Martina on 11/25/2016.
 */
public class Monster extends AbstractActor {
    public Monster(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/monster_2.png", 127, 78, 250);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }
    
}
