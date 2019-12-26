package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午4:32 2019/12/25
 **/
public class TestPing {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("ping " + "14.215.177.39");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line=br.readLine())!=null){
            if (line.length() != 0) {
                sb.append(line+"\r\n");
            }
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }
}
