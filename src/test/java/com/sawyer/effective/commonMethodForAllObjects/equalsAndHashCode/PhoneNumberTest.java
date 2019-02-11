package com.sawyer.effective.commonMethodForAllObjects.equalsAndHashCode;

import com.sawyer.effective.BaseTest;
import com.sawyer.effective.commonMethodForAllObjects.commonMethod.PhoneNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
        PhoneNumber pn3 = pn1.clone();
        Assert.assertTrue(pn1 != pn3);
        Assert.assertTrue(pn1.getClass() == pn3.getClass()); //非强制
        Assert.assertTrue(pn1.equals(pn3)); //非强制，这里为true仅仅因为我们覆盖了equals方法
    }

    @Test
    public void testCompare() {
        Set<PhoneNumber> sortedSet = new TreeSet<>();
        PhoneNumber pn1 = new PhoneNumber(571, 87085347);
        PhoneNumber pn2 = new PhoneNumber(571, 87085346);
        PhoneNumber pn3 = new PhoneNumber(570, 87085347);
        sortedSet.add(pn1);
        sortedSet.add(pn2);
        sortedSet.add(pn3);
        Iterator<PhoneNumber> iterator = sortedSet.iterator();
        Assert.assertEquals(pn3, iterator.next());
        Assert.assertEquals(pn2, iterator.next());
        Assert.assertEquals(pn1, iterator.next());
    }

}