package org.skillbrain.web.utils;

import org.skillbrain.web.structuredScripting.AlertTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationUtils.class);

    public static Properties getProperties() {
        Properties properties = new Properties();
        String fileLocation = System.getProperty("user.dir") + "/src/test/resources/testConfig.properties";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocation))){
            properties.load(reader);
        } catch (IOException e) {
            LOGGER.error("There was an error when trying to read the testConfig properties file!");
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Couldn't load the testConfig.properties file");
        }
        return properties;
    }
}
