package day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个List集合并添加元素0-9
 * 然后获取子集[3,4,5,6]
 * 然后将子集元素扩大10倍
 * 然后输出原集合。
 * 之后删除集合中的[7,8,9]
 * @author Bonnie
 *
 */
public class Test04 {
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        ArrayList<Integer> subList = new ArrayList<>(list.subList(3, 10));
        for (int i = 0; i < subList.size(); i++) {
            list.set(i, list.get(i) * 10);
        }


    }

}
