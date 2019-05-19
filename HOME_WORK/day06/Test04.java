package day06;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * 获取并输出当前目录下的所有文件和目录的名字
 * @author Bonnie
 *
 */
public class Test04 {
	@Test
    public void test() {
	    File file = new File("src/day06");
	    String[] fileListName = file.list();
        System.out.println(Arrays.toString(fileListName));
    }
}
