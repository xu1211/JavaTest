package jc;

public class GameStart {
    public static void main(String[] args) {
        Hero red1 = new adHero("剑圣",100,10,200);
        Hero red2 = new adHero("剑圣",100,10,200);
        Hero red3 = new adHero("剑圣",100,10,200);
        Hero red4 = new adHero("剑圣",100,10,200);
        Hero red5 = new adHero("剑圣",100,10,200);

        Hero blue1 = new apHero("安妮",90,9,150);
        Hero blue2 = new apHero("安妮",90,9,150);
        Hero blue3 = new apHero("安妮",90,9,150);
        Hero blue4 = new apHero("安妮",90,9,150);
        Hero blue5 = new apHero("安妮",90,9,150);

        System.out.print("克隆模式游戏开始");
    }
}
