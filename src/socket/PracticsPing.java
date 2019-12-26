package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午4:42 2019/12/25
 **/
public class PracticsPing {
    //要用到线程
    public static void main(String[] args) throws IOException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("本机的ip："+ip);
        for (int i=1;i<=255;i++){
            new Thread(new PingThread(i)).start();
        }
    }

    static class PingThread implements Runnable{
        private int i;
        public PingThread(int i){
            this.i = i;
        }

        @Override
        public void run() {
            StringBuilder sb = new StringBuilder("172.28.117.").append(i);
            //ping操作
            Process p = null;
            try {
                p = Runtime.getRuntime().exec("ping " + sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                try {
                    if (!((line=br.readLine())!=null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (line.length()> 0) {
                    stringBuilder.append(line);
                }
            }
        }
    }
}
