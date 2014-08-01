package br.common.db;

import br.common.models.Book;
import br.common.models.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String dbDriver = DbConfig.DB_DRIVER;
    private String dbUrl = DbConfig.DB_URL;
    private String username = DbConfig.DB_USERNAME;
    private String password = DbConfig.DB_PASSWORD;
    private Connection connection = null;

    private static Database instance = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    public Books executeQuery(QueryBuilder queryBuilder) {
        Books books = null;
        ResultSet rs = null;
        try {
            Statement statement = getConnection().createStatement();
            rs = statement.executeQuery(queryBuilder.getQueryString());
            books = formBookObjFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                closeConnection();
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

    private Connection getConnection() {
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Connection opened!");

        return connection;
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Connection closed!");
    }
}