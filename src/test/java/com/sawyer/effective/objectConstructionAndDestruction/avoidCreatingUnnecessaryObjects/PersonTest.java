package com.sawyer.effective.objectConstructionAndDestruction.avoidCreatingUnnecessaryObjects;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 11:09 AM 2019/2/3
 */

public class PersonTest extends BaseTest {

    @Test
    public void test() {
        Person person = new Person(LocalDate.of(2000, 1, 20));
        Assert.assertTrue(person.isBornIn2000());
    }

}