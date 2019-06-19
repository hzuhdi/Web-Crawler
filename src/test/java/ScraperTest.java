import exception.YearException;
import models.Book;
import models.Movie;
import models.Music;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.io.IOException;
import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;


import static org.mockito.Mockito.*;

public class ScraperTest {

    private String url, book_url, movie_url, music_url, invalid_url;
    private ArrayList<String> authors = new ArrayList<>();

    public ScraperTest() throws IOException {
    }

    @Before
    public void setUp(){
        url = "http://example.com";
        book_url = "http://localhost/sample_site_to_crawl/details.php?id=102";
        music_url = "http://localhost/sample_site_to_crawl/details.php?id=301";
        movie_url = "http://localhost/sample_site_to_crawl/details.php?id=201";
        invalid_url = "http://halo";
        String author1 = "James Bensen";
        authors.add(author1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseAllShouldThrowAnExceptioOEmptyUrl() throws YearException, IOException {
        Scraper scraper = new Scraper();
        scraper.parseAll("");
    }

    /**
     * verify the call of parseAll
     * @throws YearException
     */
    @Test(expected = IOException.class)
    public void parseAllShouldThrownAnException_WhenHandlingInvalidURL() throws YearException, IOException {
        //Arrange
        Scraper scraper = new Scraper();
        //Act
        scraper.parseAll(invalid_url);
    }

    /**
     * to check whether the book is scraped or not
     * @throws YearException
     */
    @Test
    public void parseAllShouldReturnAListOfBooks() throws YearException, IOException {
        //Arrange
        Elements elements = new Elements();
        Document document = mock(Document.class);
        Scraper scraper = new Scraper();
        ArrayList<Book> books = new ArrayList<Book>();
        //Act
        //Document.getElementsByClass will be called within the parseAll method
        when(document.getElementsByClass("media-details")).thenReturn(elements);
        scraper.setDocument(document);
        scraper.parseAll(book_url);
        books = scraper.getBooks();
        //Assert
        assertEquals(1, books.size());
    }

    /**
     * to check whether the movie is scraped or not
     * @throws YearException
     */
    @Test
    public void parseAllShouldReturnAListOfMovies() throws YearException, IOException {
        //Arrange
        Elements elements = new Elements();
        Document document = mock(Document.class);
        Scraper scraper = new Scraper();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        //Act
        //Document.getElementsByClass will be called within the parseAll method
        when(document.getElementsByClass("media-details")).thenReturn(elements);
        scraper.setDocument(document);
        scraper.parseAll(movie_url);
        movies = scraper.getMovies();
        //Assert
        assertEquals(1, movies.size());
    }

    /**
     * to check whether the music is scraped or not
     * @throws YearException
     */
    @Test
    public void parseAllShouldReturnAListOfMusics() throws YearException, IOException {
        //Arrange
        Elements elements = new Elements();
        Document document = mock(Document.class);
        Scraper scraper = new Scraper();
        ArrayList<Music> musics = new ArrayList<Music>();
        //Act
        //Document.getElementsByClass will be called within the parseAll method
        when(document.getElementsByClass("media-details")).thenReturn(elements);
        scraper.setDocument(document);
        scraper.parseAll(music_url);
        musics = scraper.getMusics();
        //Assert
        assertEquals(1, musics.size());
    }

    /**
     * parse specific will return true if found any character the user want to search for
     * Doesn't applied: If it's applied to travis-ci the build is always broken, since the target website is in local
     * @throws IOException
     */
    @Test
    public void parseSpecificShouldReturnTrue() throws IOException {
        Scraper scraper = new Scraper();
        //boolean result = scraper.parseSpecific(book_url, "978-0132350884");
        //assertEquals(true, result);

    }

    /**
     * to check whether the url given is valid url or not
     * @throws IOException is expected
     */
    @Test(expected = IOException.class)
    public void parseSpecificShouldThrownAnExceptionOfInvalidUrl() throws IOException {
        Scraper scraper = new Scraper();
        String notValidUrl = "http://invalid";
        //boolean result = scraper.parseSpecific(notValidUrl, "978-0132350884");
        //assertEquals(true, result);
    }

    /**
     * Id should be returned and splitted from an url
     * @throws IOException
     */
    @Test
    public void idShouldbeReturnedFromURL() throws IOException {
        Scraper scraper = new Scraper();
        int id = scraper.getIdFromUrl(book_url);
        assertEquals(102, id);
    }

    /**
     * the scraper should return the expected elements (media-details)
     */
    @Test
    public void shouldGiveTheExpectedElements(){
        //Arrange
        Document document = mock(Document.class);
        Elements elements = mock(Elements.class);
        Scraper scraper = new Scraper();
        //Act
        //The document will take only a search on the class div of media-details
        when(document.getElementsByClass("media-details")).thenReturn(elements);
        scraper.setElements(document.getElementsByClass("media-details"));
        //Assert
        assertEquals(elements, scraper.getElements());
    }


    @Test
    public void shouldAddAListToBooks() throws YearException {
        //Arrange
        Scraper scraper = mock(Scraper.class);
        Element element = mock(Element.class);
        //  Attributes for making the book
        int id = 1;
        String title = "Alice in wonderland";
        String category = "Book";
        Element contentElement = mock(Element.class);
        String attributeFormat = "Ebook";
        String attributeGenre = "Tech";
        int year = 2013;
        String yearString = Integer.toString(year);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Jimmy Bensen");
        String attributeIsbn = "ISBN12345";
        String attributePublisher = "Gramedia Publisher";

        //Act
        //During the scraping, there are some information will be drilled
        //1. ID 2. Titlte 3. Category 4. Content (Details of the object)
        //It can be viewed from our web target
        when(scraper.getDetailsOfElementFromEachTag(element, "Year")).thenReturn(yearString);
        when(scraper.getDetailsOfElementFromEachTag(element, "Format")).thenReturn(attributeFormat);
        when(scraper.getDetailsOfElementFromEachTag(element, "Genre")).thenReturn(attributeGenre);
        when(scraper.getDetailsOfElementFromEachTag(element, "Year")).thenReturn(yearString);
        when(scraper.getDetailsOfElementFromEachTag(element, "ISBN")).thenReturn(attributeIsbn);
        when(scraper.getDetailsOfElementFromEachTag(element, "Publisher")).thenReturn(attributePublisher);
        when(scraper.getDetailsWithinAList(element, "Authors")).thenReturn(authors);
        doCallRealMethod().when(scraper).addToList(id, title, category, element);
        scraper.addToList(id, title, category, element);
        //Assert
        verify(scraper, times(1)).addToList(id, title, category, element);
    }


    @Test
    public void shouldAddAListToTheMusics() throws YearException {
        //Arrange
        Scraper scraper = mock(Scraper.class);
        Element element = mock(Element.class);
        ArrayList<Music> musics = new ArrayList<>();
        //Act
        when(scraper.getDetailsOfElementFromEachTag(element, "Year")).thenReturn("2015");
        when(scraper.getDetailsOfElementFromEachTag(element, "Genre")).thenReturn("Rock");
        when(scraper.getDetailsOfElementFromEachTag(element, "Format")).thenReturn("Vinyl");
        when(scraper.getDetailsOfElementFromEachTag(element, "Artist")).thenReturn("Elvis Presley");
        //PartialMocking
        doCallRealMethod().when(scraper).setMusics(musics);
        doCallRealMethod().when(scraper).addToList(302, "Elvis Forever", "Music", element);
        scraper.setMusics(musics);
        scraper.addToList(302, "Elvis Forever", "Music", element);
        //Assert
        verify(scraper, times(1)).addToList(302, "Elvis Forever", "Music", element);
    }

}
