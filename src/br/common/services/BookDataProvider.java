package br.common.services;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.common.db.DatabaseHelper;
import br.common.db.QueryBuilder;
import br.common.models.Book;
import br.common.models.Books;
import br.common.utils.StreamUtil;
import br.common.utils.XmlWriter;

public class BookDataProvider {
    final Logger logger = Logger.getLogger(BookDataProvider.class.getName());

    public BookDataProvider() {

    }

    public String getAllBooks() {
        logger.debug("Inside getAllBooks");
        QueryBuilder query = new QueryBuilder.Builder().select("*").table("Book").build();
        Books booksObj = (Books) DatabaseHelper.getInstance().execute(query);

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
