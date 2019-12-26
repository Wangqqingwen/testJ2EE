package testContains.endPractics;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午5:02 2019/12/23
 **/
public class Entry {
    public Entry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }
    public Object key;
    public Object value;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[key=" + key + ", value=" + value + "]";
    }
}
