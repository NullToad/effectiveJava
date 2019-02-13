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
    public void union() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Long> s2 = new HashSet<>(Arrays.asList(4L, 5L, 6L));
        Set<Number> result = Pecs.union(s1, s2);
        Assert.assertEquals(6, result.size());
    }

    @Test
    public void copy() {
        List<Object> dest = new ArrayList<>(Arrays.asList(new Object(), new Object(), new Object()));
        List<Integer> src = new ArrayList<>(Arrays.asList(1, 2, 3));
        Pecs.copy(dest, src);
        Assert.assertEquals(3, dest.size());
    }
}