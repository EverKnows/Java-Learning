package day03;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**2018-03-25
 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
 * @author Bonnie
 * 
 */
public class Test04 {
    @Test
    public void test() throws Exception {
        String str = "2018-03-25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int days = 48;
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(str));
        cal.add(Calendar.DATE, days);
        cal.add(Calendar.WEEK_OF_YEAR, -2);
        cal.set(Calendar.DAY_OF_WEEK, 4);
        System.out.println(cal.getTime());
    }
	
}
