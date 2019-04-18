package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.DropItem;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 * Created by Martina on 11/25/2016.
 */
public class Helicopter extends AbstractActor {
    private BackpackImpl backpack=new BackpackImpl(2);
    private int a=0;
    public Helicopter(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/heli.png", 64, 64, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
        Bomb bomb = new Bomb("bomb",300);
        this.backpack.add(bomb);
    }

    public void act() {
        if (this.getX() != 600 && a==0) {
            this.setPosition(this.getX() + 2, this.getY());
        } else {
            a++;
            for (int i = 0; i < backpack.getSize(); i++) {
                DropItem drop = new DropItem(this.backpack, getWorld(), this.getX(), this.getY());
                drop.execute();
            }
            if (this.getX() != 1000) {
                this.setPosition(this.getX() + 2, this.getY());
            } else if(this.getX()==1000) {
                getWorld().removeActor(this);
            }
        }
    }
}
