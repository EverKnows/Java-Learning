package com.zzxx.SwordToOffer;

public class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return isLegal(0, sequence.length - 1, sequence);
    }
    public boolean isLegal(int start, int end, int [] seq) {
        int leftCount = 0;
        int rightCount = 0;
        int leftIndex = start;
        int rightIndex = end - 1;
        System.out.println(rightIndex);
        if (end <= start)
            return true;

        while (seq[leftIndex] < seq[end]) {
            ++leftIndex;
            ++leftCount;
        }
        //System.out.println(leftIndex);
        System.out.println(rightIndex);
        while (rightIndex >= 0 && seq[rightIndex] > seq[end]) {
            --rightIndex;
            ++rightCount;
        }
        System.out.println(rightIndex);
        if (leftCount + rightCount != end - start) {
            System.out.println('s');
            return false;
        }
        return isLegal(start, leftIndex - 1, seq) && isLegal(leftIndex, end - 1, seq);

    }

    public static void main(String[] args) {
        int[] sequence = {5, 4, 3, 2, 1};
        //new Solution23().VerifySquenceOfBST(sequence);
        System.out.println(new Solution23().VerifySquenceOfBST(sequence));
    }
}
