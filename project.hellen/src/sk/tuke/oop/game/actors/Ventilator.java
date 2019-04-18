package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Usable;


/**
 * Created by Martina on 11/8/2016.
 */
public class Ventilator extends AbstractActor implements Usable {
    private Animation animation = new Animation("sprites/ventilator.png", 32, 32, 100);
    private int on = 0;


    public Ventilator() {
        super("Ventilator");
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
    }


    public void useBy(Actor actor) {
        if (on == 0) {
            on = 1;
            animation.start();
        } else {
            on = 0;
            animation.stop();
        }
    }

}