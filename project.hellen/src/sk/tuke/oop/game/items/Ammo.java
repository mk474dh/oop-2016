package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;


/**
 * Created by Martina on 11/5/2016.
 */
public class Ammo extends AbstractActor implements Item {
    private Animation animation = new Animation("sprites/ammo.png", 16, 16, 100);

    public Ammo(){
        super("Ammo");
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
    }


}
