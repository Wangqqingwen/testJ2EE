package testException;

public interface IStringBuffer {
    boolean isInsert(int pos, String b) throws Throwable;

    boolean isDelete(int start,String b) throws Throwable;

    boolean isDelete(int start, int end) throws Throwable;
}
