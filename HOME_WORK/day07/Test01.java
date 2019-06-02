package day07;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 * @author Bonnie
 *
 */
public class Test01 {
    @Test
    public void test() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/day07/myfile_cp.txt");
        FileInputStream fis = new FileInputStream("src/day07/myfile.txt");
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            fos.write(buff, 0, len);
        }
        fis.close();
        fos.close();
    }
}
