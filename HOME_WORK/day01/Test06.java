package day01;
/**
 * 要求用户输入一个计算表达式，可以使用加减乘除。
 * 只处理一次运算的，不要有连续加减乘除的表达式,且不做小数计算。(例:1+2+3)
 * 例如:
 * 1+2
 * 然后经过处理计算结果并输出:1+2=3
 * @author Bonnie
 *
 */
import java.util.Scanner;
public class Test06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int count = 0;
		int result = 0;
		char op = '0';
		while (count < str.length()) {
			if (str.charAt(count) > '9' || str.charAt(count) < '0') {
				op = str.charAt(count);
				break;
			}
			count++;
		}
		int num1 = parseInt(str.substring(0, count));
		int num2 = parseInt(str.substring(count + 1, str.length()));
		switch(String.valueOf(op)) {
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
		System.out.println(num1 + String.valueOf(op) + num2 + "=" + result);
	}
	public static int parseInt(String str){
		// 最后要生成的数字
		int num = 0;
		// 临时变量，用于计算对应位数的数字
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			flag = (str.charAt(i) - 48);
			/*
			 * 这里是将对应的数字计算为对应的位，例如百位数字就要用该数字乘以10的2次方
			 * 得到
			 * 可以用Math的相关方法处理(自行查看API文档)
			 */
			for (int n = 0; n < str.length() - 1 - i; n++) {
				flag *= 10;
			}
			num += flag;
		}
		return num;
	}
}








