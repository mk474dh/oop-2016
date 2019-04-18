package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.Cooler;

/**
 * Created by Martina on 10/18/2016.
 */

public class Wrench extends AbstractTool implements Usable,Item {
    public Wrench() {
        super(2);
        Animation wrenchAnimation = new Animation("sprites/wrench.png", 16, 16, 10);
        wrenchAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(wrenchAnimation);

    }


    public void useBy(Actor actor) {
        Cooler cooler = (Cooler) actor;
        cooler.setOn(1);
        cooler.getAnimation().start();

    }
}