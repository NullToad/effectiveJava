package com.sawyer.effective.commonMethodForAllObjects.commonMethod;

/**
 * @Author: Sawyer
 * @Description: 演示常用的通用方法，equals, hashCode, toString, clone, compareTo
 * @Date: Created in 1:52 PM 2019/2/11
 */

public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    private final int areaCode;

    private final int phone;

    private volatile int hashCode;

    public PhoneNumber(int areaCode, int phone) {
        this.areaCode = areaCode;
        this.phone = phone;
    }

    /**
     * equals方法必须具备自反性，对称性，传递性，一致性和非空性
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
        return pn.areaCode == areaCode && pn.phone == phone;
    }

    /**
     * 覆盖了equals方法必须同时覆盖hashCode方法，否则在使用HashMap, HashSet时会有问题。
     * 要保证每个在equals方法中使用的属性都在hashCode中使用
     * 如果计算hashCode开销比较大，可以缓存起来
     * @return
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + phone;
            hashCode = result;
        }
        return result;
    }

    /**
     * 建议每个类都覆盖toString方法，切提供一个自描述的实现
     * @return
     */
    @Override
    public String toString() {
        return areaCode + "-" + phone;
    }

    /**
     * 实现cloneable的类需要覆盖clone方法，通常的做法是调用super.clone()，但如果实例中有数组（如MyStack类），
     * 则需要对数组域进行递归调用clone方法；
     * 在具体编程中，不建议实现cloneable接口并且提供clone方法
     * @return
     */
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            //不可能出现
            throw new AssertionError();
        }
    }

    /**
     * 对于"值类"，建议实现compareTo方法，以便使用TreeSet, TreeMap等有序容器
     * @param o
     * @return
     */
    @Override
    public int compareTo(PhoneNumber o) {
        //先比较areaCode后比较phone
        if (areaCode < o.areaCode) {
            return -1;
        } else if (areaCode > o.areaCode) {
            return 1;
        }
        if (phone < o.phone) {
            return -1;
        } else if (phone > o.phone) {
            return 1;
        }
        return 0;
    }
}
