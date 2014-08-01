package br.common.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "book")
public class Book extends Model {
    private String title;
    private List<Author> authors;
    private Integer publishYear;
    private String publisher;
    private String isbn;

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @XmlElement
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    @XmlElement
    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublisher() {
        return publisher;
    }

    @XmlElement
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    @XmlElement
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
