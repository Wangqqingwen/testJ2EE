package testThread.testThread1;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午9:14 2019/12/26
 **/
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;

    public Battle() {
    }

    public Battle(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        while (!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
