package com.sawyer.effective.objectConstructionAndDestruction.removeExpiredRef;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 11:08 AM 2019/2/11
 */

public class MyStackTest extends BaseTest {

    @Test
    public void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        Object result = stack.pop();
        Assert.assertEquals(1, (int) result);
    }

}