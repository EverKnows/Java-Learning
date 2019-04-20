package com.zzxx.Test;

import java.io.*;

public class fileTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\lenovo\\Desktop", "20190308.txt");
        String[] strArr = {"你好吗？", "好久不见。。。", "我好想你。"};

        try{
            Writer writer = new FileWriter(file);
            System.out.println(file.getName());
            BufferedWriter bufWriter = new BufferedWriter(writer, 50);
            for (int i = 0; i < strArr.length; i++) {
                bufWriter.write(strArr[i]);
                bufWriter.newLine();
            }
            bufWriter.flush();
            bufWriter.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
