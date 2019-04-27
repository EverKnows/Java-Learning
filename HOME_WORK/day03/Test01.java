package day03;
/**
 * 使用Date输出当前系统时间，以及3天后这一刻的时间
 * @author Bonnie
 *
 */
import org.junit.*;

import java.util.Calendar;
import java.util.Date;

public class Test01 {
    @Test
    public void test() {
        Date curTime = new Date();
        System.out.println(curTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(curTime);
        cal.add(Calendar.DATE, 3);
        curTime = cal.getTime();
        System.out.println(curTime);
    }
}
