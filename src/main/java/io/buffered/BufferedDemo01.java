package io.buffered;

import io.utils.FileUtil;

import java.io.*;

/**
 * 处理流-缓冲流
 * 1、拷贝文件
 * 2、拷贝目录（子目录和文件）
 * @Author chenlei10
 * @Date 2017/10/13 10:35
 */
public class BufferedDemo01 {
    /**
     * 拷贝文件
     * @param originFilePath 源文件地址
     * @param destFilePath  目标文件夹
     */
    public void copyFile(String originFilePath, String destFilePath){
        File originFile = new File(originFilePath);
        File destFile = new File(destFilePath);
        if (!destFile.exists()) {
            destFile.mkdirs();//确保文件夹存在
        }
        if (destFile.isDirectory()) {
            destFile = new File(destFilePath,originFile.getName());
        }
        copyFile(originFile,destFile);
    }

    /**
     * 拷贝文件
     * @param originFile 源文件
     * @param destFile 目标文件
     */
    public void copyFile(File originFile, File destFile){
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(originFile));
            out = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] buf = new byte[1024];
            int len = 0;
            while (-1 != (len = in.read(buf))){
                out.write(buf,0,len);
                out.flush();
            }

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读写文件失败");
            e.printStackTrace();
        } finally {
            FileUtil.closeIO(out,in);
        }
    }

    /**
     * 拷贝目录+文件
     * @param originPath 源目录
     * @param destPath  目标目录
     */
    public void copyDirectory(String originPath, String destPath){
        if (destPath.contains(originPath)) {
            System.out.println("不能拷贝到子目录");
        }
        File originFile = new File(originPath);
        if (originFile.isFile()) {
            copyFile(originPath, destPath);
        }else if (originFile.isDirectory()) {
            File destFile = new File(destPath, originFile.getName());
            destFile.mkdirs();
            File[] subFiles = originFile.listFiles();
            for (File subFile : subFiles){
                copyDirectory(subFile.getAbsolutePath(), destFile.getAbsolutePath());
            }
        }
    }



}
