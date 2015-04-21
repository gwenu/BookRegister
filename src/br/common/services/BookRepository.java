package br.common.services;

import java.util.ArrayList;
import java.util.List;

import br.common.db.QueryBuilder;
import br.common.db.QueryExecutor;
import br.common.db.mappers.BookResultSetMapper;
import br.common.models.Book;
import br.common.models.Books;

public class BookRepository {
	
    private static final String TABLE_NAME = "Book";
    private static final String ALL = "*";
    
    private QueryExecutor<Book> queryExecutor;

    public BookRepository() {
    	BookResultSetMapper mapper = new BookResultSetMapper();
    	queryExecutor = new QueryExecutor<Book>(mapper);
    }

    public Books getAllBooks() {
        QueryBuilder query = new QueryBuilder.Builder().select(ALL).inTable(TABLE_NAME).build();
        List<Book> bookList = queryExecutor.execute(query);
        
        Books booksObj = new Books();
        booksObj.setBooksList(bookList);
        
        return booksObj;
    }

    public Book getBookById(Long id) {
        QueryBuilder query = new QueryBuilder.Builder().select(ALL).inTable(TABLE_NAME).where("id=" + id).build();
        List<Book> books = queryExecutor.execute(query);

        return books.isEmpty() ? new Book() : books.get(0);
    }

    public Book getBookByTitle(String title) {
    	QueryBuilder query = new QueryBuilder.Builder().select(ALL).inTable(TABLE_NAME).where("title=" + title).build();
    	List<Book> books = queryExecutor.execute(query);

    	return books.isEmpty() ? new Book() : books.get(0);
    }

    public Book getBookByIsbn(Long id) {
        return new Book();
    }


    public List<Book> getBookByAuthors() {
        return new ArrayList<Book>();
    }

    public List<Book> getBookByPublisher(String publisher) {
        return new ArrayList<Book>();
    }

    public List<Book> getBookByPublishYear(Integer year) {
        return new ArrayList<Book>();
    }
}
