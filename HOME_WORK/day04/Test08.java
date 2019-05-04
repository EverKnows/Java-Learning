package day04;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通过控制台输入3个日期(yyyy-MM-dd格式)，然后转换为Date对象后存入
 * 集合，然后对该集合排序后输出所有日期。
 * @author Bonnie
 *
 */
public class Test08 {
    @Test
    public void test01() throws Exception {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> list = new ArrayList<>();
        /*for (int i = 0; i < 3; i++) {
            String str = scan.nextLine();
            Date date = sdf.parse(str);
            list.add(date);
        }*/
        String str1 = "2016-02-12";
        String str2 = "2016-02-13";
        String str3 = "2016-02-14";
        list.add(sdf.parse(str1));
        list.add(sdf.parse(str2));
        list.add(sdf.parse(str3));
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


}
