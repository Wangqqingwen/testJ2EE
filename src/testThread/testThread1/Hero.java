package testThread.testThread1;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 上午8:59 2019/12/26
 **/
public class Hero {
    public String name;
    public float hp;

    public int damage;

    public void attackHero(Hero h) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp -= damage;
        if (h.hp <= 0) {
            h.hp = 0;
        }
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

        if (h.isDead()) {
            System.out.println(h.name + " dead");
        }
    }

    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
}
