package day03;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * 实现时间的计算: 要求用户输入身份证号，若格式有误，要求其重新输入。然后根据身份证号码输出20岁生日
 * 所在周的周三的日期。
 * 例如:
 * 出生日期:1992-07-15。
 * 20岁生日:2012-07-15
 * 当周的周三为:2012-07-18
 * @author Bonnie
 *
 */
// regex = "\\d{18}"
public class Test05 {
    @Test
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String regex = "\\d{18}";
        System.out.println("输入你的身份证号码");
        String IDNumber = scan.nextLine();
        while (!IDNumber.matches(regex)) {
            IDNumber = scan.nextLine();
        }
        String birthDay = IDNumber.substring(6, 14);
        System.out.println(birthDay);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(birthDay);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 20);
        cal.set(Calendar.DAY_OF_WEEK, 4);
        System.out.println(cal.getTime());

    }
}
