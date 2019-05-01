package com.tsb.automation.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

/**
 * @author thenna
 * This class lists the properties and global methods used in this project
 */
public class GlobalHelper {
    private static String globalPropertiesFile = "autotest.properties";
    private static String log4jPropertiesFile = "log4j.properties";

    private static File file = new File(Constants.RESOURCES_PATH);
    private static File resourcePath = file.getAbsoluteFile();

    public static Properties getGlobalPropertiesFile() {
        Log.log.info("Entering method getGlobalPropertiesFile to load properties");
        return PropertiesHandler.loadProperties(resourcePath + "\\" + globalPropertiesFile);
    }

    /**
     * This method returns current CST date
     * @return
     */
    public static String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //Converting to CST timezone
        sdf.setTimeZone(TimeZone.getTimeZone("CST"));

        return sdf.format(calendar.getTime());
    }
}
