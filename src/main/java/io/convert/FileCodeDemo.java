package io.convert;

import io.utils.FileUtil;

import java.io.*;

/**
 * 文件编码格式转换
 * 编码(output)+解码(input)
 * @Author chenlei10
 * @Date 2017/10/13 14:18
 */
public class FileCodeDemo {

    public void readFile(String filePath, String charsetName){
        File file = new File(filePath);
        BufferedReader br = null;
        try {
          br = new BufferedReader(new InputStreamReader(new FileInputStream(file),charsetName));
//            br = new BufferedReader(new FileReader(file));

            String msg = null;
            while((msg = br.readLine()) != null){
                System.out.println(msg);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(br);
        }
    }

    public void writeFile(String filePath,String charsetName){
        File file = new File(filePath);
        OutputStream out = null;
//        BufferedReader br = null;

        try {
            out = new BufferedOutputStream(new FileOutputStream(file));
//            br = new BufferedReader(new FileReader(file));

            String msg = "这是一个测试字符串";
            byte[] bytes = msg.getBytes(charsetName);
            out.write(bytes);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeIO(out);
        }


    }
}
