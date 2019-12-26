package testThread.testThread2;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:44 2019/12/26
 **/
public class PracticsThread {
    public static void main(String[] args) {
        ////////////////////////////
        //英雄有可以放一个技能叫做: 波动拳-a du gen。
        //每隔一秒钟，可以发一次，但是只能连续发3次。
        //
        //发完3次之后，需要充能5秒钟，充满，再继续发。
        /////////////////////////////////
        Thread thread = new Thread(){
            @Override
            public void run() {
                int flag = 0;
                while(true){
                    if (flag%4 == 0) {
                        System.out.println("充能5秒钟");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flag++;
                    } else {
                        System.out.println("发动波动拳-a du gen～～");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flag++;
                    }
                }
            }
        };
        thread.start();
    }
}
