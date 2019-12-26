package testClass;

import testClass.AD;
import testClass.ADAPHero;
import testClass.ADHero;

public class HelloWorld {
    public String name;
    protected float hp;
    public static void main(String[] args) {
        ADHero ad = new ADHero();

        AD adi = ad;

        ADHero adHero = (ADHero) adi;

        ADAPHero adapHero = (ADAPHero) adi;
        adapHero.attackAP();
    }
}
