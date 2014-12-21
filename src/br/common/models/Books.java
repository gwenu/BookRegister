package br.common.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "booksList")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books extends Model{
    @XmlElement(name = "book")
    private List<Book> booksList;

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public Book getFirstBook() {
        Book book = booksList.get(0);
        return  book;
    }
}
