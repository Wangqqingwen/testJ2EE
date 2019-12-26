package testClass.test;

public class Cat extends Animal implements Pet {
    private String name;

    public Cat(String name){
        super(4);
        this.name = name;
    }

    public Cat(){
        this(null);
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

    @Override
    public void eat() {

    }
}
