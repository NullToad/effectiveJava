package com.sawyer.effective.objectConstructionAndDestruction.removeExpiredRef;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author: Sawyer
 * @Description: 对于需要自己管理内存的类，主要是容器类，需要注意即使清除不需要的引用，避免内存泄漏
 * @Date: Created in 10:56 AM 2019/2/11
 */

public class MyStack {

    private int size = 0;
    private static final int DEFAULT_INITIAL_SIZE = 16;
    private Object[] elements;

    public MyStack () {
        elements = new Object[DEFAULT_INITIAL_SIZE];
    }

    public void push(Object element) {
        ensureSize();
        elements[size++] = element;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        //set element to null to avoid memory leak
        Object element = elements[--size];
        elements[size] = null;
        return element;
        //return elements[--size];
    }

    /**
     * expand size if needed
     */
    private void ensureSize() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }
}
