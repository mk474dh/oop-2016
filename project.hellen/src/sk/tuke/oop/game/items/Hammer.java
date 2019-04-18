package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.Cooler;


/**
 * Created by Martina on 10/10/2016.
 */
public class Hammer extends AbstractTool implements Item,Usable {
    private Animation hammerAnimation= new Animation("sprites/hammer.png", 16, 16, 10);

    public Hammer() {
        super(1);
        hammerAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(hammerAnimation);

    }

    Hammer(int uses){
        super(uses);
        hammerAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(hammerAnimation);

    }


    public void useBy(Actor actor) {
        Cooler cooler = (Cooler) actor;
        cooler.setOn(1);
        cooler.getAnimation().start();
    }
}
