package sk.tuke.oop.game.items;

import sk.tuke.oop.game.actors.AbstractActor;


/**
 * Created by Martina on 10/11/2016.
 */
public abstract class AbstractTool extends AbstractActor {
    private int possibleUses;


    AbstractTool(int possibleUses){
        super("Tool");
        this.possibleUses=possibleUses;
    }



    public int getPossibleUses(){
        return possibleUses;}

    void use(){
        possibleUses=possibleUses-1;
        if(possibleUses==0){
            getWorld().removeActor(this);
        }

    }
}
