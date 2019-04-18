package sk.tuke.oop.game.actions;

import sk.tuke.oop.game.actors.Armed;
import sk.tuke.oop.game.actors.weapons.Fireable;

/**
 * Created by Martina on 11/30/2016.
 */
public class Fire implements Action {
private Armed armed;
    private Fireable bullet;

    public Fire(Armed armed){
        this.armed=armed;
    }

    public void execute() {
       if(armed.getWeapon().getAmmo()!=0){
           this.bullet=armed.getWeapon().fire();
           bullet.setPosition(armed.getX()+8,armed.getY()+8);
           bullet.setDirection(armed.getAnimation().getRotation());
           armed.getWorld().addActor(bullet);
       }
    }
}
