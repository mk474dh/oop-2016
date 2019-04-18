package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.DropItem;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 * Created by Martina on 11/25/2016.
 */
public class Box1 extends AbstractActor {
    private BackpackImpl backpack=new BackpackImpl(3);
    public Box1(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/box_large.png", 16, 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
        AccessCard accessCard = new AccessCard();
        this.backpack.add(accessCard);

    }

    public void useBy(Actor actor) {
        for(int i=0; i<backpack.getSize(); i++){
            DropItem drop = new DropItem(this.backpack, getWorld(), actor.getX(), actor.getY());
            drop.execute();}

    }
}


