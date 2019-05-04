package day04;

import org.junit.Test;
import java.lang.*;
import java.util.*;
import java.text.*;
/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary,hiredate;name,age,gender,salary,hiredate;....
 * 例如:
 * 张三,25,男,5000,2006-02-15;李四,26,女,6000,2007-12-24;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后输出每个员工的转正仪式日期。
 * 转正仪式日期为:入职3个月的当周周五
 * 
 * @author Bonnie
 *
 */
public class Test09 {
    @Test
    public void test01() throws Exception {
        int empNum = 1;
        HashSet<Emp> set = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        String[] empInfo = new String[empNum];
        Emp[] emps = new Emp[empNum];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < empNum; i++) {
            System.out.println("请输入员工信息：格式为[name,age,gender,salary,hiredate]");
            empInfo[i] = scan.nextLine();
        }

        for (int i = 0; i < empNum; i++) {

            System.out.println(empInfo[i]);
            String[] infos = empInfo[i].split(",");
            Date date = sdf.parse(infos[4]);
            System.out.println(date);
            emps[i] = new Emp(infos[0], Integer.valueOf(infos[1]), infos[2], Integer.valueOf(infos[3]),
                    date);
            if (!set.contains(emps[i])) {
                set.add(emps[i]);

            }

        }
        Iterator<Emp> iterator = set.iterator();
        while (iterator.hasNext()) {
            Emp emp = iterator.next();
            //System.out.println(emp.toString());
            Date date = emp.getHiredate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 3);
            cal.set(Calendar.DAY_OF_WEEK, 6);
            System.out.println(cal.getTime());

        }
    }

}
