package com.zzxx.Test;
import java.util.zip.*;
import java.io.*;

public class Extract {
    private String extractFileName;
    private String sourceFileName;

    public Extract(String extractFileName, String sourceFileName) {

        this.extractFileName = extractFileName;
        this.sourceFileName = sourceFileName;
    }

    public void extract() throws Exception {
        ZipFile zf = new ZipFile(new File(sourceFileName));
        ZipInputStream zi = new ZipInputStream(new FileInputStream(sourceFileName));
        if (!new File(sourceFileName).exists()) {
            System.out.println("待解压文件不存在");
            return;
        }
        for (int i = 0; i < zf.size(); i++) {
            ZipEntry ze = zi.getNextEntry();
            if (new File(ze.getName()).isDirectory()) {
                new File(extractFileName + "\\\\" + zi.getNextEntry().getName()).mkdir();

            } else {
                BufferedInputStream bi = new BufferedInputStream(zf.getInputStream(ze));
                String[] zipFileList = ze.getName().split("/");
                File extFile = new File(extractFileName + "\\\\" + zipFileList[zipFileList.length - 1]);
                if (!extFile.exists()) {
                    extFile.getParentFile().mkdir();

                }
                System.out.println("正在解压 " + zipFileList[zipFileList.length - 1] + ".....");
                BufferedOutputStream oi = new BufferedOutputStream(new FileOutputStream(extFile));
                int b = 0;
                while (b != -1) {
                    b = bi.read();
                    oi.write(b);
                }
                oi.flush();
                bi.close();
                oi.close();
            }
        }
        zi.close();


    }
}
