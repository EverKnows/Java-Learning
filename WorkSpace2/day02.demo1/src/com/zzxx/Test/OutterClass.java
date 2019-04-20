package com.zzxx.Test;
//如果匿名内部类可以使用外部的非静态成员变量，则使用的非静态成员变量被视为常量（即只能使用，不能修改）
public class OutterClass {
    private static int A = 0;
    public static void main(String[] args) {
        Soo soo = new Soo() {
           public void m1() {
                System.out.println(++A);
                A++;
            }
        };
        soo.m1();
    }
}

interface Soo {
    void m1();
}
