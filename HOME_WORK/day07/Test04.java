package day07;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 * @author Bonnie
 *
 */
public class Test04 {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        File dir = new File("src/day07");
        ArrayList<Emp> list = new ArrayList<Emp>();
        File[] listFile = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String[] names = name.split("\\.");
                if ("obj".equals(names[1])) {
                    return true;
                }
                return false;
            }
        });
        for (int i = 0; i < listFile.length; i++) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/day07/" + listFile[i].getName()));
            Object obj = ois.readObject();
            list.add((Emp)obj);
        }
        Collections.sort(list, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        System.out.println(list);


    }
}
