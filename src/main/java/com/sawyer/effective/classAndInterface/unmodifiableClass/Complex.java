package com.sawyer.effective.classAndInterface.unmodifiableClass;

/**
 * @Author: Sawyer
 * @Description: 不可变类(Complex复数)，为了避免被扩展，可以用final修饰，也可提供私有构造方法
 * @Date: Created in 5:26 PM 2019/2/11
 */

public class Complex {

    private final double realPart; //实部
    private final double imaginaryPart; //虚部

    private Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    //使用静态工厂方法提供实例化
    public static Complex getInstance(double re, double im) {
        return new Complex(re, im);
    }

    //对于不可变类，只提供get方法
    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    //不可变类的方法返回的是新的实例，不能改变当前实例
    public Complex add(Complex c) {
        return new Complex(realPart + c.realPart, imaginaryPart + c.imaginaryPart);
    }

    public Complex substract(Complex c) {
        return new Complex(realPart - c.realPart, imaginaryPart - c.imaginaryPart);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        //double, float需要特殊处理，不能使用==，因为有Float.NaN, -0.0f以及类似的double常量
        return Double.compare(realPart, c.realPart) == 0 && Double.compare(imaginaryPart, c.imaginaryPart) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hasDouble(realPart);
        result = 31 * result + hasDouble(imaginaryPart);
        return result;
    }

    private int hasDouble(double val) {
        long longBits = Double.doubleToLongBits(val);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "complex(rm:" + realPart + " im:" + imaginaryPart + ")";
    }

}
