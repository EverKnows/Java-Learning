package day07;

import org.junit.Test;

import java.io.*;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 * @author Bonnie
 *
 */
public class Test05 {
    @Test
    public void test() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/Test011.java"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src/day07/Test05.java"));
        char[] chars = new char[1024];
        int len = 0;
        while((len = isr.read(chars)) != -1){
            osw.write(chars);
            osw.flush();
        }
        osw.close();
        isr.close();
    }

}
