package br.common.db;

import br.common.SystemConfig;

import java.util.Properties;

public class DbConfig {
    private static Properties properties = SystemConfig.getInstance().getConfig();

    public static final String DB_DRIVER = properties.getProperty("db.driver");
    public static final String DB_URL = properties.getProperty("db.url");

    public static final String DB_USERNAME = properties.getProperty("db.user");
    public static final String DB_PASSWORD = properties.getProperty("db.password");
}