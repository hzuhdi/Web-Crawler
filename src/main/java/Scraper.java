import models.Book;
import models.Movie;
import models.Music;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Scraper {

    private String USER_AGENT;
    private Document document;
    private Element element;
    private Elements elements;
    private String search;

    private ArrayList<Movie> movies;
    private ArrayList<Book> books;
    private ArrayList<Music> musics;

    public Scraper() {
    }

    public void addToList(){
    }

    public void parseAll(String url){

    }

    public boolean parseSpecific(String url, String keyword){
        return false;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    public ArrayList<Music> getMusics(){
        return this.musics;
    }

    public ArrayList<Book> getBooks(){
        return this.books;
    }

    public ArrayList<Movie> getMovies(){
        return this.movies;
    }
}
