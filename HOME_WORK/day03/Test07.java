package day03;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 要求用户首先输入员工数量，然后输入相应员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 每一行为一个员工信息，然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 在解析成Emp对象后要先查看当前集合是否包含该员工，若包含则提示该用于已存在，
 * 否则才存入集合。
 * 然后输出集合查看每个员工信息.
 * @author Bonnie
 *
 */
public class Test07 {
    @Test
    public static void main(String[] args) throws Exception {
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
            System.out.println(emp.toString());
        }
    }

}
