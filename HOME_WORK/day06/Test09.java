package day06;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        RandomAccessFile rf = new RandomAccessFile("src/day06/note.txt", "rw");
        String input;
        while (!(input = scan.nextLine()).equals("exit")) {
            String str = input + "\n";
            rf.write(str.getBytes());
        }
        rf.close();
    }
}
