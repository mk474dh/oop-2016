package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.DropItem;
import sk.tuke.oop.game.items.BackpackImpl;

import java.util.Iterator;

/**
 * Created by Martina on 11/25/2016.
 */
public class Buttonz3 extends AbstractActor implements Observer {
    private BackpackImpl backpack=new BackpackImpl(3);

    public Buttonz3(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/button_green.png", 16, 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
        Buttonc3 buttonc = new Buttonc3("cerv");
        this.backpack.add(buttonc);
    }

    public void act() {
        for (Iterator<Actor> iter = getWorld().iterator(); iter.hasNext(); ) {
            Actor element = iter.next();
            if (element instanceof Switch2) {
                ((Switch2) element).addObserver(this);
            }
        }
    }
    public void giveNotice() {
        DropItem drop = new DropItem(backpack, getWorld(), getX(), getY());
        drop.execute();
    }
}
