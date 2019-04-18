package sk.tuke.oop.game.actors;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.*;
/**
 * Created by Martina on 11/19/2016.
 */
public class ActorFactoryImpl implements ActorFactory {
    public ActorFactoryImpl() {
    }
    public Actor create(String type,String name) {
        return ("aliens1".equals(name)?new Alien(name):("money".equals(name)?new Money():("cooler".equals(name)?new Cooler():
                                ("ripley".equals(name)?new Ripley():("access card".equals(name)?new AccessCard():
                                        ("locker".equals(name)?new Locker():("door1".equals(name)?new Door(name,true):null)))))));
    }
}