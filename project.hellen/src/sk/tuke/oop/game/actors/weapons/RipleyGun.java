package sk.tuke.oop.game.actors.weapons;

/**
 * Created by Martina on 11/30/2016.
 */
public class RipleyGun extends AbstractWeapon {

    public RipleyGun(int startBullets, int maxBullets) {
        super(100, 500);
        System.out.println(startBullets);
        System.out.println(maxBullets);
    }
}
