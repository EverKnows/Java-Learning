package day01;

import java.util.Scanner;

/**
 * 随机生成一个5位的英文字母验证码(大小写混搭)
 * 然后将该验证码输出给用户，然后要求用户输入该验证码，大小写不限制。
 * 然后判定用户输入的验证码是否有效(无论用户输入大小写，只要字母都正确即可)。
 * @author Bonnie
 *
 */
public class Test05 {
	public static void main(String[] args) {
		char[] code = new char[5];
		for (int i = 0; i < 5; i++) {
			if ((int)(Math.random() * 2) == 1) {
				code[i] = (char)((int)(Math.random() * 26) + 'A');
			} else {
				code[i] = (char)((int)(Math.random() * 26) + 'a');
			}
		}
		String str = String.valueOf(code);
		System.out.println("验证码 ： " + str);
		System.out.println("请输入验证码 ： ");
		Scanner scan = new Scanner(System.in);
		String str2 = scan.nextLine();
		System.out.println(str.equalsIgnoreCase(str2));
	}
	
}
