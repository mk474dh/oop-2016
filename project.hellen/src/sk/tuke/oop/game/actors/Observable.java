package sk.tuke.oop.game.actors;

/**
 * Created by Martina on 12/1/2016.
 */
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
