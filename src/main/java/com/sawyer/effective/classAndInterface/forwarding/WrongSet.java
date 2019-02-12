package com.sawyer.effective.classAndInterface.forwarding;

import java.util.Collection;
import java.util.HashSet;

/**
 * @Author: Sawyer
 * @Description: 错误的继承用法
 * @Date: Created in 11:15 AM 2019/2/12
 */

public class WrongSet<E> extends HashSet<E> {

    private int addCount;

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
