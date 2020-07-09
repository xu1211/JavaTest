package jc;

public abstract class Hero {
    String name; //姓名

    float hp; //血量

    float armor; //护甲

    int moveSpeed; //移动速度

    //获取护甲值
    float getArmor(){
        return armor;
    }

    //增加移动速度
    void addSpeed(int speed){
        //在原来的基础上增加移动速度
        moveSpeed = moveSpeed + speed;
    }

    public abstract void attack();
}
