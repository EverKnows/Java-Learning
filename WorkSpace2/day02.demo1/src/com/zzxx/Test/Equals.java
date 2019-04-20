package com.zzxx.Test;

public class Equals {
    public static void main(String[] args) {
        String str1 = "test";
        String str2 = "test";
        String str3 = new String("test");
        String str6 = new String("test");
        StringBuilder str4 = new StringBuilder("test");
        StringBuilder str5 = new StringBuilder("test");

        System.out.println(str1.equals(str2));// true
        System.out.println(str1.equals(str3));// true
        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str4 == str5); // false
        System.out.println(str4.equals(str5));// false
        System.out.println(str3 == str6); // false
        System.out.println(str3.equals(str6)); // true


    }
}
/*
总结：
    在String类中对equals方法进行了重写
        public boolean equals(Object anObject) {
            if (this == anObject) {
             return true;
            }
            if (anObject instanceof String) {
            String anotherString = (String) anObject;
                int n = value.length;
            if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
            }
            }
            return false;
            先比较内存地址，如果内存地址不一样在比较对应的字符串值长度和内容

    在非String类中，equals方法和==相同都是比较两个对象的内存地址
 */
