package io.object;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chenlei10
 * @date 2017/10/13 18:00
 */
public class ObjectIoDemoTest {
    @Test
    public void writeAndReadFromFile() throws Exception {
        new ObjectIoDemo().writeAndReadFromFile("D:\\test\\text\\demo6.txt");
    }

}