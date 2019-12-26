package testContains;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    //设置同样的 键会被覆盖
    public static void main(String[] args) {
        Map<String,Hero> map = new HashMap<>();
        Hero green1 = new Hero("green1");
        Hero green2 = new Hero("green2");
        map.put("green",green1);
        map.put("green",green2);
        System.out.println(map.get("green").getName());
    }
}
