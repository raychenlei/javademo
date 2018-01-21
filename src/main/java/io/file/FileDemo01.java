package io.file;

import java.io.File;

/**
 * 1、输出子孙目录|文件的绝对路径
 * 2、输出子孙目录下的指定类型文件的绝对路径
 * @Author chenlei10
 * @Date 2017/10/12 16:28
 */
public class FileDemo01 {

    public void outputSubFiles(String filePath){
        File file = new File(filePath);
        System.out.println(file.getAbsolutePath());
        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            for (File subFile : subFiles){
                outputSubFiles(subFile.getAbsolutePath());
            }
        }
    }

    public void outputSubFilesByType(String filePath, String extension){
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(extension)) {
            System.out.println(absolutePath);
            return;
        }
//        File[] subFiles = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getAbsolutePath().endsWith(extension);
//            }
//        });
        File[] subFiles = file.listFiles();

        if (subFiles != null) {
            for (File subFile : subFiles) {

                outputSubFilesByType(subFile.getAbsolutePath(), extension);
            }
        }
    }



}
