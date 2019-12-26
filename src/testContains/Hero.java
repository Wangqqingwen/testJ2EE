package testContains;

public class Hero {

    public Hero(){

    }
    public Hero(String name){
        this.name = name;
    }


    public String name;
    private float hp;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public float getHp(){
        return hp;
    }
    public void setHp(float hp){
        this.hp = hp;
    }

    public String toString(){
        return "[name:"+name+" hp:"+hp+"]";
    }

}
