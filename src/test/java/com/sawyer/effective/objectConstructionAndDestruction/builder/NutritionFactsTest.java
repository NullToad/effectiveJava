package com.sawyer.effective.objectConstructionAndDestruction.builder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 4:47 PM 2019/2/2
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class NutritionFactsTest {

    @Test
    public void test() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(12, 42).calories(300).sodium(3).build();
        Assert.assertEquals(12, nutritionFacts.getServingSizes());
        Assert.assertEquals(42, nutritionFacts.getServings());
        Assert.assertEquals(300, nutritionFacts.getCalories());
        Assert.assertEquals(3, nutritionFacts.getSodium());
        Assert.assertEquals(0, nutritionFacts.getFat());
    }


}