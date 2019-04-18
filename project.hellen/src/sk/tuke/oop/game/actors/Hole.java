package sk.tuke.oop.game.actors;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.Lurker;
import sk.tuke.oop.game.actors.ripley.Ripley;

import java.util.Iterator;

/**
 * Created by Martina on 12/2/2016.
 */
public class Hole extends AbstractActor {
    private int l=0;
    private int a=0;
    public Hole(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/hole.png", 32, 32, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }

  public void act() {
      Lurker lurker = new Lurker("hej");
      lurker.setPosition(getX(),getY());
      Circle circle = new Circle(getX()+8,getY()+8,50);
      for (Iterator<Actor> iter = getWorld().iterator(); iter.hasNext(); ) {
          Actor element = iter.next();
          Rectangle rect = new Rectangle(element.getX(), element.getY(), element.getWidth(), element.getHeight());

          if (element instanceof Ripley && circle.intersects(rect)) {
            l++;
          }
      }
      if(l>1 && a<=15){
          a++;
          getWorld().addActor(lurker);
      }
  }
}
