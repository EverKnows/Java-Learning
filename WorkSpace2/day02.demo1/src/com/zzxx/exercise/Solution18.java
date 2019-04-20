/*
    题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，
    乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比
    赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三
    队赛手的名单。
 */
package com.zzxx.exercise;

public class Solution18 {
    private static int[] AVsB = {-1, -1, -1};

    public static void main(String[] args) {
        char[] ATeam = {'a', 'b', 'c'};
        char[] BTeam = {'x', 'y', 'z'};
        int flag = 0;
        flag = cacuPairs(0);
        for(int i : AVsB) {
            System.out.println(ATeam[i] + " VS " + BTeam[AVsB[i]]);
        }
    }
    private static int cacuPairs(int n) {
        boolean flag = false;
        for (int i = n; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == 0 && j == 0) {
                    continue;

                }
                if ( i == 2 && (j == 0 || j == 2) ) {
                    continue;
                }
                if (judgeIn(j)) {
                    AVsB[i] = j;
                    if (cacuPairs(i + 1) == 0) {
                        AVsB[i] = -1;

                    } else {
                        flag = true;
                    }
                }


            }
            if (flag == true) {
                continue;
            } else {
                return 0;
            }

        }
        return 1;
    }
    private static boolean judgeIn(int j) {
        for(int i : AVsB) {
            if (i == j) {
                return false;
            }
        }
        return true;
    }
}
/*
采用深度遍历的算法，遍历每一种配对方法，使用对应的配对方法完成配对，如果发现有违法配对
或者有人为配对的情况，则返回上一次的配对点，并且排除对应的配对方式，直到找出正确的配对
方式。
 */