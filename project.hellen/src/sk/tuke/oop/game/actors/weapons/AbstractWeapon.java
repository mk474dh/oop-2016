package sk.tuke.oop.game.actors.weapons;

/**
 * Created by Martina on 11/30/2016.
 */
public abstract class AbstractWeapon {
private int bullets;
    private int maxBullets;
    AbstractWeapon(int initAmmo, int maxAmmo){
        this.bullets=initAmmo;
        this.maxBullets=maxAmmo;
    }

    public int getAmmo(){
     return bullets;
    }

   public void reload(int newAmmo){
       if(bullets+newAmmo<=maxBullets){
           bullets+=newAmmo;
       }
       else {
           bullets=maxBullets;
       }
    }

    protected Fireable createBullet(){
        return new Bullet("hej");
    }

    public Fireable fire(){
        if(bullets!=0){
            bullets=bullets-1;
            return createBullet();
        }
        else{
            return null;
        }
    }
}
