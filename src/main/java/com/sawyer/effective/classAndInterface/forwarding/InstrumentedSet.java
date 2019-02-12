package com.sawyer.effective.classAndInterface.forwarding;

import java.util.Collection;
import java.util.Set;

/**
 * @Author: Sawyer
 * @Description: Set的包装类，包含Set实例，提供额外的计数功能
 * 每一个InstrumentedSet实例都把另一个Set包装起来了，InstrumentedSet被称为包装类，这也正是decorator模式。
 * @Date: Created in 11:10 AM 2019/2/12
 */

public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

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
