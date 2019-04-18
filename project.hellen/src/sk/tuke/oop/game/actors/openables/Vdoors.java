package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 * Created by Martina on 11/19/2016.
 */
public class Vdoors extends AbstractActor implements Openable {
    private Animation animation;
    private int on=0;

    public Vdoors(String name, boolean vertical) {
        super(name);
        System.out.println(vertical);
        this.animation = new Animation("sprites/vdoor_strong.png", 16, 32, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);}

    public void open() {
        on=1;
        animation.start();
        animation.stopAt(3);
        getWorld().setWall(17,4,false);
    }

    public void close() {
        on=0;
        animation.stop();
        getWorld().setWall(17,4,true);
    }

    public boolean isOpen() {
        return on == 1;
    }

    public void act(){
        if(on==0){
            animation.stop();
            getWorld().setWall(17,4,true);
        }
    }

    public void useBy(Actor actor) {

    }
}
