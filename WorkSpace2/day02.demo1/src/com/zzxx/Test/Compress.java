package com.zzxx.Test;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class Compress {
    private static String zipFileName;
    private static String sourceFileName;

    public Compress(String zipFileName, String sourceFileName) {
        this.zipFileName = zipFileName;
        this.sourceFileName = sourceFileName;
    }

    public  void zip() throws Exception {
        File sourceFile = new File(sourceFileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(zipFileName));
        ZipOutputStream zos = new ZipOutputStream(bos);
        if (!sourceFile.exists()) {
            System.out.println("源文件名字错误！");
            zos.close();
            bos.close();

            return;
        }
        //zos.setLevel(Deflater.BEST_COMPRESSION);
        System.out.println("开始压缩.....");
        zip(zos, sourceFile, sourceFile.getName());
        System.out.println("压缩完成！");
        zos.close();
        bos.close();

    }
    public void getSourceFileName() {
        String[] fileName = sourceFileName.split("\\\\");
        System.out.println(fileName[fileName.length - 1]);
    }

    public void getZipFileName() {
        String[] fileName = zipFileName.split("\\\\");
        System.out.println(fileName[fileName.length - 1]);
    }

    public void zip(ZipOutputStream zos, File sourceFile, String base) throws Exception {
        if (sourceFile.isDirectory()) {
            File[] fileList = sourceFile.listFiles();
            if (fileList.length == 0) {
                zos.putNextEntry(new ZipEntry(base + '/'));
            } else {
                for (int i = 0; i < fileList.length; i++) {
                    zip(zos, fileList[i], base + "/" + fileList[i].getName());
                }
            }
        } else {
            System.out.println("正在压缩" + sourceFile.getName() + "......");
            //System.out.println(base);
            zos.putNextEntry(new ZipEntry(base));
            int data;
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream(sourceFile));

            while ((data = bi.read() ) != -1) {
                zos.write(data);
            }


        }
    }


}
