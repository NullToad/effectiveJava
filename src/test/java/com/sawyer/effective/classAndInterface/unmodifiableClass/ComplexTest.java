package com.sawyer.effective.classAndInterface.unmodifiableClass;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 9:55 AM 2019/2/12
 */

public class ComplexTest extends BaseTest {

    @Test
    public void test() {
        Complex complex1 = Complex.getInstance(10.1, 0.2);
        Complex complex2 = Complex.getInstance(2.5, 4.4);
        Complex result = complex1.add(complex2);
        System.out.println(result);
        Assert.assertEquals(12.6, result.getRealPart(), 0.1d);
        Assert.assertEquals(4.6, result.getImaginaryPart(), 0.1d);
    }

}