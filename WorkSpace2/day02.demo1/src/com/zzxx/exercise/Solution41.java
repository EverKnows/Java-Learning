/*
    题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份
    ，多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的
    桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
    第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
 */
package com.zzxx.exercise;

public class Solution41 {
    public static void main(String[] args) {
        int k = 0;
        boolean flag = true;
        int count = 0;
        int k1 = 0;

        while (flag) {
            ++k;
            count = 0;
            k1 = k;
            for (int i = 0; i < 4; i++) {
                if (cacuPeaches(k1) - (int)cacuPeaches(k1) == 0.0) {
                    ++count;
                    k1 = (int)cacuPeaches(k1);
                    if (count == 4) {
                        flag = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(5 * k1 + 1);
    }

    public static double cacuPeaches(int k) {
        return (5 * k + 1) / 4.0;
    }
}
