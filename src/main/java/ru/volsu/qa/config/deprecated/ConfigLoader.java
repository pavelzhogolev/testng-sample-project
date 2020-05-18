package ru.volsu.qa.config.deprecated;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Deprecated
public class ConfigLoader {

    private static Config config;

    public static Config getConfig() {
        if(config == null) {
            config = loadProperties();
        }

        return config;
    }

    public static Config loadProperties() {
        String rootPath = System.getProperty("user.dir");

        String configPropsPath = rootPath + "/src/main/resources/config.properties";

        Properties configProps = new Properties();
        try {
            configProps.load(new FileInputStream(configPropsPath));
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found at path: " + configPropsPath);
        }

        Config config = new Config();

        config.setBaseUrl(configProps.getProperty("baseUrl"));
        config.setBaseTimeout(Integer.parseInt(configProps.getProperty("baseTimeout")));

        return config;
    }
}
