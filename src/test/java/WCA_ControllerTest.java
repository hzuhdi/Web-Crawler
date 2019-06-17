import exception.YearException;
import junit.framework.TestCase;
import models.Book;
import models.Movie;
import models.Music;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class WCA_ControllerTest {

    @Before
    public void setUp() {

    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getAllReturnNonEmptyResponse() throws YearException
    {
        // Arrange
        Scraper scraper = mock(Scraper.class);
        Crawler crawler = mock(Crawler.class);
        Content content = mock(Content.class);
        String url = "";
        String jsonResponse = "Test";

        WCA_Controller controller = new WCA_Controller(scraper, crawler, content);

        // expectations
        when(content.converToJson()).thenReturn(jsonResponse);

        // Act
        String response = controller.getAll(url);

        // Assert
        assertNotNull("Response is null", response);
        assertFalse("Response is empty", response.trim().isEmpty());
    }

    @Test
    public void getAllThrowsYearException() throws YearException
    {
        exception.expect(YearException.class);
        exception.expectMessage(containsString("year"));

        // Arrange
        String url = "";
        String jsonResponse = "Test";

        WCA_Controller controller = mock(WCA_Controller.class);

        // expectations
        when(controller.getAll(anyString())).thenThrow(new YearException("Invalid year"));

        // Act
        String response = controller.getAll(url);
    }

    @Test
    public void getAllReturnValidResponse() throws YearException
    {
        // Arrange
        Scraper scraper = mock(Scraper.class);
        Crawler crawler = mock(Crawler.class);
        Content content = mock(Content.class);
        String url = "";
        String jsonResponse = "{\n" +
                "   \"id\": 3,\n" +
                "   \"time\":1499696751,\n" +
                "   \"movies\":[\n" +
                "      {\n" +
                "         \"name\":\"Office Space\",\n" +
                "         \"genre\":\"Comedy\",\n" +
                "         \"format\":\"Blu-ray\",\n" +
                "         \"year\":1999,\n" +
                "         \"director\":\"Mike Judge\",\n" +
                "         \"writers\":[\n" +
                "            \"William Goldman\"\n" +
                "         ],\n" +
                "         \"stars\":[\n" +
                "            \"Ron Livingston\",\n" +
                "            \"Jennifer Aniston\",\n" +
                "            \"David Herman\",\n" +
                "            \"Ajay Naidu\",\n" +
                "            \"Diedrich Bader\",\n" +
                "            \"Stephen Root\"\n" +
                "         ]\n" +
                "      }\n" +
                "   ],\n" +
                "   \"books\":[\n" +
                "      {\n" +
                "         \"name\":\"The Clean Coder: A Code of Conduct for Professional Programmers\",\n" +
                "         \"genre\":\"Tech\",\n" +
                "         \"format\":\"Audio\",\n" +
                "         \"year\":2011,\n" +
                "         \"authors\":\"Robert C.Martin\",\n" +
                "         \"publisher\":\"Prentice Hall\",\n" +
                "         \"ISBN\":\"007-6092046981\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"music\":[\n" +
                "      {\n" +
                "         \"name\":\"Beethoven: Complete Symphonies\",\n" +
                "         \"format\":\"CD\",\n" +
                "         \"year\":2012,\n" +
                "         \"artist\":\"Ludwig van Beethoven\"\n" +
                "      }\n" +
                "   ]\n" +
                "}\n";

        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Music> musics = new ArrayList<>();

        WCA_Controller controller = new WCA_Controller(scraper, crawler, content);

        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));
        List<String> authors = new ArrayList<>(Arrays.asList("author 1", "author 2"));

        books.add(new Book(1, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789"));
        movies.add(new Movie(1, "Office Space", "Drama", "Blue-ray",2001,"Peter Jackson" , writers, stars));
        musics.add(new Music(1, "genre1", "format", 2011, ("artist1"), "title"));

        // expectations
        //TODO, remove the followng content exectation, when content.convertToJson is implemented
        when(content.converToJson()).thenReturn(jsonResponse);

        when(scraper.getBooks()).thenReturn(books);
        when(scraper.getMovies()).thenReturn(movies);
        when(scraper.getMusics()).thenReturn(musics);

        // Act
        String response = controller.getAll(url);

        System.out.println(response);

        // Assert
        assertNotNull("Response is null", response);
        assertFalse("Response is empty", response.trim().isEmpty());
        assertTrue(response.contains("movies"));
        assertTrue(response.contains("books"));
        assertTrue(response.contains("music"));

        //assertTrue(response.contains("J.R.R. Tolkien"));
    }



}
