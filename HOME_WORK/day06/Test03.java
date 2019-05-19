package day06;

import org.junit.Test;

import java.io.File;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 * @author Bonnie
 *
 */
public class Test03 {
    @Test
    public void test01(){
        String dicName = "myDic";
        File file = new File("src/day06", dicName);
        int i = 1;
        while (file.exists()) {
            if (i == 1) {
                System.out.println("该目录已经存在，即将创建副本");
            }
            dicName = dicName + "_副本" + i;
            i++;
            file = new File("src/day06", dicName);
        }
        file.mkdir();
    }
}
