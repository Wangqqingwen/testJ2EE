package testContains.testCompator;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:22 2019/12/25
 **/
public class Hero2 implements Comparable<Hero2> {
    public String name;
    public float hp;
    public int image;

    public Hero2() {
    }

    public Hero2(String name, float hp, int image) {
        this.name = name;
        this.hp = hp;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Hero2{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", image=" + image +
                '}';
    }

    @Override
    public int compareTo(Hero2 anotherHero) {
        return this.image<anotherHero.image?1:-1;
    }
}
