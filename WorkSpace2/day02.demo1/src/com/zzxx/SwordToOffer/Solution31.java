package com.zzxx.SwordToOffer;

public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 1)
            return 1;
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            char[] array = String.valueOf(i).toCharArray();
            for(char x : array) {
                if (x == '1') {
                    ++count;
                }
            }
        }
        return count;
    }
    public int NumberOf1Between1AndN_Solution2(int n) {
        int length = String.valueOf(n).toCharArray().length;
        int count = 0;
        int divide = 0;
        int x = 5;
        for (int i = 1; i < length + 1; i++) {
            divide = n / (int) Math.pow(10, i);
            count = count + divide * (int)Math.pow(10, i - 1);
            if (n - divide * (int) Math.pow(10, i) >= (x + 1) * (int)Math.pow(10, i - 1)) {
                count = count + (int) Math.pow(10, i - 1);
            } else if (n - divide * (int) Math.pow(10, i) > x * (int)Math.pow(10, i - 1) - 1) {
                count = count + n - divide * (int) Math.pow(10, i) - (x * (int) Math.pow(10, i - 1) - 1);
            } else {

            }
        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println(new Solution31().NumberOf1Between1AndN_Solution2(1));
    }
}
//http://www.cnblogs.com/cyjb/p/digitOccurrenceInRegion.html