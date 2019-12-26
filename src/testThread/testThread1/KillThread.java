package testThread.testThread1;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午9:06 2019/12/26
 **/
public class KillThread extends Thread {
    private Hero h1;
    private Hero h2;

    public KillThread(){

    }
    public KillThread(Hero h1,Hero h2){
        this.h1=h1;
        this.h2=h2;
    }

    @Override
    public void run() {
        while (!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
