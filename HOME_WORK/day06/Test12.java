package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 * @author Bonnie
 *
 */
public class Test12 {
    public static void main(String[] args) throws IOException, ParseException {
        File[] fileList = searchEmp();
        Map<String, String> map = new HashMap<String, String>();
        StringBuilder sb = new StringBuilder("");
        for(File file : fileList) {
            Emp emp = parseFileToEmp(file);
            String name = emp.getName();
            sb.append(emp.getName() + ",");
            sb.append(emp.getAge() + ",");
            sb.append(emp.getSalary() + ",");
            sb.append(emp.getHiredate());
            map.put(name, sb.toString());
            sb = new StringBuilder("");
        }
        System.out.println(map.get("张三1"));
    }
    public static File[] searchEmp() {
        File dir = new File("src/day06");
        File[] fileList = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String prefix = name.split("\\.")[1];
                if ("emp".equals(prefix)) {
                    return true;
                }
                return false;
            }
        });
        return fileList;
    }
    public static Emp parseFileToEmp(File file) throws ParseException, IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        byte[] buff = new byte[1024];
        int len = rf.read(buff);
        buff = Arrays.copyOf(buff, len);
        String info = new String(buff);
        int st,ed;
        st = info.indexOf("{");
        ed = info.indexOf("}");
        info = info.substring(st + 1, ed);
        String[] infos = info.split(",");
        st = infos[0].indexOf("'");
        ed = infos[0].lastIndexOf("'");
        String name = infos[0].substring(st + 1, ed);
        int age = Integer.valueOf(infos[1].split("=")[1]);
        st = infos[2].indexOf("'");
        ed = infos[2].lastIndexOf("'");
        String sex = infos[2].substring(st + 1, ed);
        int salary = Integer.valueOf(infos[3].split("=")[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = sdf.parse(infos[4].split("=")[1]);
        Emp emp = new Emp(name, age, sex, salary, date);
        rf.close();
        return emp;
    }
}
