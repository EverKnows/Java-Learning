package day03;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 * @author Bonnie
 *
 */
public class Test03 {
    @Test
    public void test() throws Exception {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2016-09-25";
        cal.setTime(new Date());
        long a = cal.getTimeInMillis();
        cal.setTime(sdf.parse(str));
        long b = cal.getTimeInMillis();
        long total = a - b;
        System.out.println((int)(total / (24L*60*60*7000)));
    }
}
