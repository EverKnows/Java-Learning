/*
    题目：某个公司采用公用电话传递数据，数据是四位的整数，
    在传递过程中是加密的，加密规则如下：每位数字都加上5,然
    后用和除以10的余数代替该数字，再将第一位和第四位交换，
    第二位和第三位交换。输入一个未加密数据，进行加密，并解密。
    如：1256加密得到1076
 */
package com.zzxx.exercise;
import java.util.Scanner;

public class Solution42 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int passWord = scan.nextInt();
        int passWordE = enCoder(passWord);
        int passWordD = deCoder(passWordE);
        System.out.println(passWordE);
        System.out.println(passWordD);
    }
    private static int enCoder(int passWord) {
        char[] strWord = String.valueOf(passWord).toCharArray();
        char[] strWordE = new char[strWord.length];
        //String
        for (int i = 0; i < strWord.length; i++) {
            strWord[i] = String.valueOf((strWord[i] - '0' + 5) % 10).toCharArray()[0];

        }
        for (int i = 0; i < strWord.length; i++) {
            strWordE[i] = strWord[strWord.length - i - 1];

        }
        return Integer.valueOf(String.valueOf(strWordE));
    }
    private static int deCoder(int passWordE) {
        char[] strWordE = String.valueOf(passWordE).toCharArray();
        char[] strWord = new char[strWordE.length];

        for (int i = 0; i < strWordE.length; i++) {
            if (strWordE[i] - '0' >= 5) {
                strWordE[i] = String.valueOf((strWordE[i] - '0')  - 5).toCharArray()[0];
            } else {
                strWordE[i] = String.valueOf((strWordE[i] - '0') + 10 - 5).toCharArray()[0];
            }
        }
        for (int i = 0; i < strWordE.length; i++) {
            strWord[i] = strWordE[strWordE.length - 1 - i];

        }
        return Integer.valueOf(String.valueOf(strWord));
    }

}
