package io.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author chenlei10
 * @Date 2017/10/13 17:02
 */
public class DataInputDemoTest {
    @Test
    public void readAndWriteByByteArray() throws Exception {
        new DataInputDemo().readAndWriteByByteArray();
    }

    @Test
    public void readFromFile() throws Exception {
        new DataInputDemo().readFromFile("D:\\test\\text\\demo5.txt");

    }

    @Test
    public void writeToFile() throws Exception {
        new DataInputDemo().writeToFile("D:\\test\\text\\demo5.txt");
    }

}