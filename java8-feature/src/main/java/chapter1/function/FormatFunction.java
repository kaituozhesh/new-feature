package chapter1.function;

import chapter1.domain.Letter;

import java.util.function.Function;

/**
 * @ClassName FormatFunction
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 20:40
 * @Version V1.0.0
 **/
public class FormatFunction {

    public static Function<String, String> tt() {
        Function<String, String> header = Letter::addHeader;
        return header.andThen(Letter::addFooter);
    }
}
