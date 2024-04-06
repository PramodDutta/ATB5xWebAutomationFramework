package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader() {

    }

    public static String readyKey(String key) {
        FileInputStream fileInputStream = null;
        Properties p = null;
        try{
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
            p = new Properties();
            p.load(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return p.getProperty(key);
    }




}
