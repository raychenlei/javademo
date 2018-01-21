package io.convert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author chenlei10
 * @Date 2017/10/13 14:29
 */
public class FileCodeDemoTest {
    @Test
    public void writeFile() throws Exception {
        new FileCodeDemo().writeFile("D:\\test\\text\\demo3.txt","gbk");
    }

    @Test
    public void readFile() throws Exception {
        new FileCodeDemo().readFile("D:\\test\\text\\demo3.txt","gbk");
    }

}