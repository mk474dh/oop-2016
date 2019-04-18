package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Martina on 11/25/2016.
 */
public class Reactor extends AbstractActor implements Observable {
    private Animation offAnimation= new Animation("sprites/reactor.png",80,80,100);
    private int a=0;
    private int b =0;
    private int c = 0;
    private List<Observer> observers=new ArrayList<>();
    public Reactor(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }

    public int getIt(){
        if(a>1 && b>1 && c>1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void act(){
        for (Iterator<Actor> iter = getWorld().iterator(); iter.hasNext(); ) {
            Actor element = iter.next();
            if (element instanceof Buttonc) {
                a++;
            }
            if (element instanceof Buttonc2) {
                b++;
            }
            if (element instanceof Buttonc3) {
                c++;
            }
        }

        if(a>1 && b>1 && c>1){
            setAnimation(offAnimation);
            for(int i=0; i< observers.size(); i++){
                observers.get(i).giveNotice();
            }
        }
    }


    public void addObserver(Observer observer) {
      observers.add(observer);
    }


    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
