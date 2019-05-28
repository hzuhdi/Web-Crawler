package models;

import exception.IDException;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String format;
    private int year;
    private List<String> authors;
    private String publisher;
    private String ISBN;


    /**
     *
     * @param id
     * @param title
     * @param genre
     * @param format
     * @param year
     * @param authors
     * @param publisher
     * @param ISBN
     */
    public Book(int id, String title, String genre, String format, int year, List<String> authors, String publisher, String ISBN) throws IDException {
        if(id > 0){
            this.id = id;
            this.title = title;
            this.genre = genre;
            this.format = format;
            this.year = year;
            this.authors = authors;
            this.publisher = publisher;
            this.ISBN = ISBN;
        } else {
            throw new IDException();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
