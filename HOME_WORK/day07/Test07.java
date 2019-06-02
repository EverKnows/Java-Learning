package day07;

import org.junit.Test;

import java.io.*;

/**
 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf.txt。
 * @author Bonnie
 *
 */
public class Test07 {
    @Test
    public void test() throws IOException {
        File file = new File("src/day07/example1.txt");
        file.createNewFile();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)), true);
        pw.println("这是一个测试");
        pw.println("这是一个测试");
        pw.println("这是一个测试");
        pw.println("这是一个测试");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/day07/example1.txt")));
        PrintWriter pw1 = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("src/day07/example1_utf.txt"), "utf-8"));
        String str = null;
        while((str = br.readLine()) != null) {
            pw1.print(str);
            pw1.flush();
        }
        pw1.close();
        br.close();
        pw.close();

    }
}
