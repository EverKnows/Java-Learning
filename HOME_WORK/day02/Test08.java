package day02;

import java.util.Arrays;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Person对象。并存入到一个数组中。
 * 然后循环数组，输出每一个员工信息(输出使用toString返回的字符串)
 * @author Bonnie
 *
 */
public class Test08 {
    public static void main(String[] args) {
        String str = "张三,25,男,5000;李四,26,女,6000;";
        String[] person = str.split(";");
        Person[] pArr = new Person[person.length];
        int index = 0;
        while (index < person.length) {
            String[] infoArr = person[index].split(",");
            pArr[index] = new Person(infoArr[0], Integer.valueOf(infoArr[1]), infoArr[2], Integer.valueOf(infoArr[3]));
            index++;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(pArr[i].toString());
        }
    }
}
