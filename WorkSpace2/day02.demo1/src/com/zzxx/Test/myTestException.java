package com.zzxx.Test;

public class myTestException {
    public static void main(String[] args) {
        int i = 3;
        try {
            int a = 3 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println("devide by zero!");
        }
        finally{
            i++;
        }
        System.out.println(i);
    }

}
