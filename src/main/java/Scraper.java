import exception.YearException;
import models.Book;
import models.Movie;
import models.Music;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * This class intends to scrap the html document to find specific information regarding user want to take a look for
 */

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

    /**
     *
     * @param id
     * @param title parse the title of html element object
     * @param category parse the category of html element object
     * @param elementObject will be reference to the actual table in html
     */
    public void addToList(int id, String title, String category, Element elementObject) throws YearException {
        //All three objects have these three information
        String genre = getDetailsOfElementFromEachTag(elementObject, "genre");
        String format = getDetailsOfElementFromEachTag(elementObject, "format");
        int year = Integer.parseInt(getDetailsOfElementFromEachTag(elementObject, "year"));

        if(category.equalsIgnoreCase("Book")){
            ArrayList<String> authors = new ArrayList<>();
            String publisher = getDetailsOfElementFromEachTag(elementObject, "publisher");
            String isbn = getDetailsOfElementFromEachTag(elementObject, "ISBN");
            Book book = new Book(id, title, genre, format, year, authors, publisher, isbn);
            books.add(book);
        } else if(category.equalsIgnoreCase("Music")){

        } else if(category.equalsIgnoreCase("Movie")){

        }
    }

    public String getDetailsOfElementFromEachTag(Element myElement, String details){
        //It has CSS Query feature where we can easily select the tag we want to highlight
        //Case sensitive
        String cont = myElement.select("tr:contains(" + details+")").get(0).toString();
        return cont;
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
