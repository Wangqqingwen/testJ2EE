package testContains.endPractics;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:19 2019/12/23
 **/
public class Practics5 {
    public static void main(String[] args) {
        //利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
        char[] spi = Double.toString(Math.PI).toCharArray();
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for (char i : spi) {
            if (i == '.')
                continue;
            lhs.add(i);
        }
        System.out.println(lhs);

    }
}
