package io.fileinputstream;

import org.junit.Before;
import org.junit.Test;

/**
 * @author raychenlei
 * @date 2017/10/12 19:26
 */
public class FileISDemo01Test {

    private FileISDemo01 demo;

    @Test
    public void copyFile() throws Exception {
        demo.copyFile("D:\\test\\pic\\1.jpg","D:\\test\\pic\\2.jpg");
    }


    @Before
    public void init() throws Exception{
        demo = new FileISDemo01();
    }

    @Test
    public void readFile() throws Exception {
        new FileISDemo01().readFile("D:/test/text/demo.txt");
    }

    @Test
    public void writeToFile() throws Exception {

    }


}