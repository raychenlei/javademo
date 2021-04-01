package io.object;

import io.utils.FileUtil;

import java.io.*;

/**
 * 处理流-对象流
 * 用于序列化和反序列化
 *
 * 1、将对象写入文件
 * 2、从文件读取对象
 * @author chenlei10
 * @date 2017/10/13 17:44
 */
public class ObjectIoDemo {
    public void writeToFile(String filePath){
        File file = new File(filePath);
        Person psn = new Person("张三",18,1.7);
        ObjectOutputStream oout = null;
        FileOutputStream fout = null;

        try {
            fout = new FileOutputStream(file);
            oout = new ObjectOutputStream(fout);
            oout.writeObject(psn);
            oout.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeIO(oout,fout);
        }
    }

    public void readFromFile(String filePath){
        File file = new File(filePath);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Person psn = (Person) ois.readObject();
            System.out.println(psn.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeIO(ois);
        }
    }

    public void writeAndReadFromFile(String filePath){
        writeToFile(filePath);
        readFromFile(filePath);
    }
}
