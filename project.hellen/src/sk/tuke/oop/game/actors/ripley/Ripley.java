package sk.tuke.oop.game.actors.ripley;
import sk.tuke.oop.framework.*;
import sk.tuke.oop.game.actions.*;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Alive;
import sk.tuke.oop.game.actors.Health;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.items.*;
import sk.tuke.oop.game.actors.weapons.AbstractWeapon;
import sk.tuke.oop.game.actors.Armed;
import sk.tuke.oop.game.actors.weapons.RipleyGun;
import java.util.Iterator;
/**
 * Created by Martina on 10/29/2016.
 */
public class Ripley extends AbstractActor implements Actor,Armed,Movable,RipleyState,Alive {
    private static final int STEP = 2;
    private int ammo;
    private Health health;
    private int d=0;
    private RipleyGun gun;
    private BackpackImpl backpack=new BackpackImpl(10);
    private Animation dieAnimation = new Animation("sprites/player_die.png", 32, 32, 100);
    public Ripley() {
        super("Ripley");
        Animation animation = new Animation("sprites/player.png", 32, 32, 100);
        this.setAnimation(animation);
        this.getAnimation().setPingPong(true);
        this.setPosition(0, 0);
        this.setAmmo(100);
        health = new Health(100);
        health.onDie(dying);
        AbstractWeapon weapon=new RipleyGun(100,100);
        setWeapon(weapon);
    }
    public int getAmmo() {
        return this.ammo;
    }
    public void setAmmo(int ammo) {
        this.ammo = ammo; }
    private Runnable dying = () -> {
        this.setAnimation(dieAnimation);
        this.getAnimation().setPingPong(true);
    };
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.centerOn(this);
        world.showBackpack(this.backpack);
    }
    public Item getItemByName(String name){
        return backpack.getItem(name);
    }
    public void getMove(){
        if (Input.getInstance().isKeyDown(Input.Key.DOWN) && !Input.getInstance().isKeyDown(Input.Key.RIGHT) && !Input.getInstance().isKeyDown(Input.Key.LEFT)) {
            Move move= new Move(this, STEP, 0, 1);
            move.execute();
        }
        else if (Input.getInstance().isKeyDown(Input.Key.UP) && !Input.getInstance().isKeyDown(Input.Key.RIGHT) && !Input.getInstance().isKeyDown(Input.Key.LEFT)) {
            Move move=new Move(this, STEP, 0, -1);
            move.execute();
        }
        else if (Input.getInstance().isKeyDown(Input.Key.UP) && Input.getInstance().isKeyDown(Input.Key.LEFT)) {
            Move move=new Move(this, STEP, -1, -1);
            move.execute();
        }
    }
    public void getMove1(){
        if (Input.getInstance().isKeyDown(Input.Key.UP) && Input.getInstance().isKeyDown(Input.Key.RIGHT)) {
            Move move=new Move(this, STEP, 1, -1);
            move.execute();
        }  else if (Input.getInstance().isKeyDown(Input.Key.DOWN) && Input.getInstance().isKeyDown(Input.Key.RIGHT)) {
            Move move=new Move(this, STEP, 1, 1);
            move.execute();
        } else {
            this.getAnimation().stop();
        }
    }
    public void getMove2(){
        if (Input.getInstance().isKeyDown(Input.Key.LEFT) && !Input.getInstance().isKeyDown(Input.Key.UP) && !Input.getInstance().isKeyDown(Input.Key.DOWN)) {
            Move move=new Move(this, STEP, -1, 0);
            move.execute();
        } else if (Input.getInstance().isKeyDown(Input.Key.RIGHT) && !Input.getInstance().isKeyDown(Input.Key.UP) && !Input.getInstance().isKeyDown(Input.Key.DOWN)) {
            Move move=new Move(this, STEP, 1, 0);
            move.execute();
        }
        else if (Input.getInstance().isKeyDown(Input.Key.DOWN) && Input.getInstance().isKeyDown(Input.Key.LEFT)) {
            Move move= new Move(this, STEP, -1, 1);
            move.execute();
        }
    }
    public void act() {
        Animation animation = this.getAnimation();
        animation.start();
        for (Iterator<Actor> iter = getWorld().iterator(); iter.hasNext(); ) {
            Actor element = iter.next();
            if (element instanceof Alien && element.intersects(this)) {
                health.wound(1);
            }
        }
        if (Input.getInstance().isKeyPressed(Input.Key.SPACE)){
            Fire fire = new Fire(this);
            fire.execute();
        }
        if(getAnimation().equals(dieAnimation)){
            d++;
            if(d==20){
                System.exit(0);
            }
        }
        getMove();
        getMove1();
        getMove2();
    }
    public Health getHealth() {
        return health;
    }
    public AbstractWeapon getWeapon() {
        return gun;
    }
    public void setWeapon(AbstractWeapon weapon) {
            this.gun= (RipleyGun) weapon;
    }
}