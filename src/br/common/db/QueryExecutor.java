package br.common.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.common.db.mappers.ResultSetMapper;

public class QueryExecutor<T> {

	private static Logger logger = Logger.getLogger(QueryExecutor.class);
	private static DbConnection dbConnection = new DbConnection();

	private ResultSetMapper<T> mapper;

	public QueryExecutor(ResultSetMapper<T> mapper) {
		this.mapper = mapper;
	}

	public List<T> execute(QueryBuilder queryBuilder) {
		List<T> resultList = new ArrayList<T>();
		ResultSet resultSet = null;

		try {
			Statement statement = dbConnection.open().createStatement();
			resultSet = statement.executeQuery(queryBuilder.getQueryString());
			
			if(resultSet.next()) {
				resultList = mapper.mapResultSetToObj(resultSet);
			} else {
				logger.info("Result is not found.");
			}
		} catch (SQLException exception) {
			logger.info("SQLException exception occurred " + exception.getMessage());
		} finally {
			try {
				resultSet.close();
				dbConnection.close();
			} catch (SQLException exception) {
				logger.info("Problem with ResultSet.close() occurred: " + exception.getMessage());
			}
		}

		return resultList;
	}
}