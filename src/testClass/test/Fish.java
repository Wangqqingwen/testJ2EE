package testClass.test;

public class Fish extends Animal implements Pet {
    private String name;
    protected Fish(int leg) {
        super(0);
    }

    @Override
    public void eat() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void play() {

    }

    public void walk(){
        System.out.println("没有腿，不能走");
    }
}
