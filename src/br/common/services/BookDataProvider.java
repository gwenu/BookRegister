package br.common.services;

import br.common.db.Database;
import br.common.db.DbConfig;
import br.common.db.QueryBuilder;
import br.common.db.QueryExecutor;
import br.common.models.Book;
import br.common.models.Books;
import br.common.utils.StreamUtil;
import br.common.utils.XmlWriter;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookDataProvider {

    public BookDataProvider() {

    }

    public String getAllBooks() {
        QueryBuilder query = new QueryBuilder.Builder().select("*").table("Book").build();
        Books booksObj = (Books) new QueryExecutor().execute(query);

        OutputStream os = new XmlWriter<Books>(booksObj).writeToXml();
        String responseXml = StreamUtil.convertStreamToString(os);
        return responseXml;
    }

    public Book getBookById(Long id) {


        return new Book();
    }

    public Book getBookByTitle(String title) {
        return new Book();
    }

    public Book getBookByIs(Long id) {
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
