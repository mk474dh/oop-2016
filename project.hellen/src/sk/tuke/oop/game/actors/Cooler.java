package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 * Created by Martina on 11/19/2016.
 */
public class Cooler extends AbstractActor {
private int on=0;
    private Animation animation = new Animation("sprites/fan.png", 32, 32, 100);
    public Cooler(){
        super("Cooler");
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
    }

    public void setOn(int i){
        on=i;
    }

    public void act() {
        if (on == 0) {
            animation.stop();
        }

    }

}
