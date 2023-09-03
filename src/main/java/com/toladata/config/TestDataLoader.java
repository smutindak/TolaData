package com.toladata.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataLoader {
    private static final String TEST_DATA_DIRECTORY = "src" + File.separator + "test" + File.separator + "resources";
    private final Properties configData;

    public TestDataLoader(String configDataFileName) {
        configData = new Properties();
        try {
            String testDataFilePath = TEST_DATA_DIRECTORY + File.separator + configDataFileName;
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

