package day04;

import org.junit.Test;

import java.util.*;

/**
 * 创建一个字符串数组:{"one","two","three"}
 * 然后将该数组转换为一个List集合
 * @author Bonnie
 *
 */
public class Test06 {
    @Test
    public void test01() {
        String[] strArr = {"one","two","three"};
        List<String> list = Arrays.asList(strArr);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
