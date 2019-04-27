package day03;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将当前系统时间以"yyyy-MM-dd HH:mm:ss"格式输出
 * @author Bonnie
 *
 */
public class Test02 {
    @Test
    public void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curTime = new Date();
        String time = sdf.format(curTime);
        System.out.println(time);
    }
}
