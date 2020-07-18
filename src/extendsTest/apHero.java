package extendsTest;

public class apHero extends Hero implements AP{

    apHero(String name,float hp,float armor,int moveSpeed){
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
    public void magicAttack() {
        System.out.println("AP英雄可以进行魔法攻击");
    }
}
