package com.zzxx.SwordToOffer;

public class Two {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy!");
        String replaceStr = "%20";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.setLength(str.length() + 2);
                for (int j = str.length() - 1; j > i + 2; j--) {
                    str.setCharAt(j, str.charAt(j - 2));
                }
                for (int j = 0; j < 3; j++) {
                    str.setCharAt(i + j, replaceStr.charAt(j));
                }
            }
        }
        System.out.println(str);
    }
}
