package com.selenium.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Divakar Verma
 * @created_at : 01/04/2024 - 1:17 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class ConfigDataProvider {
    private Properties properties;
    private final String propertyFilePath = "./Configuration/config.properties";

    public ConfigDataProvider() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getValueFromConfig(String varName){
        String value = properties.getProperty(varName);
        if(value!=null){
            return value;
        }
        else {
            throw new RuntimeException(varName+" is not specified in configuration");
        }
    }
}
