package com.zzxx.SwordToOffer;
import java.util.*;
public class Solution19 {
  /*  public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(matrix[0][0]);
        matrix[0][0] = -999;
        addToPrintMatrix(matrix, arrayList, 0, 0, 0, 0);
        return arrayList;
    }*/
    public void addToPrintMatrix(int[][] matrix, ArrayList<Integer> arrayList, int row, int col, int seed, int count) {
        if (count == matrix.length * matrix[0].length - 1)
            return;

        switch (seed) {
            case 0:
                if (col + 1 < matrix[0].length && matrix[row][col + 1] != -999) {
                    arrayList.add(matrix[row][col + 1]);
                    matrix[row][col + 1] = -999;
                    ++count;
                    ++col;
                    addToPrintMatrix(matrix, arrayList, row, col, 0, count);
                } else {
                    addToPrintMatrix(matrix, arrayList, row, col, 1, count);
                }
                break;
            case 1:
                if (row + 1 < matrix.length && matrix[row + 1][col] != -999) {
                    arrayList.add(matrix[row + 1][col]);
                    matrix[row + 1][col] = -999;
                    ++count;
                    ++row;
                    addToPrintMatrix(matrix, arrayList, row, col, 1, count);
                } else {
                    addToPrintMatrix(matrix, arrayList, row, col, 2, count);
                }
                break;
            case 2:
                if (col - 1 >= 0 && matrix[row][col - 1] != -999) {
                     arrayList.add(matrix[row][col - 1]);
                     matrix[row][col - 1] = -999;
                     ++count;
                     --col;
                     addToPrintMatrix(matrix, arrayList, row, col, 2, count);
                } else {
                    addToPrintMatrix(matrix, arrayList, row, col, 3, count);
                }
                break;
            case 3:
                if (row - 1 >= 0 && matrix[row - 1][col] != -999) {
                    arrayList.add(matrix[row - 1][col]);
                    matrix[row - 1][col] = -999;
                    ++count;
                    --row;
                    addToPrintMatrix(matrix, arrayList, row, col, 3, count);
                } else {
                    addToPrintMatrix(matrix, arrayList, row, col, 0, count);
                }
                break;

            default:
                break;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        /*//ArrayList<Integer> arrayList = new Solution19().printMatrix(matrix);
        //System.out.print(arrayList.toArray().toString());*/
        ArrayList<Integer> arrayList = new Solution19().printMatrix(matrix);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(' ');
        }

    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> array = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return array;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
       // System.out.println(maxCol);
        int layers = (int)(Math.min(maxRow, maxCol) - 1)/2 + 1;
        for (int i = 0; i < layers; i++) {
            for (int j = i; j < maxCol - i; j++)
                array.add(matrix[i][j]);
            for (int j = i + 1; j < maxRow - i; j++) 
                array.add(matrix[j][maxCol - i - 1]);
            for (int j = maxCol - i - 2; (j >= i) && (maxRow - i - 1 != i); j--)
                array.add(matrix[maxRow - i - 1][j]);
            for (int j = maxRow - i - 2; (j > i) && (maxCol -i - 1 != i); j--)
                array.add(matrix[j][i]);

        }
        return array;
    }

}
