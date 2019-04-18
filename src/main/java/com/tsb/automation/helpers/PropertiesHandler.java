package com.tsb.automation.helpers;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author thenna
 * This class loads the properties used across this project
 */
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
            Log.log.error("Exception while loading properties: " + exception.getMessage());
            return null;
        }
    }
}
