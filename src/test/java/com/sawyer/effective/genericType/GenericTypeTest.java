package com.sawyer.effective.genericType;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 1:47 PM 2019/2/13
 */

public class GenericTypeTest extends BaseTest {

    @Test
    public void copy() {
        List<Object> dest = new ArrayList<>(Arrays.asList(new Object(), new Object(), new Object()));
        List<Integer> src = new ArrayList<>(Arrays.asList(1, 2, 3));
        Pecs.copy(dest, src);
        Assert.assertEquals(3, dest.size());
    }
}