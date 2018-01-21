package io.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author chenlei10
 * @Date 2017/10/12 17:42
 */
public class FileUtil {
    public static void closeIO(Closeable ... ios){
        for (Closeable io : ios){
            try {
                io.close();
            } catch (IOException e) {
                System.out.println("关闭IO异常");
                e.printStackTrace();
            }
        }
    }
}
