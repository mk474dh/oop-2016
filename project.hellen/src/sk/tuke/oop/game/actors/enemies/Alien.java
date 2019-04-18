package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Alive;
import sk.tuke.oop.game.actors.Health;
import sk.tuke.oop.game.actors.Movable;


/**
 * Created by Martina on 10/29/2016.
 */
public class Alien extends AbstractActor implements Actor,Movable,Enemy,Alive {
    private Animation animation;
    private static final int STEP = 2;
    private Health health;

    public Alien(String name) {
        super(name);
        this.animation = new Animation("sprites/warrior_alien.png", 32, 32, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
        this.setPosition(0, 0);
        health = new Health(50);
        health.onDie(dying);
    }


    private Runnable dying = () -> {
        getWorld().removeActor(this);
    };
    public void act() {
        int x;
        x = (int) (Math.random() * 50);
        if (x == 5) {
            animation.stop();
        }
        if (x == 30) {
            Move move = new Move(this, STEP, 0, 1);
            move.execute();
            move.execute();
            move.execute();
        } else if (x == 10) {
            Move move = new Move(this, STEP, -1, 0);
            move.execute();
            move.execute();
            move.execute();
        } else if (x == 48) {
            Move move = new Move(this, STEP, 0, -1);
            move.execute();
            move.execute();
            move.execute();
        } else if (x == 13) {
            Move move = new Move(this, STEP, 1, 0);
            move.execute();
            move.execute();
            move.execute();
        }

    }

    public Health getHealth() {
        return health;
    }
}

