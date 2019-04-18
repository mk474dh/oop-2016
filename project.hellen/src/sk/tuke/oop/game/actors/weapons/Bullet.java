package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.Enemy;

/**
 * Created by Martina on 11/30/2016.
 */
public class Bullet extends AbstractActor implements Fireable,Movable {
    private int xDir;
    private int yDir;
    private  Animation animation;
    private static final int STEP = 2;


    public Bullet(String name) {
        super(name);
        animation = new Animation("sprites/bullet.png", 16, 16, 100);
        this.setAnimation(animation);


    }
    public void setDirection(int angle) {
        animation.setRotation(angle);
        if (angle == 0) {
            this.yDir = -1;
        }
        else if(angle==90){
            this.xDir = 1;}
        else if(angle==180){
            this.yDir = 1;}
        else if(angle==270){
            this.xDir = -1;
        }
        else if(angle==315){
            this.xDir = -1;
            this.yDir = -1;
        }
        else if(angle==45){
            this.xDir =  1;
            this.yDir = -1;
        }
        else if(angle==135){
            this.xDir = 1;
            this.yDir = 1;
        }
        else if(angle==225){
            this.xDir = -1;
            this.yDir =  1;
        }
    }
    public void act() {
        Move move=new Move(this, STEP, this.xDir, this.yDir);
        move.execute();
        if(this.getWorld().intersectWithWall(this)) {
            this.explode();
        }

        for (Actor actor : this.getWorld()) {
            if (actor instanceof Enemy && this.intersects(actor)) {
                Enemy enemy = (Enemy) actor;
                ((Alien)enemy).getHealth().wound(10);
                this.explode();
                break;
            }
        }
    }

    private void explode() {
        this.getWorld().removeActor(this);
    }

}