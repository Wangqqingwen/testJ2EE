package testContains.testCompator;

/**
 * @program:
 * @description:
 * @author: Wang.
 * @create: 下午2:09 2019/12/25
 **/
public class Hero {
    public String name;
    public float hp;
    public int image;

    public Hero() {
    }

    public Hero(String name, float hp, int image) {
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
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", image=" + image +
                '}';
    }
}
