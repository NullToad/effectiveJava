package com.sawyer.effective.commonMethodForAllObjects.equalsAndHashCode;

/**
 * @Author: Sawyer
 * @Description: 牢记，覆盖equals方法时也要覆盖hashCode方法
 * @Date: Created in 1:52 PM 2019/2/11
 */

public final class PhoneNumber {

    private final int areaCode;

    private final int phone;

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
     * 覆盖了equals方法必须同时覆盖hashCode方法，否则在使用集合类时会有问题。要保证每个在equals方法中使用的属性都在hashCode中使用
     * @return
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + phone;
        return result;
    }
}
