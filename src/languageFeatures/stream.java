package languageFeatures;

import extendsTest.Hero;
import extendsTest.adHero;

import java.util.*;
import java.util.stream.Collectors;

public class stream {

    public static void main(String[] args) {
        //init
        List<String> list = Arrays.asList("a", "a", "bc", "abc", "abcd", "efg", "jkl", "");


        List<Hero> heros = new ArrayList<Hero>();
        heros.add(new adHero("Hero1", 100, 100, 200));
        heros.add(new adHero("Hero1", 100, 100, 200));
        heros.add(new adHero("Hero2", 100, 100, 200));
        heros.add(new adHero("Hero2", 100, 100, 200));
        heros.add(new adHero("Hero3", 100, 100, 200));

/*
使用语法：
  串行流：  数据源.stream().中间操作().中间操作().最终操作()
  并行流：  数据源.parallelStream().中间操作().中间操作().最终操作()

    数据源：【集合，数组，I/O channel，产生器generator】

    中间操作： 返回stream，可多个中间操作叠加
        filter(Predicate)   ：对元素进行过滤
        sorted(Comparator)  ：对元素排序
        map(fun)            ：元素映射
        flatMap()
        distinct()          ：去除重复的元素
        limit(n)            ：获取n个流元素
        skip(n)             ：跳过n个流元素

    最终操作： 返回数据
        forEach(fun)        ：遍历每个元素。
        reduce()            ：把Stream 元素组合起来。例如，字符串拼接，数值的 sum，min，max ，average 都是特殊的 reduce。
        min(Comparator)     ：找到最小值。
        max(Comparator)     ：找到最大值。
        collect(Collector)  ：收集器操作
                    Collectors.toList()
                    Collectors.toMap()
                    Collectors.maxBy()
                    Collectors.minBy()
                    Collectors.groupingBy() 分组
                    Collectors.collectingAndThen() 对归纳的结果进行二次处理

* */
        System.out.println("----串行流:");
        list
                .stream()
                .forEach(System.out::println);

        System.out.println("----并行流:");
        list
                .parallelStream()
                .forEach(System.out::println);

        System.out.println("----中间操作-filter()：对元素进行过滤");
        list
                .stream()
                .filter(param -> !param.contains("a"))
                .forEach(System.out::println);

        System.out.println("----中间操作-sorted()：1对元素默认排序");
        list
                .stream()
                .sorted()
                .forEach(System.out::println);

        //Stream<T> sorted(Comparator<? super T> comparator);
        System.out.println("----中间操作-sorted()：2对元素指定规则排序");
        list
                .stream()
                .sorted((p1, p2) -> p1.hashCode() < p2.hashCode() ? 1 : -1)
                .forEach(System.out::println);

        // Stream<R> map(Function<? super T:输入,? extends R:输出> mapper)
        System.out.println("----中间操作-map()：1元素映射");
        heros
                .stream()
                .map(Hero::getName)
                .forEach(System.out::println);

        System.out.println("----中间操作-map()：元素映射2");
        list
                .stream()
                .map(param -> param.contains("a") ? 1 : param)
                .forEach(System.out::println);

        System.out.println("----中间操作-distinct()：去除重复的元素");
        list
                .stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("----最终操作-reduce：把集合里的数据组合起来");
        System.out.println(
                list
                        .stream()
                        .reduce((p1, p2) -> "<" + p1 + p2 + ">")
                        .get()
        );

        System.out.println("----最终操作-collect( Collectors.toList() )：收集元素到list");
        list
                .stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("----最终操作-collect(Collectors.groupingBy)：根据指定字段 分组为map");
        Map<String, List<Hero>> map = heros
                .stream()
                .collect(Collectors.groupingBy(Hero::getName));
        System.out.println("----根据指定字段 分组为map:" + map);

        System.out.println("----最终操作-collect(Collectors.groupingBy)：分组 + 求和");
        Map<String, Double> result1 = heros.stream()
                .collect(Collectors.groupingBy(Hero::getName, Collectors.summingDouble(Hero::getArmor)));
        System.out.println("----分组 + 求和:" + result1);

        System.out.println("----最终操作-collect(Collectors.groupingBy)：分组 + key排序 + 求和");
        TreeMap<String, Double> result2 = heros.stream()
                .collect(Collectors.groupingBy(Hero::getName, TreeMap::new, Collectors.summingDouble(Hero::getArmor)));
        System.out.println("----分组 + key排序 + 求和:" + result2);

        System.out.println("----最终操作-collect(Collectors.groupingBy)：分组 + value排序 + 求和");
        List<Map.Entry<String, Double>> result3 = heros.stream()
                .collect(Collectors.groupingBy(Hero::getName, TreeMap::new, Collectors.summingDouble(Hero::getArmor)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("----分组 + value排序 + 求和:" + result3);

        //遍历map
        map.forEach((s, heroList) -> {
                    System.out.println(s + "：");
                    map.get(s).forEach(System.out::println);
                }
        );


        System.out.println("----最终操作-collect( Collectors.collectingAndThen )：根据某字段去重");
        heros = heros.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(
                                        () -> new TreeSet<>(Comparator.comparing(Hero::getName))
                                ), ArrayList::new
                        )
                );

    }

}
