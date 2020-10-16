package chapter1.main;

import chapter1.domain.Orange;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/10/15 13:23
 * @Version V1.0.0
 **/
public class StreamTest {

    public static void main(String[] args) {
        List<Orange> orangeList = new ArrayList<>();
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));
        orangeList.add(new Orange(120, "red"));


//        Stream<Orange> orangeStream = orangeList.stream().filter(arange -> arange.getWeight() < 150);
//
//        Stream<Orange> orangeStream1 = orangeList.stream().map(orange -> {
//            orange.setWeight(orange.getWeight() + 20);
//            return orange;
//        });
        long start = 0;
        start = Instant.now().toEpochMilli();
        Integer reduce = orangeList.stream().map(Orange::getWeight).reduce(0, Integer::sum);
        System.out.println("用时 : " + (Instant.now().toEpochMilli() - start) + "毫秒");
        start = Instant.now().toEpochMilli();
        int sum = orangeList.stream().mapToInt(Orange::getWeight).sum();
        System.out.println("用时 : " + (Instant.now().toEpochMilli() - start) + "毫秒");
    }
}
