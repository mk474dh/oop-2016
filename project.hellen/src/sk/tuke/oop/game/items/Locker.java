package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.DropItem;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Bomb;

/**
 * Created by Martina on 11/19/2016.
 */
public class Locker extends AbstractActor implements Usable {
    private BackpackImpl backpack=new BackpackImpl(3);


    public Locker() {
        super("Locker");
        Animation animation = new Animation("sprites/locker.png", 16, 16, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
        Ammo ammo = new Ammo();
        this.backpack.add(ammo);
        AccessCard accessCard = new AccessCard();
        this.backpack.add(accessCard);
        Bomb bomb = new Bomb("bomb",300);
        this.backpack.add( bomb);}


    public void useBy(Actor actor) {
       for(int i=0; i<backpack.getSize(); i++){
                DropItem drop = new DropItem(this.backpack, getWorld(), actor.getX(), actor.getY());
                drop.execute();}

        }
    }

