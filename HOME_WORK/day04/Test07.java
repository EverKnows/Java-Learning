package day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 创建一个List集合，并存放10个随机数，然后排序该集合
 * 后输出
 * @author Bonnie
 *
 */
public class Test07 {
    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = (int)(Math.random()*10);
            list.add(number);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
