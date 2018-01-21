package io.fileinputstream;

import io.utils.FileUtil;

import java.io.*;

/**
 * 1、读取文件
 * 2、按字节写入文件
 * 3、拷贝文件
 * @Author chenlei10
 * @Date 2017/10/12 17:23
 */
public class FileISDemo01 {
    public void writeToFile(String filePath){
        File file = new File(filePath);
        Writer writer = null;
        try {
//            InputStream is = new FileInputStream(file);
//            OutputStream os = new FileOutputStream(file);

            writer = new FileWriter(file,true);

            for (int i = 0; i < 5; i++) {
                writer.append("好 \r\n");
                writer.flush();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(writer);
        }
    }

    public void readFile(String filePath){
        File file = new File(filePath);
        if (!file.isFile()) {
            System.out.println(filePath + " is not a file");
            return;
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] buf = new byte[1024];

            while(-1 != is.read(buf,0,1024)){
                System.out.println(new String(buf));
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeIO(is);
        }
    }


    public void copyFile(String originFilePath, String destFilePath){
        File originFile = new File(originFilePath);
        File destFile = new File(destFilePath);

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(originFile);
            out = new FileOutputStream(destFile);

            byte[] buf = new byte[1024];
            while (-1 != in.read(buf,0,buf.length)){
                out.write(buf,0,buf.length);
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


}
