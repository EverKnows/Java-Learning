package day02;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入一个数学计算表达式，如:1+2
 * 然后输出计算后的结果:1+2=3
 * 这里计算表达式只计算一次即可，可以使用加减乘除任意一个,可以进行小数运算。
 * @author Bonnie
 *
 */
public class Test07 {
    public static void main(String[] args) {
        String regex = "\\d+(\\.\\d+)?";
        String str = "1.33+2";
        String[] num = new String[2];
        Matcher match = Pattern.compile(regex).matcher(str);
        int i = 0;
            while (match.find()) {
                /*System.out.println(match.start());
                System.out.println(match.end());
                System.out.println(match.group());*/
                num[i++] = match.group();
            }
        double num1 = Double.valueOf(num[0]);
        double num2 = Double.valueOf(num[1]);
        char s = ' ';
        int index = 0;
        while (index < str.length()) {
            char ch = str.charAt(index);
            if(ch == '+' || ch == '/' || ch == '*' || ch == '-') {
                s = ch;
                break;
            }
            index++;
        }
        double result = 0;
        switch(String.valueOf(s)) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                break;
        }
        System.out.println(num1 + String.valueOf(s) + num2 + "=" + result);
    }
}
