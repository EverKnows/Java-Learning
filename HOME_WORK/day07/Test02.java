package day07;

import org.junit.Test;

import java.io.*;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 * @author Bonnie
 *
 */
public class Test02 {
    @Test
    public void test() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/day07/myfile_cp2.txt"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/day07/myfile.txt"));
        byte[] buff = new byte[1024];
        int len = 0;
        while((len = bis.read(buff)) != -1) {
            bos.write(buff, 0, len);
            bos.flush();
        }
        bos.close();
        bis.close();
    }

}
