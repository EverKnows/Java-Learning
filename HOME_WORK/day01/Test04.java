package day01;
/**
 * 要求用户从控制台输入一个email地址，然后获取该email的用户名(@之前的内容)
 * @author Bonnie
 *
 */
import java.util.Scanner;
public class Test04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String email = scan.nextLine();
		int index = email.indexOf('@');
		String count = email.substring(0, index);
		System.out.println(count);
	}
}
