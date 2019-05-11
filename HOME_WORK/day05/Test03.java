package day05;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个List集合中。
 * 并对集合排序，然后输出每个员工信息。
 * 
 * 再根据员工的入职时间排序，入职晚的在前，早的在后并
 * 输出每个员工的信息。
 * @author Bonnie
 *
 */
public class Test03 {
    @Test
    public void test() throws Exception {
        int empNum = 2;
        List<Emp> list = new ArrayList<>();
        String[] empInfo = new String[empNum];
        Emp[] emps = new Emp[empNum];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        empInfo[0] = "张三,28,男,5000,2006-02-15";
        empInfo[1] = "李四,26,女,6000,2007-12-24";
        for (int i = 0; i < empNum; i++) {
            System.out.println(empInfo[i]);
            String[] infos = empInfo[i].split(",");
            Date date = sdf.parse(infos[4]);
            //System.out.println(date);
            emps[i] = new Emp(infos[0], Integer.valueOf(infos[1]), infos[2], Integer.valueOf(infos[3]),
                    date);
            list.add(emps[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
