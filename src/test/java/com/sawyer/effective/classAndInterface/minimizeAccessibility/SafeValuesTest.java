package com.sawyer.effective.classAndInterface.minimizeAccessibility;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 4:16 PM 2019/2/11
 */

public class SafeValuesTest extends BaseTest {

    @Test
    public void test() {
        //不安全的数组
        SafeValues.UNSAFE_VALUES[0] = new SafeValues.Thing("Three");
        Assert.assertEquals("Three", SafeValues.UNSAFE_VALUES[0].getName());
        //安全的方式1
        List<SafeValues.Thing> safeThings1 = SafeValues.SAFE_VALUES;
        try {
            safeThings1.add(new SafeValues.Thing("Three"));
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }
        try {
            safeThings1.set(0, new SafeValues.Thing("Three"));
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }
        //安全的方式2
        SafeValues.Thing[] safeThings2 = SafeValues.values();
        safeThings2[1] = new SafeValues.Thing("Four");
        Assert.assertEquals("Four", safeThings2[1].getName());
        SafeValues.Thing[] safeThings3 = SafeValues.values();
        Assert.assertEquals("two", safeThings3[1].getName());
    }
}