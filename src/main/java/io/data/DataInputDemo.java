package io.data;

import io.utils.FileUtil;

import java.io.*;

/**
 * 处理流-DataInputStream|DataOutputStream
 * 读取写入基本数据类型，读取和写入的顺序要一样,顺序不一样会抛EOF异常
 *
 * 分别从文件和字节数组读取和写入数据
 * @Author chenlei10
 * @Date 2017/10/13 16:55
 */
public class DataInputDemo {
    public void writeToFile(String filePath){
        File file = new File(filePath);

        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new FileOutputStream(file));
            out.writeBoolean(true);
            out.writeDouble(2.2);
            out.writeInt(12);
            out.writeUTF("这是写入的UTF字符串");
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeIO(out);
        }
    }


    public void readFromFile(String filePath){
        File file = new File(filePath);

        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream(file));
            System.out.println(in.readBoolean());
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readUTF());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeIO(in);
        }
    }

    /**
     * 写入一些数据到字节数组
     * @return
     */
    public byte[] writeToByteArray(){
        byte[] dest = null;

        DataOutputStream dos = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);

            dos.writeBoolean(true);
            dos.writeDouble(2.2);
            dos.writeInt(12);
            dos.writeUTF("这是写入的UTF字符串");

            dos.flush();
            dest = bos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(dos,bos);
        }
        return dest;
    }

    public void readFromByteArray(byte[] bytes){
        DataInputStream din = null;
        ByteArrayInputStream bin = null;

        bin = new ByteArrayInputStream(bytes);
        din = new DataInputStream(bin);
        try {
            System.out.println(din.readBoolean());
            System.out.println(din.readDouble());
            System.out.println(din.readInt());
            System.out.println(din.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(din,bin);
        }
    }

    public void readAndWriteByByteArray(){
        readFromByteArray(writeToByteArray());
    }

}
