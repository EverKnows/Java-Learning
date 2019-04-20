package com.zzxx.Test;
import java.util.Arrays;
import java.util.Scanner;

public class GuessGame {
   public static void main(String[] args) {
       System.out.println("GuessingGame>欢迎尝试猜字母游戏！");
       Scanner scan = new Scanner(System.in);
       char[] randomCh = getChars();
       System.out.println(Arrays.toString(randomCh));
       int count = 0;
       int[] record;
       System.out.println("GuessingGame>游戏开始，请输入你猜的五个字母序列： （exit -- 退出）");
       while (true) {
           String str = scan.nextLine();
           if (str.equals("exit")) {
               System.out.println("谢谢你的尝试，再见");
               break;
           } else {

               record = compare(str.toCharArray(), randomCh);
              // int sum2 = compare(str.toCharArray(), randomCh)[1];
               System.out.printf("GuessingGame>你猜对%d个字符，其中%d个字符的位置正确! (总次数=%d, exit -- 退出)\n", record[0], record[1], count);
               if (record[1] == 5) {
                   System.out.printf("GuessingGame>恭喜你猜对了，你的得分是：%d\n", (500 - count * 10));

               } else {
                   ++count;
               }
           }
       }
   }
   public static int[] compare(char[] inCh, char[] ranCh) {
       int sum = 0;
       int count = 0;
       int[] record = new int[2];
       int[] flag = new int[5];

       for (int i = 0; i < 5; i++) {
           for (int j = 0; j < 5; j++) {
               if (inCh[i] == ranCh[j] && flag[j] != 1) {
                   flag[j] = 1;
                   ++sum;
                   break;
               }
           }
       }
       for (int i = 0; i < 5; i++) {
           if (inCh[i] == ranCh[i]) {
               ++count;
           }
       }
       record[0] = sum;
       record[1] = count;
       return record;

   }
   public static char[] getChars() {
        char[] randomCh = new char[5];
       for (int i = 0; i < 5; i++) {
           randomCh[i] = (char)(Math.random() * 26 + 65);
       }
       return randomCh;
   }
}
