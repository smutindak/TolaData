package com.toladata.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_DIRECTORY = "src" + File.separator + "main" + File.separator + "resources";
    private final Properties configData;

    public ConfigLoader(String configDataFileName) {
        configData = new Properties();
        try {
            String testDataFilePath = CONFIG_DIRECTORY + File.separator + configDataFileName;
            FileInputStream inputStream = new FileInputStream(testDataFilePath);
            configData.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return configData.getProperty(key);
    }
}

