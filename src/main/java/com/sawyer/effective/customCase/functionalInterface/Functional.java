package com.sawyer.effective.customCase.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 4:47 PM 2019/6/25
 */

public class Functional {

    public static void doPredict(int x, Predicate<Integer> predicate) {
        System.out.println(predicate.test(x));
    }


    public static void doConsume(String p, Consumer<String> consumer) {
        consumer.accept(p);
    }


    public static void doSupplier(int size, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(supplier.get());
        }
        list.forEach(System.out::println);
    }


    public static void doFunction(int x, Function<Integer, Integer> function) {
        System.out.println(function.apply(x));
    }

}
