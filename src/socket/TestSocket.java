/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午5:30 2019/12/25
 **/
package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 *  需求：获取本机的内网地址，通过ping从内网的网段中找出可用的ip地址
 *  思路：1、Runtime().getRuntime.exec()可运行windows的exe程序
 *      2、通过ping返回的结果来判断ip地址是否有效，根据返回结果中是否出现“字节=32”判定
 *      3、把有效的ip地址放到集合中，最后打印出来
 *
 *  注意：1、String的split()方法分割.时，需要加上\\转义
 *      2、ExecutorService线程池添加完任务后需调用shutdown()方法
 *      3、ExecutorService的awaitTermination()方法阻塞等待线程池中的任务全部结束返回true或等待指定时间后返回false
 *      4、yield()方法让其他不低于当前线程优先级的线程先执行，进入Runnable状态，能得到同样的结果，但不清楚是否常用
 *
 */
public class TestSocket {
    private static List<String> availableIps = Collections.synchronizedList(new ArrayList<String>());

    private static ExecutorService threadPool = Executors.newFixedThreadPool(50);

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        String ip = null;
        try {
            InetAddress host = InetAddress.getLocalHost();
            ip = host.getHostAddress();
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("本机的内网IP: " + ip);
        String myIp = ip.substring(0, ip.lastIndexOf(".") + 1);
        System.out.println(myIp);
//      String[] ips = "192.168.1.1".split("\\.");
//      System.out.println("zhaunyi:" + ips[0]);
        for (int i = 0; i < 256; i++) {
            String pingIp = new StringBuilder(myIp).append(i).toString();
            threadPool.submit(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        System.out.println("尝试连接： " + pingIp);
                        Process process = Runtime.getRuntime().exec("ping " + pingIp);
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                            String line = null;
                            StringBuilder builder = new StringBuilder();
                            while (null != (line = br.readLine())) {
                                builder.append(line + "\r\n");
                            }
                            if (builder.toString().contains("字节=32")) {
                                availableIps.add(pingIp);
                            }
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });

        }
        // 不再提交任何任务
        threadPool.shutdown();
//      while (true) {
//          if (threadPool.isTerminated()) {
//              System.out.println("可以连接的IP有:");
//              for (String aIp : availableIps) {
//                  System.out.println(aIp);
//              }
//              System.out.println("总共有：" + availableIps.size());
//              break;
//          }
//          Thread.yield();
//      }
        if (threadPool.awaitTermination(2, TimeUnit.MINUTES)) {
            System.out.println("可以连接的IP有:");
            for (String aIp : availableIps) {
                System.out.println(aIp);
            }
            System.out.println("总共有：" + availableIps.size());
        }

    }

}

