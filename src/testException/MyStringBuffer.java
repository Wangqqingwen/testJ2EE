package testException;

public class MyStringBuffer implements IStringBuffer {
    @Override
    public boolean isInsert(int pos, String b) throws Throwable {
        //pos<0
        //抛出 IndexIsNagetiveException
        if (pos<0){
            throw new IndexIsNagetiveException("下标为负异常");
        }
        //pos>length
        //抛出 IndexIsOutofRangeException
        if (pos>b.length()){
            throw new IndexIsNagetiveException("下标超出范围异常");
        }
        //null==b
        //抛出 NullPointerException
        if (null==b){
            throw new IndexIsNagetiveException("空指针异常");
        }
        return false;
    }

    @Override
    public boolean isDelete(int start,String b) throws Throwable {
        if (start < 0) {
            throw new IndexIsNagetiveException("下标为负数！");
        }
        if (start > b.length() - 1) {
            throw new IndexIsOutOfRangeException("下标超出界限！");
        }
        return false;
    }

    @Override
    public boolean isDelete(int start, int end) throws Throwable {
        return false;
    }


    class IndexIsNagetiveException extends Exception{
        public IndexIsNagetiveException(){

        }
        public IndexIsNagetiveException(String msg){
            super(msg);
        }

    }
    class IndexIsOutOfRangeException extends Exception{
        public IndexIsOutOfRangeException(){

        }
        public IndexIsOutOfRangeException(String msg){
            super(msg);
        }

    }
}
