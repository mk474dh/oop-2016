package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 * Created by Martina on 11/14/2016.
 */
public class Money extends AbstractActor implements Item {

    private Animation animation= new Animation("sprites/money.png", 16, 16, 10);

    public Money() {
        super("Money");
        animation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(animation);

    }


}
