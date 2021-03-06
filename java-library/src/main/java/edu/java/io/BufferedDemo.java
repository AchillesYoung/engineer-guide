package edu.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;


public class BufferedDemo {
    /**
     *     BufferedReader has readLine method
     *     BufferedWriter has newLine method
     */
    @Test
    public void testReadLine() {

        BufferedReader reader = null;
        BufferedWriter bw = null;

        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            //2.read return null if reach end and no line break
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line+"\n");
            }
            reader = new BufferedReader(new FileReader("test.txt"));
            bw = new BufferedWriter(new FileWriter("outfile",true));
            String line2;
            while ((line2 = reader.readLine()) != null) {
                bw.write(line2);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.why catch error? it occurs, when close?
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test01() throws IOException {
        FileInputStream fis= new FileInputStream("copy.jpg");
        FileOutputStream fos= new FileOutputStream("copy3.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte [] buf = new byte[1024];
        int len;

        while ((len=bis.read(buf))!=-1) {

            bos.write(buf, 0, len);
//            ????????????
//            bos.flush();
        }
        //?????????????????????
        bis.close();
        bos.close();
    }
    @Test
    public void testBufferedReader() throws IOException {
        BufferedWriter bos = new BufferedWriter(new FileWriter("copy3.jpg") );
        BufferedReader bis = new BufferedReader(new FileReader("copy.jpg"));
        char [] buf = new char[1024];
        int len;

        while ((len=bis.read(buf))!=-1) {
            bos.write(buf, 0, len);
        }
        //?????????????????????
        bis.close();
        bos.close();
    }
}
