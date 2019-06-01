package day06;

import java.io.*;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 * @author Bonnie
 *
 */
public class Test07 {
	public static void main(String[] args) {
		try {
			copy1("file.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 */
	public static void copy1(String name) throws IOException {
		File file = new File("src/day06/" + name);
		String copyFileName = name.split("\\.")[0] + "_copy." + name.split("\\.")[1];
		File file_copy = new File("src/day06/" + copyFileName);
		InputStream fis = new FileInputStream(file);
		OutputStream fos = new FileOutputStream(file_copy);
		int b;
		while((b = fis.read()) != -1) {
			fos.write((byte)b);
		}
		fis.close();
		fos.close();
	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 */
	public void copy2(String name) throws IOException{
		File file = new File("src/day06/" + name);
		String copyFileName = name.split("\\.")[0] + "_copy." + name.split("\\.")[1];
		File file_copy = new File("src/day06/" + copyFileName);
		InputStream fis = new FileInputStream(file);
		OutputStream fos = new FileOutputStream(file_copy);
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = fis.read(buff)) != -1) {
			fos.write(buff, 0 ,len);
		}
		fis.close();
		fos.close();
	}
}
