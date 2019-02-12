package com.sawyer.effective.classAndInterface.forwarding;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 11:18 AM 2019/2/12
 */

public class ForwardingTest extends BaseTest {

    @Test
    public void wrongSet() {
        WrongSet<String> wrongSet = new WrongSet<>();
        wrongSet.addAll(Arrays.asList("one", "two", "three"));
        Assert.assertNotEquals(3, wrongSet.getAddCount());
        System.out.println("count is " + wrongSet.getAddCount()); //错误的算成了6，因为addAll是通过调用add实现的
    }

    @Test
    public void rightSet() {
        InstrumentedSet<String> rightSet = new InstrumentedSet<>(new TreeSet<>());
        rightSet.addAll(Arrays.asList("one", "two", "three"));
        Assert.assertEquals(3, rightSet.getAddCount()); //正确
    }
}