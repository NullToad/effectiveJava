package com.sawyer.effective.genericType;

import java.util.*;

/**
 * @Author: Sawyer
 * @Description: PECS原则，producer-extends, consumer-super
 * @Date: Created in 1:41 PM 2019/2/13
 */

public class Pecs {

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (srcSize > dest.size())
            throw new IndexOutOfBoundsException("Source does not fit in dest");

        if (src instanceof RandomAccess && dest instanceof RandomAccess) {
            for (int i = 0; i < srcSize; i++)
                dest.set(i, src.get(i));
        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i = 0; i < srcSize; i++) {
                di.next();
                di.set(si.next());
            }
        }
    }
}
