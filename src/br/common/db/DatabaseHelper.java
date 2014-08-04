package br.common.db;

import br.common.models.Book;
import br.common.models.Books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static DatabaseHelper instance = new DatabaseHelper();
    private static DbConnection dbConnection = new DbConnection();

    private DatabaseHelper() {
    }

    public static DatabaseHelper getInstance() {
        return instance;
    }

    public Books execute(QueryBuilder queryBuilder) {
        Books books = null;
        ResultSet rs = null;
        try {
            Statement statement = dbConnection.open().createStatement();
            rs = statement.executeQuery(queryBuilder.getQueryString());
            books = formBookObjFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                dbConnection.close();
            } catch (SQLException se) {
            }
        }

        return books;
    }

    private Books formBookObjFromResultSet(ResultSet result) {
        Books books = new Books();
        List<Book> list = new ArrayList<Book>();

        try {
            while (result.next()) {
                Book book = new Book();
                book.setTitle(result.getString("title"));
                book.setPublishYear(result.getInt("publishYear"));
                book.setPublisher(result.getString("publisher"));
                book.setIsbn(result.getString("isbn"));

                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        books.setBooksList(list);
        return books;
    }
}