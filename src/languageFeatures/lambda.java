package languageFeatures;

import extendsTest.Hero;
import extendsTest.adHero;

import java.util.*;

/*
 * 匿名函数，闭包
 *
 * */
public class lambda {
    public static void main(String[] args) {
        System.out.println("0. init 初始数据");
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new adHero("Hero" + i, r.nextInt(100) % (100 - 0 + 1) + 0, r.nextInt(100) % (100 - 0 + 1) + 0, 200));
        }
        for (Hero item : heros) {
            System.out.println(" " + item.name + " " + item.hp + " " + item.armor + " " + item.moveSpeed);
        }

        System.out.println("1. 使用匿名内部类，筛选");
        filter(heros, new HeroChecker() {
            @Override
            public boolean check(Hero h) {
                return (h.hp < 90 && h.armor < 90);
            }
        });

        System.out.println("2. 使用Lamdba的方式，筛选");
        filter(heros, h -> h.hp < 90 && h.armor < 90);
    }


    /**
     * 注意：该方法需要传入 HeroChecker函数
     *
     * @param heros       List<Hero>对象
     * @param heroChecker HeroChecker函数
     */
    private static void filter(List<Hero> heros, HeroChecker heroChecker) {
        for (Hero hero : heros) {
            if (heroChecker.check(hero))
                System.out.println(" " + hero.name);
        }
    }
}
