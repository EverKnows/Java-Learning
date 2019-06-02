package day07;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        File file = new File("src/day07/" + name);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));
        String context = null;
        while(!(context = scan.nextLine()).equals("exit")) {
            pw.println(context);
            pw.flush();
        }
        pw.close();

    }
}
