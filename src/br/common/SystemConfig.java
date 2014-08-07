package br.common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfig {
    final Logger logger = Logger.getLogger(SystemConfig.class.getName());

    private static final String CONFIG_PATH = "config.properties";
    private static final String LOG4J_PATH = "log4j.properties";

    private static SystemConfig instance = new SystemConfig();

    private Properties properties = new Properties();

    private SystemConfig() {
        loadConfig(properties);
        configureLogging();
    }

    public static SystemConfig getInstance() {
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    private void loadConfig(Properties properties) {
        InputStream input = null;
        logger.debug("Inside load properties!");

        try {
            input = getClass().getClassLoader().getResourceAsStream(CONFIG_PATH);

            if (input == null) {
                logger.error("Cannot load " + CONFIG_PATH);
            }

            properties.load(input);

        } catch (Exception exception) {
            logger.error("Error occurred on inputStream creation: \n" + exception.getStackTrace());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException exception) {
                   logger.error("Error occurred on inputStream closing: \n" + exception.getStackTrace());
                }
            }
        }
    }

    private void configureLogging() {
        PropertyConfigurator.configure(LOG4J_PATH);
    }
}
