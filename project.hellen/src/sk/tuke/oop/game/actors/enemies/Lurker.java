package sk.tuke.oop.game.actors.enemies;

        import sk.tuke.oop.framework.Animation;
        import sk.tuke.oop.game.actors.Health;


/**
 * Created by Martina on 12/9/2016.
 */
public class Lurker extends Alien {
    private int a=0;
    private Animation normalAnimation;
    private Animation big = new Animation("sprites/lurker_alien.png",32,32,100);
    private Health health;
    public Lurker(String name) {
        super(name);
        normalAnimation = new Animation("sprites/lurker_born.png", 32, 32, 100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        health = new Health(50);
        Runnable dying = () -> {
            getWorld().removeActor(this);
        };
        health.onDie(dying);
    }

    public void act() {
      super.act();
        normalAnimation.start();
        if(a==1){
            normalAnimation.setPingPong(true);
            setAnimation(big);
        }
        a++;
    }
    public Health getHealth() {
        return health;
    }

}
