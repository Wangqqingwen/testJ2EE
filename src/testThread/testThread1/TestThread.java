package testThread.testThread1;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午9:00 2019/12/26
 **/
public class TestThread {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "gareen";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "teemo";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "bh";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "leesin";
        leesin.hp = 455;
        leesin.damage = 80;

        /*//盖伦攻击提莫
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }

        //赏金猎人攻击盲僧
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }*/

        //线程继承Thread
        /*KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(leesin,bh);
        killThread2.start();*/

        //线程实现Runnable接口
        /*Thread thread1 = new Thread(new Battle(gareen,teemo));
        thread1.start();
        Thread thread2 = new Thread(new Battle(leesin,bh));
        thread2.start();*/

        //匿名类的一个好处是可以很方便的访问外部的局部变量。
        Thread thread1 = new Thread(){
          public void run(){
              while(!teemo.isDead()){
                  gareen.attackHero(teemo);
              }
          }
        };
        thread1.start();
        Thread thread2 = new Thread(){
          public void run(){
              while(!bh.isDead()){
                  leesin.attackHero(bh);
              }
          }
        };
        thread2.start();
    }
}
