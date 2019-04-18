package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 * Created by Martina on 11/13/2016.
 */
public class TakeItem extends AbstractActor implements Action {
private BackpackImpl backpack;
private Item item;

    public TakeItem(BackpackImpl backpack, Item item){
        super("tek");
        this.backpack=backpack;
        this.item=item;
    }

    public TakeItem(){
        super("tak");

    }

    public void execute() {
        if(backpack.getCapacity()>0){
            backpack.add(item);
            item.getWorld().removeActor(item);
        }


    }


}
