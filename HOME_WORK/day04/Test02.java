package day04;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 创建一个集合，存放元素"1","$","2","$","3","$","4"
 *   使用迭代器遍历集合，并在过程中删除所有的"$"，
 *   最后再将删除元素后的集合使用新循环遍历，并输出每一个元素。
 * @author Bonnie
 *
 */
public class Test02 {
    @Test
    public void test01() {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("$");
        set.add("2");
        set.add("$");
        set.add("3");
        set.add("$");
        set.add("4");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("$")) {
                iterator.remove();  //不能使用set中的remove方法 modCOunt !=expectedCount
            }
        }
        for(String str : set) {
            System.out.println(str);
        }
    }
}
