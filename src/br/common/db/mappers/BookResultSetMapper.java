package br.common.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.common.models.Book;

public class BookResultSetMapper implements ResultSetMapper<Book> {
	
	private static Logger logger = Logger.getLogger(BookResultSetMapper.class);
	
	private static final String TITLE = "title";
	private static final String PUBLISH_YEAR = "publishYear";
	private static final String PUBLISHER = "publisher";
	private static final String ISBN = "isbn";

	
	@Override
	public List<Book> mapResultSetToObj(ResultSet resultSet) {
        List<Book> resultList = new ArrayList<Book>();

        try {
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString(TITLE));
                book.setPublishYear(resultSet.getInt(PUBLISH_YEAR));
                book.setPublisher(resultSet.getString(PUBLISHER));
                book.setIsbn(resultSet.getString(ISBN));

                resultList.add(book);
            }
        } catch (SQLException exception) {
            logger.info("SQLException exception occurred in mapResultSetToObj(ResultSet resultSet): " + exception.getMessage());
        }

		return resultList;
	}

}
