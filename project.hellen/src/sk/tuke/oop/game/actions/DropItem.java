package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 * Created by Martina on 11/13/2016.
 */
public class DropItem implements Action {
    private BackpackImpl backpack;
    private World world;
    private int x;
    private int y;

    public DropItem(BackpackImpl backpack, World world, int x, int y){
        this.backpack=backpack;
        this.world=world;
        this.x=x;
        this.y=y;
    }

    public void execute() {
        Actor actor = backpack.getLastItem();
        actor.setPosition(x,y);
        world.addActor(actor);
        backpack.remove((Item) actor);
    }
}
