package com.zzxx.SwordToOffer;
import java.util.*;
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer str0 = new StringBuffer(str);
        Character goalCh = null;
        for (int i = 0; i < str0.length(); i++) {
            if (map.containsKey(str0.charAt(i))) {
                map.put(str0.charAt(i), map.get(str0.charAt(i)) + 1);
            } else {
                map.put(str0.charAt(i), 1);
            }
        }
        for (int i = 0; i < str0.length(); i++) {
            if (map.get(str0.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
