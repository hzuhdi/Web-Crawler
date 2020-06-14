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
    private Elements elements;

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();

    public Scraper() {
    }

    /**
     *
     * @param url of the web we are currently in
     * @param keyword word that we want to looking for
     * @return
     * @throws IOException
     * @throws YearException
     */
    public Object parseSpecific(String url, String keyword) throws IOException, YearException {
        Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
        Document htmlDocument = connection.get();
        Object obj = null;
        if (htmlDocument == null || htmlDocument.equals(null)) {
            System.out.println("ERROR! The HTML document is not received");
            throw new NullPointerException();
        }

        String cat = "";
        this.document = htmlDocument;
        String bodyText = this.document.body().text();
        //String tit = "";
        Elements media = document.getElementsByClass("media-details");
        for (Element htmlElement : media) {
            Element categoryElement = htmlElement.select("tr:contains(category)").get(0);
            String category = categoryElement.select("td").get(0).text();
            int id = getIdFromUrl(url);
            cat = category;
            String title = htmlElement.select("h1").get(0).text();
            if(title.contains(keyword)){
                addToList(id, title, category, htmlElement);
                if (cat.equalsIgnoreCase("Books")) {
                    obj = getBooks().get(0);
                } else if (cat.equalsIgnoreCase("Music")) {
                    obj = getMusics().get(0);
                } else if (cat.equalsIgnoreCase("Movies")) {
                    obj = getMovies().get(0);
                }
            } else {
                obj = null;
            }
        }
        return obj;

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

    /**
     *
     * @param myElement each element tag that related with a list
     * @param details what kind of tag
     * @return
     */
    public ArrayList<String> getDetailsWithinAList(Element myElement, String details) {
        //Case Sensitive
        ArrayList<String> detailList = new ArrayList<>();
        detailList.add(myElement.select("tr:contains(" + details + ")").get(0).toString());
        return detailList;
    }

    /**
     *
     * @param myElement each element common tags
     * @param details what kind of tag
     * @return
     */

    public String getDetailsOfElementFromEachTag(Element myElement, String details) {
        //It has CSS Query feature where we can easily select the tag we want to highlight
        //Case sensitive
        Element elementTag = myElement.select("tr:contains(" + details + ")").get(0);
        String contentTag = elementTag.select("td").get(0).text();
        return contentTag;
    }

    /**
     *
     * @param url base url
     * @throws YearException
     * @throws IOException
     */
    public void parseAll(String url) throws YearException, IOException {
        if (url != null || url != "") {
            //TODO
            //Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Connection connection = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1");
            Document htmlDocument = connection.get();
            this.document = htmlDocument;
            if (connection.response().statusCode() == 200) {
                Elements media = document.getElementsByClass("media-details");
                this.elements = media;
                for (Element htmlElement : elements) {
                    //All of this can be found on the target website
                    Element categoryElement = htmlElement.select("tr:contains(category)").get(0);
                    String category = categoryElement.select("td").get(0).text();
                    String title = htmlElement.select("h1").get(0).text();
                    int id = getIdFromUrl(url);
                    addToList(id, title, category, htmlElement);
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    /**
     *
     * @param url
     * @return the split of id
     */
    public int getIdFromUrl(String url) {
        //Normal Url : http://localhost/sample_site_to_crawl/details.php?id=102
        String[] parts = url.split("id=");
        //System.out.println(parts[1]);
        int id = Integer.parseInt(parts[1]);
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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
