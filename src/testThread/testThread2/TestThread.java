package testThread.testThread2;

import testThread.testThread1.Hero;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:19 2019/12/26
 **/
public class TestThread {
    //Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响
    //Thread.sleep(1000); 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经过去了%d秒%n", seconds++);
                }
            }
        };
        thread.start();

        //首先解释一下主线程的概念
        //所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
        //在42行执行t.join，即表明在主线程中加入该线程。
        //主线程会等待该线程结束完毕， 才会往下运行。
        /*final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1 = new Thread() {
            public void run() {
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();

        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        t2.start();*/


        /////////////////////////////////
        //当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源
        //为了演示该效果，要把暂停时间去掉，多条线程各自会尽力去占有CPU资源
        //同时把英雄的血量增加100倍，攻击减低到1，才有足够的时间观察到优先级的演示
        //如图可见，线程1的优先级是MAX_PRIORITY，所以它争取到了更多的CPU资源执行代码
        ///////////////////////////////////
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 3000;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 3000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 3000;
        leesin.damage = 1;

        Thread t3= new Thread(){
            public void run(){

                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t4= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };

        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t3.start();
        t4.start();

    }

    //////////////////////////////////////////////
    //当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
    ////临时暂停，使得t1可以占用CPU资源
    //                    Thread.yield();
    ///////////////////////////////////////////////////

}
