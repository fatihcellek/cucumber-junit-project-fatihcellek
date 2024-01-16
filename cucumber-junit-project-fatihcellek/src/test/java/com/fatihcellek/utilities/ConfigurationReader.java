package com.fatihcellek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create object of properties
    // make it "private" so it's not accessible from outside the class
    // "static" is to make sure its created and loaded before everything else
    private static Properties properties = new Properties();

    static {
        try {
            //2- We need to open the file in the Java memory using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the properties file in the Properties object
            properties.load(file);

            // close the file in the memory
            file.close();
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }
    //Create a utility method to use the object to read
    //4- Use the "properties" object to read value from the file
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
