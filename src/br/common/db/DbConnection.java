package br.common.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DbConnection {
	
	private static Logger logger = Logger.getLogger(DbConnection.class);
	private static final String ENVIRONMENT_CONTEXT_NAME = "java:/comp/env";
	private static final String DATA_SOURCE_CONTEXT_NAME = "jdbc/BookRegister";

	private Connection connection;
	private DataSource dataSource;
	
	public DbConnection() {
		initDataSource();
	}

	public Connection open() {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException sqlException) {
			logger.error("SQLException occurred on opening connection: " + sqlException);
		}

		logger.info("DbConnection is opened successfully.");

		return connection;
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqlException) {
				logger.error("SQLException occurred on closing connection: " + sqlException);
			}
		}
		
		logger.info("DbConnection is closed successfully.");
	}

	private void initDataSource() {
		try {
			Context envContext = new InitialContext();
			Context initContext = (Context) envContext.lookup(ENVIRONMENT_CONTEXT_NAME);
			this.dataSource = (DataSource) initContext.lookup(DATA_SOURCE_CONTEXT_NAME);
		} catch (NamingException namingException) {
			logger.error("Exception occurred when try to initialize DataSource: " + namingException);
		}
	}
}
