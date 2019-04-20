package com.zzxx.SwordToOffer;

public class Array2DFind {
    public static void main(String[] args) {
        int[][] arr2D = {{8,5,4,15,3,1},{20,99,10,54,12,33}};
        int target = 4;
        int row = arr2D.length;
        int col = arr2D[0].length;

        int i = 0;
        int j = col - 1;

        while (true) {
            if (arr2D[i][j] > target) {
                --j;

            } else if (arr2D[i][j] < target) {
                ++i;
            } else {
                System.out.println("Find!");
            }
            if (i >= row || j < 0) {
                System.out.println("Not Find!");
                break;
            }
        }
    }
}
