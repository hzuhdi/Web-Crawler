import exception.YearException;
import models.Book;
import models.Movie;
import models.Music;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class intends to scrap the html document to find specific information regarding user want to take a look for
 */

public class Scraper {

    public String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private Document document;
    private Element element;
    private Elements elements;

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();

    public Scraper() {
    }

    /**
     * @param id            will be get through a url
     * @param title         parse the title of html element object
     * @param category      parse the category of html element object
     * @param elementObject will be reference to the actual table in html
     */
    public void addToList(int id, String title, String category, Element elementObject) throws YearException {
        //All three objects have these three information
        String genre = getDetailsOfElementFromEachTag(elementObject, "Genre");
        String format = getDetailsOfElementFromEachTag(elementObject, "Format");
        String year = getDetailsOfElementFromEachTag(elementObject, "Year");
        int yearInt = Integer.parseInt(year);

        if (category.equalsIgnoreCase("Books")) {
            ArrayList<String> authors = new ArrayList<>();
            authors = getDetailsWithinAList(elementObject, "Authors");
            String publisher = getDetailsOfElementFromEachTag(elementObject, "Publisher");
            String isbn = getDetailsOfElementFromEachTag(elementObject, "ISBN");
            Book book = new Book(id, title, genre, format, yearInt, authors, publisher, isbn);
            books.add(book);
        } else if (category.equalsIgnoreCase("Music")) {
            String artist = getDetailsOfElementFromEachTag(elementObject, "Artist");
            Music music = new Music(id, genre, format, yearInt, artist, title);
            musics.add(music);
        } else if (category.equalsIgnoreCase("Movies")) {
            String director = getDetailsOfElementFromEachTag(elementObject, "Director");
            ArrayList<String> writers = getDetailsWithinAList(elementObject, "Writers");
            ArrayList<String> stars = getDetailsWithinAList(elementObject, "Stars");
            Movie movie = new Movie(id, title, genre, format, yearInt, director, writers, stars);
            movies.add(movie);
        }
    }

    public ArrayList<String> getDetailsWithinAList(Element myElement, String details) {
        //Case Sensitive
        ArrayList<String> detailList = new ArrayList<>();
        detailList.add(myElement.select("tr:contains(" + details + ")").get(0).toString());
        return detailList;
    }

    public String getDetailsOfElementFromEachTag(Element myElement, String details) {
        //It has CSS Query feature where we can easily select the tag we want to highlight
        //Case sensitive
        Element elementTag = myElement.select("tr:contains(" + details + ")").get(0);
        String contentTag = elementTag.select("td").get(0).text();
        return contentTag;
    }

    public void parseAll(String url) throws YearException, IOException {
        Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
        Document htmlDocument = connection.get();
        this.document = htmlDocument;
        if (connection.response().statusCode() == 200) {
            System.out.println("\n**Visiting** Received web page at " + url);
        }
        Elements media = document.getElementsByClass("media-details");
        this.elements = media;
        for (Element htmlElement : elements) {
            //All of this can be found on the target website
            Element categoryElement = htmlElement.select("tr:contains(category)").get(0);
            String category = categoryElement.select("td").get(0).text();
            String title = htmlElement.select("h1").get(0).text();
            int id = getIdFromUrl(url);
            addToList(id, title, category, htmlElement);
            /**
             * TO DO: Create a getter from url to get an id : https://stackoverflow.com/questions/45539506/how-to-extract-id-from-url-google-sheet
             */
        }

    }

    public int getIdFromUrl(String url) {
        //Normal Url : http://localhost/sample_site_to_crawl/details.php?id=102
        String[] parts = url.split("id=");
        //System.out.println(parts[1]);
        int id = Integer.parseInt(parts[1]);
        return id;
    }

    public boolean parseSpecific(String url, String keyword) throws IOException {
        Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
        Document htmlDocument = connection.get();
        if (htmlDocument == null) {
            System.out.println("ERROR! The HTML document is not received");
            return false;
        }
        this.document = htmlDocument;
        String bodyText = this.document.body().text();
        return bodyText.toLowerCase().contains(keyword.toLowerCase());

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

    public ArrayList<Music> getMusics() {
        return this.musics;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<Movie> getMovies() {
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
