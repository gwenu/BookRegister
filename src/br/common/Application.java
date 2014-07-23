package br.common;

import br.common.db.Database;
import br.common.db.DbConfig;

public class Application {
     public static void main(String[] args) {
         Database db = new Database(DbConfig.DB_DRIVER, DbConfig.DB_URL, DbConfig.DB_USERNAME, DbConfig.DB_PASSWORD);
         db.getConnection();
         db.closeConnection();
     }
}
