package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martina on 11/25/2016.
 */
public class Switch1 extends AbstractActor implements Observable{
    private List<Observer> observers=new ArrayList<>();
    public Switch1(String name) {
        super(name);
        Animation normalAnimation = new Animation("sprites/switch1.png", 16, 16, 100);
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        setAnimation(normalAnimation);
    }
    public Actor getObserver(){
        return (Actor) observers.get(0);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
