package day06;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
 * @author Bonnie
 *
 */
public class Test02 {
    @Test
    public void test() throws IOException {
        String fileName = "exp1.txt";
        String filePre = fileName.split("\\.")[0];
        String fileNext = fileName.split("\\.")[1];
        File file = new File("src/day06", fileName);
        int i = 1;
        while (file.exists()) {
            if (i == 1) {
                System.out.println("该文件已经存在，即将创建副本");
            }
            filePre = filePre + "_副本" + String.valueOf(i++);
            file = new File("src/day06", filePre + "." + fileNext);
        }
        file = new File("src/day06", filePre + "." + fileNext);
        file.createNewFile();
        if (file.exists()) {
            System.out.println(file.getName());
        }
    }
}
