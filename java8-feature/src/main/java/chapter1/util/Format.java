package chapter1.util;

import java.util.function.Function;

/**
 * @ClassName Format
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 20:33
 * @Version V1.0.0
 **/
public class Format {

    public static String format(String text, Function<String, String> function) {
        return function.apply(text);
    }

}
