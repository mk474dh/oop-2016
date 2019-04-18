package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;


/**
 * Created by Martina on 11/5/2016.
 */
public class Energy extends AbstractActor {

    public Energy(){
        super("Energy");
        Animation animation = new Animation("sprites/energy.png", 16, 16, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
    }

}
