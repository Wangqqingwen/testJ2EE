package testClass.test;

public class Spider extends Animal {

    protected Spider(int leg) {
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("用嘴吃。。");
    }
}
