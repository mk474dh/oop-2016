package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.DropItem;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.*;

/**
 * Created by Martina on 11/14/2016.
 */
public class Body extends AbstractActor implements Actor,Usable {
    private BackpackImpl backpack=new BackpackImpl(10);


    public Body() {
        super("Body");
        Animation animation = new Animation("sprites/body.png", 64, 48, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
        this.setPosition(0, 0);
        Hammer hammer = new Hammer();
        this.backpack.add(hammer);
        Money money = new Money();
        this.backpack.add(money);
        Wrench wrench = new Wrench();
        this.backpack.add(wrench);
    }

    public void useBy(Actor actor) {
        if (actor instanceof Ripley) {
            for (int i = 0; i < this.backpack.getSize(); i++) {
                DropItem drop = new DropItem(this.backpack, getWorld(), getX()  + 50, getY() + +50);
                drop.execute();
            }
        }
    }
}
