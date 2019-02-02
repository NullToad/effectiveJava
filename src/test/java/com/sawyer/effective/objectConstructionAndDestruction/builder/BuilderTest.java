package com.sawyer.effective.objectConstructionAndDestruction.builder;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 4:47 PM 2019/2/2
 */

public class BuilderTest extends BaseTest {

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