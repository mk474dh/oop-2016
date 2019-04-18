package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martina on 11/30/2016.
 */
public class Health {
private int maxHealth;
    private int value;
    private List<Runnable> calls=new ArrayList<>();
    public Health(int initHealth, int maxHealth) {
    this.value =initHealth;
        this.maxHealth=maxHealth;
    }

    public Health(int initHealth) {
        this.value =initHealth;
        this.maxHealth=initHealth;
    }

    public int getValue(){
        return value;
    }

   public void heal(int healthIncrement){
       if(value +healthIncrement<=maxHealth){
           value =value + healthIncrement;
       }
       else{
           value = maxHealth;
       }
    }

   public void wound(int healthDecrement){
       if(value -healthDecrement>=0){
           value = value -healthDecrement;
         if(value==0){
           for(Runnable i : calls)  {
               i.run();
           }
       }
     }
   }

   public void woundDeadly(){
        value =0;
       wound(0);
    }

    public void onDie(Runnable callback){
    calls.add(callback);
    }
}
