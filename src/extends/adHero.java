package jc;

public class adHero extends Hero implements AD{

    adHero(String name,float hp,float armor,int moveSpeed){
        this.name=name;
        this.hp=hp;
        this.armor=armor;
        this.moveSpeed=moveSpeed;
    }

    @Override
    public void attack() {
        System.out.println("英雄可以进行普通攻击");
    }

    @Override
    public void physicAttack() {
        System.out.println("AD英雄可以进行物理攻击");
    }
}