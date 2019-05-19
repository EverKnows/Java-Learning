package day06;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * 获取并输出当前目录下所有文件的名字
 * @author Bonnie
 *
 */
public class Test06 {
    public static void getCurDirFileName(String name, ArrayList<String> list) {
        File file = new File(name);
        File[] fileList = file.listFiles();
        for (File item : fileList) {
            if (item.isDirectory()) {
                getCurDirFileName(name + "/" + item.getName(), list);
            }
            list.add(item.getName());
        }
    }
    public static void main(String[] args) {
        String name = "src/day06";
        ArrayList<String> nameList = new ArrayList<>();
        getCurDirFileName(name, nameList);
        System.out.println(nameList);
    }
}
