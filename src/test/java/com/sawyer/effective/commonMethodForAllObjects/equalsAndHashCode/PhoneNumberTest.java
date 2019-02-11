package com.sawyer.effective.commonMethodForAllObjects.equalsAndHashCode;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 1:59 PM 2019/2/11
 */

public class PhoneNumberTest extends BaseTest {

    @Test
    public void test() {
        PhoneNumber pn1 = new PhoneNumber(571, 87085347);
        PhoneNumber pn2 = new PhoneNumber(571, 87085347);
        Assert.assertEquals(pn1, pn2);
        Set<PhoneNumber> set = new HashSet<>();
        set.add(pn1);
        set.add(pn2);
        Assert.assertEquals(1, set.size());
        Assert.assertEquals("571-87085347", pn1.toString());
    }

}