package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.weapons.AbstractWeapon;

/**
 * Created by Martina on 11/30/2016.
 */
public interface Armed extends Actor {
    AbstractWeapon getWeapon();
    void setWeapon(AbstractWeapon weapon);
}
