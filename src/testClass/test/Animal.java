package testClass.test;

public abstract class Animal {
    protected int leg;
    protected Animal(int leg){
        this.leg = leg;
    }

    public abstract void eat();

    public void walk(){
        System.out.println("使用"+leg+"条腿走路");
    }
}
