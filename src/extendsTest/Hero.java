package extendsTest;

// 抽象类 可以定义属性，非抽象的方法
public abstract class Hero {
    public String name; //姓名

    public float hp; //血量

    public float armor; //护甲

    public int moveSpeed; //移动速度

    public String getName(){
        return name;
    }
    //获取护甲值
    public float getArmor(){
        return armor;
    }

    //增加移动速度
    public void addSpeed(int speed){
        //在原来的基础上增加移动速度
        moveSpeed = moveSpeed + speed;
    }

    public abstract void attack();
}
