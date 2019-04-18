package com.tsb.automation.helpers;

import java.io.File;
import java.util.Properties;

public class GetFilePathHelper {
    private static String globalPropertiesFile = "autotest.properties";
    private static String log4jPropertiesFile = "log4j.properties";

    private static File file = new File("src\\main\\resources");
    private static File resourcePath = file.getAbsoluteFile();

    public static Properties getGlobalPropertiesFile() {
        return PropertiesHandler.loadProperties(resourcePath + "\\" + globalPropertiesFile);
    }
}
