package day02;
/**
 * 要求用户输入一个字符串，然后若该字符串是一个整数，则转换为整数后输出乘以10后的结果
 * 若是小数，则转换为一个小数后输出乘以5后的结果，若不是数字则输出"不是数字"
 * 需要使用正则表达式进行判断。
 * @author Bonnie
 *
 */
import java.util.*;
public class Test01 {
    public static void main(String[] args) {
        String regex1 = "\\d+";
        String regex2 = "\\d+(\\.\\d+)";
        String regex3 = "^[+-]?\\d+(\\.\\d+)?$";
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if (str.matches(regex1))
            System.out.println(Integer.valueOf(str) * 10);
        if (str.matches(regex2))
            System.out.println(Double.valueOf(str) * 5);
        if (!str.matches(regex1) && !str.matches(regex2))
            System.out.println("不是数字");
    }
}
