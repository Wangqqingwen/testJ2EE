package testThread.testThread2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:46 2019/12/26
 **/
public class PracticsThread2 {
    public static void main(String[] args) {
        ///////////////////////////////
        //1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
        //
        //2. 创建一个破解线程，使用穷举法，匹配这个密码
        //
        //3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
        //
        //提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器
        // 中拿出可能密码，并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的
        // ，就不停的取出，并打印。
        //穷举法：用for加上递归
        //
        //基本上所有的集合类都会有一个叫做快速失败的校验机制，当一个集合在被多个线程修改
        // 并访问时，就会出现ConcurrentModificationException 校验机制。它的实现
        // 原理就是我们经常提到的modCount修改计数器。如果在读列表时，modCount发生变
        // 化则会抛出ConcurrentModificationException异常。这与线程同步是两码事，
        // 线程同步是为了保护集合中的数据不被脏读、脏写而设置的。
        //
        //因此一般有2种解决办法：
        //
        //　　1）在使用iterator迭代的时候使用synchronized或者Lock进行同步；
        //
        //　　2）使用并发容器CopyOnWriteArrayList代替ArrayList和Vector。
        /////////////////////////////////
        int length = 3;
        String pass = createPass(length);
        System.out.println("密码是："+pass);

        ArrayList<String> arrayList = new ArrayList<>();

        new Thread(new GetPass(arrayList,pass)).start();

        Thread thread = new Thread(new LogPass(arrayList));
        thread.setDaemon(true);
        thread.start();
    }

    private static String createPass(int length) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder pass = new StringBuilder();
        for(int i=0;i<length;i++){
            pass.append(str.charAt(random.nextInt(62)));
        }
        return pass.toString();
    }

    static class GetPass implements Runnable{
        private ArrayList<String> arrayList=null;
        private String pass = null;

        public GetPass() {
        }

        public GetPass(ArrayList<String> arrayList, String pass) {
            this.arrayList = arrayList;
            this.pass = pass;
        }

        @Override
        public void run() {
            tryPass();
        }

        public synchronized void tryPass(){
            String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder pass = new StringBuilder();
            for (int i=0;i<str.length();i++){
                for (int j=0;j<str.length();j++){
                    for (int k=0;k<str.length();k++){
                        pass.append(str.charAt(i)).append(str.charAt(j)).append(str.charAt(k));
                        if (this.pass.equals(pass.toString())){
                            break;
                        }else {
                            this.arrayList.add(pass.toString());
                            pass.delete(0,2);
                        }
                    }
                }
            }
        }
    }

    static class LogPass implements Runnable{
        private ArrayList<String> arrayList=null;

        public LogPass() {
        }

        public LogPass(ArrayList<String> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printPass();
        }

        public synchronized void printPass() {
            for (Iterator iterator = arrayList.iterator();iterator.hasNext();){
                System.out.println("穷举的密码是:"+iterator.next().toString());
            }
        }
    }
}
