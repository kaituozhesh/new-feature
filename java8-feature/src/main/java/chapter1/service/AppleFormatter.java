package chapter1.service;

import chapter1.domain.Apple;

/**
 * @ClassName AppleFormatter
 * @Description
 * @Author 开拓者-骚豪
 * @Date 2020/9/29 13:30
 * @Version V1.0.0
 **/
@FunctionalInterface
public interface AppleFormatter {

    /**
     * 格式化Apple
     *
     * @param apple
     * @return
     */
    String appleFormatter(Apple apple);

}
