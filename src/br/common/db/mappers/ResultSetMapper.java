package br.common.db.mappers;

import java.sql.ResultSet;
import java.util.List;

public interface ResultSetMapper<T> {
	public List<T> mapResultSetToObj(ResultSet resultSet);
}
