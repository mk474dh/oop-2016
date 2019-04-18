package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;

/**
 * Created by Martina on 11/25/2016.
 */
public class Bomb extends AbstractActor implements Item {

    public Bomb(String name,int nationTime) {
        super(name);
        System.out.println(nationTime);
        Animation normalAnimation = new Animation("sprites/bomb.png", 16, 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }

 
}
