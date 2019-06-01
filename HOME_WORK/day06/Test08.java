package day06;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 * @author Bonnie
 *
 */
public class Test08 {
    @Test
    public void test() throws IOException {
        File file = new File("raf.dat");
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeInt(Integer.MAX_VALUE);
        rf.writeLong(Long.MAX_VALUE);
        rf.seek(0);
        System.out.println(rf.readInt());
        System.out.println(rf.readLong());
        rf.close();
    }
}
