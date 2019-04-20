package com.zzxx.Test;

abstract class abstractTest {
    public static double c;
    public abstractTest(double c) {
        this.c = c;

    }
    public abstract void printf();

}

public class testAbstract extends abstractTest {
    public testAbstract(double c)
    {
        super(c);

    }
    public void printf() {
        System.out.println("This is a test");
        System.out.println(this.c);
    }
}
