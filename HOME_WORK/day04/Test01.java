package day04;

import org.junit.Test;

import java.util.HashSet;

/**
 * 创建一个集合c1，存放元素"one","two","three"
 * 再创建一个集合c2，存放元素"four","five","six"
 * 然后将c2元素全部存入c1集合
 * 然后在创建集合c3,存放元素"one,five"
 * 然后输出集合c1是否包含集合c3的所有元素
 * 然后将c1集合中的"two"删除后再输出c1集合
 * @author Bonnie
 *
 */
public class Test01 {
    @Test
    public void test() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        HashSet<String> set3 = new HashSet<>();
        set1.add("ONE");
        set1.add("TWO");
        set1.add("THREE");
        set2.add("FOUR");
        set2.add("FIVE");
        set2.add("SIX");
        set3.add("ONE");
        set3.add("FIVE");
        set1.addAll(set2);
        System.out.println(set1.containsAll(set3));
        set1.remove("TWO");
        for (String str : set1) {
            System.out.println(str);
        }
    }
}




