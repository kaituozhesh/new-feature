package chapter1.main;

import chapter1.domain.Apple;
import chapter1.domain.Fruit;
import chapter1.domain.Letter;
import chapter1.domain.Orange;
import chapter1.function.FormatFunction;
import chapter1.service.AppleFormatter;
import chapter1.util.Format;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.scenario.effect.impl.prism.PrDrawable;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName AppleMain
 * @Description Predicate：传入一个参数 返回一个boolean
 * Function: 传入一个类型T 返回一个类型R  T和R可以是同一个类型
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 13:28
 * @Version V1.0.0
 **/
public class AppleMain implements Serializable {

    public static void main(String[] args) {

//        prettyPrintApple(Arrays.asList(new Apple(), new Apple()), Apple::toString);
//
//        filter(Arrays.asList(new Apple(), new Apple()), apple -> apple.getColor().equals("red"));
//
//        int portNumber = 8080;
////        portNumber = 1;
//        Runnable r = () -> System.out.println(portNumber);

        List<Orange> orangeList = new ArrayList<>();
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(151, "red"));
        orangeList.add(new Orange(152, "green"));
        orangeList.add(new Orange(122, "green"));

        Predicate<Orange> p = orange -> true;
        List<Orange> red = filter(orangeList, p.and(orange -> orange.getColor().equals("red")).or(orange -> orange.getColor().equals("green")).and(orange -> orange.getWeight() > 150));
        System.out.println(red);

        List<Orange> collect = orangeList.stream().filter(p.and(orange -> orange.getColor().equals("red"))
                .or(orange -> orange.getColor().equals("green"))
                .and(orange -> orange.getWeight() > 150)).collect(Collectors.toList());
        List<Orange> collect1 = orangeList.stream().filter(orange ->
                (orange.getColor().equals("red") || orange.getColor().equals("green")) && (orange.getWeight() > 150)).collect(Collectors.toList());

        List<Orange> collect2 = orangeList.stream().filter(p.and(orange -> orange.getColor().equals("red")).negate()).collect(Collectors.toList());

        List<String> red1 = orangeList.stream().map(Orange::getColor).filter(Predicate.isEqual("red")).collect(Collectors.toList());

        orangeList.stream().sorted(Comparator.comparing(Orange::getColor)).collect(Collectors.toList());

        Integer a = 1;
        Integer b = 1;

        List<Integer> numberList = Arrays.asList(5, 1, 4, 10, 7);
        List<Integer> result = numberList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(result);
        int[] numberArray = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(numberArray);

        Stream<String> strStream = Stream.of("a", "b", "c");
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);

        Stream<Double> generate = Stream.generate(Math::random);

        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(red1);
        Optional.ofNullable("").orElseGet(String::new);


/*
        orangeList.stream().collect(Collectors.toMap(Orange::getWeight, e -> e));
        orangeList.stream().collect(Collectors.toMap(Orange::getWeight, Function.identity()));
x
        Function<String, String> header = Letter::addHeader;
        System.out.println(Format.format("kaituozhe", header.compose(Letter::addFooter)));
        System.out.println();
        System.out.println(Format.format("kaituozhe", header.andThen(Letter::addFooter)));
        System.out.println();
        System.out.println(Format.format("kaituozhe", FormatFunction.tt()));
//        Function<FormatFunction, Function<String, String>> aq = FormatFunction::tt;
//        Function<Apple, String> a = Apple::getColor;


        Consumer<String> consumer = (obj) -> {
            System.out.println(obj + " : 保存数据库");
            // throw new RuntimeException("");
        };
        consumer("订单", consumer.andThen((i) -> System.out.println(" : 保存Redis")));*/
        Supplier<Orange> supplier = Orange::new;
        Orange orange = supplier.get();
        Function<Integer, Orange> function = Orange::new;
        orange = function.apply(1000);
    }


    public static <T> void consumer(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }


    public static Map<String, Function<String, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
    }

    public static Fruit giveMeFruit(String fruit, String weight) {
        return map.get(fruit.toLowerCase()).apply(weight);
    }


    private static void prettyPrintApple(List<Apple> appleList, AppleFormatter formatter) {
        appleList.forEach(apple -> {
            String s = formatter.appleFormatter(apple);
            System.out.println(s);
        });
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        list.forEach(t -> {
            if (p.test(t)) {
                result.add(t);
            }
        });
        return result;
    }

}
