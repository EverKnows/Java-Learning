package day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。

 * @author Bonnie
 *
 */
public class Test10 {
    public static void main(String[] args) throws ParseException, IOException {

        Scanner scan = new Scanner(System.in);
        Emp[] emps = new Emp[5];
        String input;
        for (int i = 0; i < 5; i++) {
            input = scan.nextLine();
            String[] info = input.split(",");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            emps[i] = new Emp(info[0], Integer.valueOf(info[1]),
                    info[2], Integer.valueOf(info[3]), sdf.parse(info[4]));
            RandomAccessFile rf = new RandomAccessFile("src/day06/" +
                    emps[i].getName() + ".emp", "rw");
            rf.write(emps[i].toString().getBytes());
        }

    }
	
}
