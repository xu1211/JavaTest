package extendsTest;

public class GameStart {
    public static void main(String[] args) {
        Hero red1 = new adHero("剑圣", 100, 10, 200);
        Hero red2 = new adHero("剑圣", 100, 10, 200);
        Hero red3 = new adHero("剑圣", 100, 10, 200);
        Hero red4 = new adHero("剑圣", 100, 10, 200);
        Hero red5 = new adHero("剑圣", 100, 10, 200);

        Hero blue1 = new apHero("安妮", 90, 9, 150);
        Hero blue2 = new apHero("安妮", 90, 9, 150);
        Hero blue3 = new apHero("安妮", 90, 9, 150);
        Hero blue4 = new apHero("安妮", 90, 9, 150);
        Hero blue5 = new apHero("安妮", 90, 9, 150);

        System.out.println("克隆模式游戏开始");
        System.out.println("red1:"  + red1.name + "进入游戏");
        System.out.println("red2:"  + red2.name + "进入游戏");
        System.out.println("red3:"  + red3.name + "进入游戏");
        System.out.println("red4:"  + red4.name + "进入游戏");
        System.out.println("red5:"  + red5.name + "进入游戏");
        System.out.println("blue1:" + blue1.name + "进入游戏");
        System.out.println("blue2:" + blue2.name + "进入游戏");
        System.out.println("blue3:" + blue3.name + "进入游戏");
        System.out.println("blue4:" + blue4.name + "进入游戏");
        System.out.println("blue5:" + blue5.name + "进入游戏");

    }
}
