package testContains.testSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午9:36 2019/12/23
 **/
public class PracticsSet {
    public static void main(String[] args) {
        //创建一个长度是100的字符串数组
        String[] str = new String[100];
        //使用长度是2的随机字符填充该字符串数组
        for (int i = 0; i < str.length; i++) {
            str[i] = getRandomString(2);
        }
        for (int i = 1; i <= 100; i++) {
            System.out.print(str[i-1] + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        //统计这个字符串数组里重复的字符串有多少种
        //使用HashSet来解决这个问题
        Set<String> set = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        for (String st :
                str) {
            String index = st.substring(st.indexOf(":")+1);
            if (!set.add(index)) {
                endSet.add(index);
            }
        }

        System.out.printf("这个字符串数组里重复的字符串有%d种,分别是：", endSet.size());
        for (Iterator iterator = endSet.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }
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
