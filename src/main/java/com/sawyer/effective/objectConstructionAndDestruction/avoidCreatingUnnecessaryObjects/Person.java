package com.sawyer.effective.objectConstructionAndDestruction.avoidCreatingUnnecessaryObjects;

import java.time.LocalDate;

/**
 * @Author: Sawyer
 * @Description: 对于不在变化的变量，可以在静态域中声明，这样只会创建一次
 * @Date: Created in 10:53 AM 2019/2/3
 */

public class Person {

    private final LocalDate birthday;
    private static final LocalDate startDate = LocalDate.of(2000, 1, 1);
    private static final LocalDate endDate = LocalDate.of(2001, 1, 1);

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    static {
        //也可在静态块中进行创建
    }

    public boolean isBornIn2000() {
        //不要在实例域中创建固定值的变量
        return birthday.isAfter(startDate) && birthday.isBefore(endDate);
    }
}
