package testClass;

public class TestHero{
    public String name;
    protected float hp;

    public void useItem(Item i){
        i.effect();
    }

    public static void main(String[] args) {

        TestHero garen =  new TestHero();
        garen.name = "盖伦";

        LifePotion lp =new LifePotion();
        MagicPotion mp =new MagicPotion();

        garen.useItem(lp);
        garen.useItem(mp);

    }
}
