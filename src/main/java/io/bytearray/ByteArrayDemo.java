package io.bytearray;

import io.utils.FileUtil;

import java.io.*;

/**
 * 节点流-字节数组
 * 字节数组流经常在网络环境下使用，通常数据较少
 * 字节数组流和文件流的使用方式一样
 * @Author chenlei10
 * @Date 2017/10/13 15:19
 */
public class ByteArrayDemo {

    /**
     * 将文件输出到字节数组
     * @param filePath
     * @return
     */
    public byte[] getBytesFromFile(String filePath){
        byte[] dest = null;
        File file = new File(filePath);
        InputStream in = null;
        ByteArrayOutputStream bout = null;
        byte[] buf = new byte[1024];
        int len = 0;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            bout = new ByteArrayOutputStream();
            while (-1 != (len = in.read(buf))){
                bout.write(buf,0,len);
            }
            bout.flush();
            dest = bout.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(bout,in);
        }
        return dest;
    }


    /**
     * 将字节数据输出到文件
     * @param bytes
     * @param destFilePath
     */
    public void writeToFileFromByteArray(byte[] bytes, String destFilePath){
        File destFile = new File(destFilePath);

        ByteArrayInputStream byteIn = null;
        OutputStream out = null;

        try {
            byteIn = new ByteArrayInputStream(bytes);
            out = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] buf = new byte[1024];
            int len = 0;
            while (-1 != (len = byteIn.read(buf))){
                out.write(buf,0,len);
            }
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(out,byteIn);
        }
    }

    /**
     * 使用字节数组拷贝文件
     * @param originPath
     * @param destPath
     */
    public void copyFileByByteArray(String originPath, String destPath){
        writeToFileFromByteArray(getBytesFromFile(originPath),destPath);
    }

    public void read(byte[] bytes){
        InputStream in = null;

        in = new BufferedInputStream(new ByteArrayInputStream(bytes));
        byte[] buf = new byte[1024];
        int len = 0;
        try {
            while (-1 != (len = in.read(buf))){
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(in);
        }
    }

    public byte[] write(String msg) throws IOException {
        byte[] dest = null;
        byte[] bytes = msg.getBytes("utf-8");
        ByteArrayOutputStream bout = new ByteArrayOutputStream(8);

        OutputStream out = null;
        out = new BufferedOutputStream(bout);
        out.write(bytes,0,bytes.length);
        out.flush();
        dest = bout.toByteArray();
        out.close();
        return dest;
    }
}
