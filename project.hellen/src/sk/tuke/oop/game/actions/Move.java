package sk.tuke.oop.game.actions;

import sk.tuke.oop.game.actors.Movable;


/**
 * Created by Martina on 10/29/2016.
 */
public class Move implements Action  {
    private Movable actor;
    private int step;
    private int dx;
    private int dy;

    public Move(Movable actor, int step, int dx, int dy){
        this.actor = actor;
        this.step=step;
        this.dx=dx;
        this.dy=dy;

    }

    public void move(int x, int y){
      if (y == -1 && x == 0) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX(), actor.getY() - step);
            actor.getAnimation().setRotation(0);
        } else if (y == 1 && x == -1) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX() - step, actor.getY() + step);
            actor.getAnimation().setRotation(225);
        } else if (y == 1 && x == 1) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX() + step, actor.getY() + step);
            actor.getAnimation().setRotation(135);
        } else if (y == -1 && x == -1) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX() - step, actor.getY() - step);
            actor.getAnimation().setRotation(315);
        }
    }

    public void move1(int x, int y){
        if (y == -1 && x == 1) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX() + step, actor.getY() - step);
            actor.getAnimation().setRotation(45);
        } else if (x == -1 && y == 0) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX() - step, actor.getY());
            actor.getAnimation().setRotation(270);
        } else if (x == 1 && y == 0) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX() + step, actor.getY());
            actor.getAnimation().setRotation(90);
        }
        else if (y == 1 && x == 0) {
            actor.getAnimation().start();
            actor.setPosition(actor.getX(), actor.getY() + step);
            actor.getAnimation().setRotation(180);
        }
    }

    public void execute() {
        int xPosOld = actor.getX();
        int yPosOld = actor.getY();

        move(dx,dy);
        move1(dx,dy);
        if (actor.getWorld().intersectWithWall(actor)) {
            actor.setPosition(xPosOld, yPosOld);
        }
    }
}
