/*
    题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        char[]  str = str1.toCharArray();
        int letterCount = 0;
        int spaceCount = 0;
        int otherCount = 0;
        int numCount = 0;

        for (int i = 0; i < str.length; ++ i) {
            if ( (str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z')) {
                ++ letterCount;

            } else if ( str[i] >= '0' && str[i] <= '9') {
                ++ numCount;

            } else if ( str[i] == ' ') {
                ++ spaceCount;

            } else {
                ++ otherCount;

            }

        }
        System.out.println("字母的总数为" + letterCount);
        System.out.println("数字的总数为" + numCount);
        System.out.println("空格的总数为" + spaceCount);
        System.out.println("其他字符的总数为" + otherCount);
    }
}

