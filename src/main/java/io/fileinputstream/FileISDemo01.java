package io.fileinputstream;

import io.utils.FileUtil;

import java.io.*;

/**
 * 1、读取文件
 * 2、按字节写入文件
 * 3、拷贝文件
 * @author chenlei10
 * @date 2017/10/12 17:23
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
        //1、建立联系
        File file = new File(filePath);
        if (!file.isFile()) {
            System.out.println(filePath + " is not a file");
            return;
        }
        InputStream is = null;
        try {
            //2、选择流，包裹源头
            is = new FileInputStream(file);
            //3、定义读取的数组，按数组的大小进行读取
            byte[] buf = new byte[1024];
            while(-1 != is.read(buf,0,buf.length)){
                System.out.println(new String(buf));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
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
