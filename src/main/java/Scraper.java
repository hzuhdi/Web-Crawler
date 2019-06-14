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

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();
    ArrayList<String> halo = new ArrayList<>();

    public Scraper() {
    }

    /**
     *
     * @param id will be get through a url
     * @param title parse the title of html element object
     * @param category parse the category of html element object
     * @param elementObject will be reference to the actual table in html
     */
    public void addToList(int id, String title, String category, Element elementObject) throws YearException {
        //All three objects have these three information
        String genre = getDetailsOfElementFromEachTag(elementObject, "Genre");
        String format = getDetailsOfElementFromEachTag(elementObject, "Format");
        String year = getDetailsOfElementFromEachTag(elementObject, "Year");
        int yearBook = Integer.parseInt(year);

        if(category.equalsIgnoreCase("Book")){
            ArrayList<String> authors = new ArrayList<>();
            authors = getDetailsWithinAList(elementObject, "Authors");
            String publisher = getDetailsOfElementFromEachTag(elementObject, "Publisher");
            String isbn = getDetailsOfElementFromEachTag(elementObject, "ISBN");
            Book book = new Book(id, title, genre, format, yearBook, authors, publisher, isbn);
            System.out.println(book.getId());
            System.out.println(book.getTitle());
            System.out.println(book.getAuthors().size());
            System.out.println(book.getYear());
            books.add(book);
            System.out.println(books.size());
        } else if(category.equalsIgnoreCase("Music")){

        } else if(category.equalsIgnoreCase("Movie")){

        }
    }

    public ArrayList<String> getDetailsWithinAList(Element myElement, String details){
        //Case Sensitive
        ArrayList<String> detailList = new ArrayList<>();
        detailList.add(myElement.select("tr:contains("+details+")").get(0).toString());
        return detailList;
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

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }
}
