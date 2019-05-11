package day05;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *创建一个Map，保存某个学生的成绩:
 *在控制台输入该学生成绩，格式:
 *科目:成绩;科目:成绩;...
 *例如:  
 *语文:99;数学:98;英语:97;物理:96;化学:95
 *然后输出物理的成绩。
 *然后将化学的成绩设置为96
 *然后删除英语这一项。
 *然后遍历该Map分别按照遍历key，Entry，value
 *的形式输出该Map信息。
 * @author Bonnie
 *
 */
public class Test04 {
    @Test
    public void test(){
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 99);
        map.put("数学", 98);
        map.put("英语", 97);
        map.put("物理", 96);
        map.put("化学", 95);
        if (map.containsKey("化学")) {
            map.put("化学", 96);
        }
        if (map.containsKey("英语")) {
            map.remove("英语");
        }
        Iterator<String> iteratorKey = map.keySet().iterator();
        Iterator<Integer> iteratorValue = map.values().iterator();
        Iterator<Map.Entry<String, Integer>> iteratorEntry = map.entrySet().iterator();
        while (iteratorKey.hasNext()) {
            System.out.println(iteratorKey.next());
        }
        while (iteratorValue.hasNext()) {
            System.out.println(iteratorValue.next());
        }
        while (iteratorEntry.hasNext()) {
            System.out.println(iteratorEntry.next());
        }

    }

}
