package day02;
/**
 * 输入一个IP地址，然后将4段数字分别输出
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) {
        String str = "198.120.1.1";
        String[] strArr = str.split(".");
        for (String i : strArr) {
            System.out.println(i);
        }
    }
}
