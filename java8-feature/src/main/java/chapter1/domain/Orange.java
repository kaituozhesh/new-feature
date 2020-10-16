package chapter1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Oranga
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 19:52
 * @Version V1.0.0
 **/
@Data
@AllArgsConstructor
public class Orange {

    private Integer weight;

    private String color;

    public Orange() {
    }

    public Orange(Integer weight) {
        this.weight = weight;
    }
}
