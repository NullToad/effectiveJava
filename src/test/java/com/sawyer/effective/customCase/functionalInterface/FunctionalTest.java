package com.sawyer.effective.customCase.functionalInterface;

import com.sawyer.effective.BaseTest;
import org.junit.Test;
import static com.sawyer.effective.customCase.functionalInterface.Functional.*;

import java.util.Random;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 4:48 PM 2019/6/25
 */

public class FunctionalTest extends BaseTest {

    @Test
    public void testPredict() {
        doPredict(10, x -> x > 5);
    }

    @Test
    public void testConsumer() {
        doConsume("hello", System.out::println);
    }

    @Test
    public void testSupplier() {
        doSupplier(10, () -> {
            Random random = new Random();
            return random.nextInt();
        });
    }

    @Test
    public void testFunction() {
        doFunction(10, x -> (int) Math.pow(x, 2d));
    }

}