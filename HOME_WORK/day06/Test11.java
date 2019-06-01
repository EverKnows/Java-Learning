package day06;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 * @author Bonnie
 *
 */
public class Test11 {
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Emp> list = new ArrayList<Emp>();
        File directory = new File("src/day06");
        File[] fileList = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String[] names = name.split("\\.");
                if (names[1].equals("emp")) {
                        return true;
                }
                    return false;
            }
        });

        for (File file : fileList) {
            Emp emp = parseInfo(file);
            list.add(emp);
        }
        Collections.sort(list, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                int t = o1.getAge() - o2.getAge();
                if (t == 0) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return t;
                }
            }
        });
        System.out.println(list.toString());

    }
    public static Emp parseInfo(File file) throws IOException, ParseException {
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
