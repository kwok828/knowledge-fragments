package com.gzt.design._2Adapter.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties implements FileIO{
    private Properties properties;
    public FileProperties() {
        this.properties = new Properties();
    }
    @Override
    public void readFromFile(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
        }
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            properties.store(fos, "written by FileProperties");
        }
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key, "");
    }
}
