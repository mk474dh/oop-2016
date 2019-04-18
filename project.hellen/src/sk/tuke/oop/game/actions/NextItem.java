package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 * Created by Martina on 11/14/2016.
 */
public class NextItem implements Action {
    private BackpackImpl backpack;

    public NextItem(BackpackImpl backpack){
        this.backpack=backpack;

    }

   public void execute(){
       int size = backpack.getSize();
       size -=1;
       Item pomoc = backpack.getLastItem();
       for(int i = 0; i< size; i++){
           backpack.setItem(i,backpack.getItem(i+1));

      }
       backpack.setItem(size, pomoc);
    }
}
