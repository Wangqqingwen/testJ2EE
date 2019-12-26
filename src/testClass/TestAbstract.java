package testClass;

public abstract class TestAbstract {
    //抽象类可以定义
    //public,protected,package,private
    //静态和非静态属性
    //final和非final属性
    //但是接口中声明的属性，只能是
    //public
    //静态
    //final的
    //即便没有显式的声明

    //匿名内部类
    String name;
    int price;

    public abstract boolean disoperal();

    public static void main(String[] args) {
        TestAbstract testAbstract = new TestAbstract() {
            @Override
            public boolean disoperal() {
                return false;
            }
        };
        System.out.println(testAbstract.disoperal());
        System.out.println(testAbstract);
    }

}
