package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actions.Use;
import sk.tuke.oop.game.actors.*;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Locker;



public class Main {
public Main(){

}
    /**
     * The application's entry point.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SlickWorld world;
        world = new SlickWorld("Aliens",800,600);

        world.setFactory(new ActorFactoryImpl());
        world.setMap("levels/map.tmx");
        world.run();
        System.out.println("Greetings from Manager");
    }

    public static void scenario(){
        Ripley ripley = new Ripley();
        Locker locker = new Locker();
        Reactor reactor = new Reactor("reactor");
        System.out.println(reactor);
        Use use = new Use(locker, ripley);
        use.execute();
        AccessCard accessCard = new AccessCard();
        System.out.println(accessCard);
        Bomb bomb = new Bomb("bomb",300);
        System.out.println(bomb);
        //v ripley
        // TakeItem bomb = new TakeItem(this.backpack,bomb);
        // bomb.execute();
        // TakeItem card = new TakeItem(this.backpack,accessCard );
        // card.execute();
    
    }
}
