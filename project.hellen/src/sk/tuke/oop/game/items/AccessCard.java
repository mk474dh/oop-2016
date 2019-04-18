package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.openables.Door1;


/**
 * Created by Martina on 11/19/2016.
 */
public class AccessCard extends AbstractActor implements Item,Usable {


    public AccessCard() {
        super("AccesCard");
        Animation animation = new Animation("sprites/key.png", 16, 16, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);}

    public void useBy(Actor actor) {
        if(actor instanceof Door){
        ((Door)actor).open();}
        else{
            ((Door1)actor).open();
        }
    }
}
