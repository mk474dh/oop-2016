package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;

/**
 * Created by Martina on 11/8/2016.
 */
public interface Usable extends Actor {

    void useBy(Actor actor);
}
