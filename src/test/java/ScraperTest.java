import models.Book;
import models.Movie;
import models.Music;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


import static org.mockito.Mockito.*;

public class ScraperTest {

    private String url;

    @Before
    public void setUp(){
        url = "http://example.com";
    }

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
    public void parseAllShouldReturnAListOfBooksMoviesAndMusics(){
        //Arrange
        Elements elements = new Elements();
        Document document = mock(Document.class);
        Scraper scraper = mock(Scraper.class);
        ArrayList<Music> musics = new ArrayList<Music>();
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        //Act
        //Document.getElementsByClass will be called within the parseAll method
        when(document.getElementsByClass("media-details")).thenReturn(elements);
        scraper.parseAll(url);
        movies = scraper.getMovies();
        books = scraper.getBooks();
        musics = scraper.getMusics();
        //Assert
        assertNotNull(movies);
        assertNotNull(books);
        assertNotNull(musics);

    }
}
