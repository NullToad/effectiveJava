package com.sawyer.effective.classAndInterface.minimizeAccessibility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Sawyer
 * @Description: 使类和成员的访问级别最小化，实例域绝不能是共有的
 * @Date: Created in 4:05 PM 2019/2/11
 */

public class SafeValues {

    /**
     * 不安全，客户端可以修改数组中的内容
     */
    public static final Thing[] UNSAFE_VALUES = {
            new Thing("one"), new Thing("two")
    };

    /**
     * 安全的方法1，将数组变为不可变List
     */
    private static final Thing[] PRIVATE_VALUES = {
            new Thing("one"), new Thing("two")
    };

    public static final List<Thing> SAFE_VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    /**
     * 安全的方法2，返回私有数组的一个备份，一个新的数组，对该数组进行操作，不会影响原数组PRIVATE_VALUES
     * @return
     */
    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }


    /**
     * 如果一个似有类仅被一个共有类访问，将其声明为该共有类的嵌套类
     */
    static class Thing {
        private String name;

        public Thing(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
