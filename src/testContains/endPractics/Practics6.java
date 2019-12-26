package testContains.endPractics;

import java.util.Arrays;
import java.util.Random;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:43 2019/12/23
 **/
public class Practics6 {
    public static void main(String[] args) {
        String[] str = new String[100];
        Integer[] end = new Integer[100];
        for (int i=0;i<str.length;){
            int length = (int)(Math.random()*10);
            //问题出现在这个判断，
            if (length >1) {
                str[i] = getRandomString(length);
                end[i] = hashcode(str[i]);
                //System.out.println(end[i]);
                System.out.printf("%-12s在自定义规则下的hashcode为: %d%n", str[i], end[i]);
                i++;
            }
        }

    }
    public static int hashcode(String str){
        char[] ch = str.toCharArray();
        int sum = 0;
        for (int i = 0; i<ch.length;i++){
            sum+=ch[i];
        }
        sum*=23;
        if (sum > 1999) {
            sum %= 2000;
        }
        if (sum <0) {
            Math.abs(sum);
        }
        //System.out.println(hashCode);
        return sum;
    }
    public static String getRandomString(int length) {
        String st = "abcefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPOQRSTUVWXYZ01233456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            //st.charAt指定索引的字符
            sb.append(st.charAt(num));
        }
        return sb.toString();
    }
}
