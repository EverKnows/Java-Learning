package day07;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) throws ParseException, IOException {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            Emp emp = parseToEmp(scan.nextLine());
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/day07/" + emp.getName() + ".obj"));
            oos.writeObject(emp);
            oos.close();
        }
    }
    public static Emp parseToEmp(String info) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] infos = info.split(",");
        String name = infos[0];
        int age = Integer.valueOf(infos[1]);
        String sex = infos[2];
        int salary = Integer.valueOf(infos[3]);
        Date hiredate = sdf.parse(infos[4]);
        return new Emp(name, age, sex, salary, hiredate);
    }
}
