package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.items.Usable;


/**
 * Created by Martina on 11/8/2016.
 */
public class Use implements Action {
private Actor actor;
private Actor actuator;

    public Use(Actor actor, Actor actuator){
            this.actor=actor;
        this.actuator=actuator;
    }
    
    public Use(){
        
    }

  
    public void execute() {
        if(actor instanceof Usable){
            ((Usable)actor).useBy(actuator);
        }
        else if(actor instanceof Openable){
            ((Openable)actor).open();
        }
    } 

}