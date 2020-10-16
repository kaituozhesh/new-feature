package chapter1.domain;

import lombok.Data;

/**
 * @ClassName Apple
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 13:29
 * @Version V1.0.0
 **/
@Data
public class Apple extends Fruit {

    private String name;

    private String color;

    public Apple(String name) {
        this.name = name;
    }

    public Apple() {
    }
}
