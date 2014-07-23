package br.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfig {
    private static final String CONFIG_PATH = "config.properties";
    private static SystemConfig instance = new SystemConfig();

    private SystemConfig() {
    }

    public static SystemConfig getInstance() {
        return instance;
    }

    public Properties getConfig() {
        return instance.getLoadedConfig();
    }

    private Properties getLoadedConfig() {
        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = getClass().getClassLoader().getResourceAsStream(CONFIG_PATH);

            if (input == null) {
                System.out.println("Can not load " + CONFIG_PATH);
                return null;
            }

            properties.load(input);

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }

        return properties;
    }
}
