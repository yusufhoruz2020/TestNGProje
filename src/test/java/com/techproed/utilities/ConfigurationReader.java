package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    // ConfigurationReader class'ini projemizin her yerinde nesne uretmeden, miras almadan kullanabilecek sekilde tasarlayalim

    // static : program calisir calismaz, bellekte yer tutmaya yarayan keyword

    static Properties properties;

    static {
        String path = "configuration.properties";
        try {


            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        }catch (Exception e) {

        }

        }

    //  properties.getProperty("username")  --> manager2
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
