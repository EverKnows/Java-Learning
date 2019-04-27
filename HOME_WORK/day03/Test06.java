package day03;

import org.junit.Test;
import java.util.*;
/**
 * 创建一个集合，存放字符串"one","two"，"three"
 * 然后输出该集合的元素个数。
 * 然后输出该集合是否包含字符串"four"
 * 然后输出集合是否不含有任何元素
 * 然后清空集合
 * 然后输出该集合的元素个数
 * 然后输出集合是否不含有任何元素
 * @author Bonnie
 *
 */
public class Test06 {
    @Test
    public void test() {
        HashSet<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        System.out.println(set.size());
        System.out.println(set.contains("four"));
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set.isEmpty());
    }
}
