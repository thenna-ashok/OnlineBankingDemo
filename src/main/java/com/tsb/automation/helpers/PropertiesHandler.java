package com.tsb.automation.helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHandler {
    public PropertiesHandler() {
    }

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();

        try {
            FileInputStream input = new FileInputStream(path);
            properties.load(input);
            return properties;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
