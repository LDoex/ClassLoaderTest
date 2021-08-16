package com.oyyk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileChangeTest {
    public static void main(String[] args) throws Exception {
        File inputFilePath = new File("D:\\Users\\Mu\\IdeaProjects\\ClassLoaderTest\\out\\production\\ClassLoaderTest\\com\\oyyk\\SalaryCaler.class");
        FileInputStream fis = new FileInputStream(inputFilePath);
        File outputFilePath = new File("D:\\Users\\Mu\\IdeaProjects\\ClassLoaderTest\\out\\production\\ClassLoaderTest\\com\\oyyk\\SalaryCaler.myclass");
        FileOutputStream fos = new FileOutputStream(outputFilePath);

        int code = 1;
        fos.write(code);
        while((code = fis.read()) != -1){
            fos.write(code);
        }

        fis.close();
        fos.close();
    }
}
