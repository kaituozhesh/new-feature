package chapter1.domain;

/**
 * @ClassName Letter
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 20:31
 * @Version V1.0.0
 **/
public class Letter {
    public static String addHeader(String text) { return "--- Header --- \n" + text; }
    public static String addFooter(String text) {
        return text + "\n--- Footer ---";
    }
}
