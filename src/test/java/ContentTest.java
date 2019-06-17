import com.google.gson.Gson;
import exception.AllowedWritersNumberExceededException;
import exception.AttributeNotPresentedException;
import exception.MovieYearShouldBeLessThanOrEqualCurrentYearException;
import exception.YearException;
import models.Book;
import models.Movie;
import models.Music;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContentTest {
    @Test(expected = YearException.class)
    public void YearOfBookNotAfterTodayDate() throws YearException {
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() + 1, Arrays.asList("author1"), "pib", "isbn");
    }

    @Test(expected = YearException.class)
    public void YearOfMusicNotAfterTodayDate() throws YearException {
        Music music = new Music(12, "genre", "format", LocalDate.now().getYear() + 1, "artist", "title");
    }
    @Test(expected = MovieYearShouldBeLessThanOrEqualCurrentYearException.class)
    public void YearOfMovieNotAfterTodayDate() throws YearException, MovieYearShouldBeLessThanOrEqualCurrentYearException, AllowedWritersNumberExceededException, AttributeNotPresentedException {
        Movie movie = new Movie(3, "title", "genre", "format", LocalDate.now().getYear() + 1, "director", Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void MovieListCanBeNull() {
        Content content = new Content(null, null, null);
        Assert.assertNull(content.getBooks());
        Assert.assertNull(content.getMovies());
        Assert.assertNull(content.getMusics());
    }
    @Test
    public void shouldGetTheArrayOfMovies() throws MovieYearShouldBeLessThanOrEqualCurrentYearException, AllowedWritersNumberExceededException, AttributeNotPresentedException {
        Content content = new Content(null, null, null);
        Assert.assertNull(content.getMovies());
        Movie movie = new Movie(3, "title", "genre", "format", LocalDate.now().getYear() - 1, "director", Collections.emptyList(), Collections.emptyList());
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        content.setMovies((ArrayList<Movie>) movies);
        Assert.assertNotNull(content.getMovies());
        Assert.assertEquals(content.getMovies().size(), 1);
    }

    @Test
    public void shouldGetTheArrayOfBooks() throws YearException {
        Content content = new Content(null, null, null);
        Assert.assertNull(content.getBooks());
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() - 1, Arrays.asList("author1"), "pib", "isbn");
        List<Book> books = new ArrayList<>();
        books.add(book);
        content.setBooks((ArrayList<Book>) books);
        Assert.assertNotNull(content.getBooks());
        Assert.assertEquals(content.getBooks().size(), 1);
    }
    @Test
    public void shouldGetTheArrayOfMusics() throws YearException {
        Content content = new Content(null, null, null);
        Assert.assertNull(content.getMusics());
        Music music = new Music(12, "genre", "format", LocalDate.now().getYear() - 1, "artist", "title");
        List<Music> musics = new ArrayList<>();
        musics.add(music);
        content.setMusics((ArrayList<Music>) musics);
        Assert.assertNotNull(content.getMusics());
        Assert.assertEquals(content.getMusics().size(), 1);
    }

    @Test
    public void shouldGetTheJSON() throws YearException, MovieYearShouldBeLessThanOrEqualCurrentYearException, AllowedWritersNumberExceededException, AttributeNotPresentedException {
        Content content = new Content(null, null, null);
        Movie movie = new Movie(3, "title", "genre", "format", LocalDate.now().getYear() - 1, "director", Collections.emptyList(), Collections.emptyList());
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        content.setMovies((ArrayList<Movie>) movies);
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() - 1, Arrays.asList("author1"), "pib", "isbn");
        List<Book> books = new ArrayList<>();
        books.add(book);
        content.setBooks((ArrayList<Book>) books);
        Music music = new Music(12, "genre", "format", LocalDate.now().getYear() - 1, "artist", "title");
        List<Music> musics = new ArrayList<>();
        musics.add(music);
        content.setMusics((ArrayList<Music>) musics);
        Gson gson = new Gson();
        String json = content.converToJson();
        Content resultingContent = gson.fromJson(json, Content.class);
        Assert.assertEquals(content.getBooks().size(), resultingContent.getBooks().size());
        Assert.assertEquals(content.getMovies().size(), resultingContent.getMovies().size());
        Assert.assertEquals(content.getMusics().size(), resultingContent.getMusics().size());
    }
    @Test(expected = NullPointerException.class)
    public void shouldAddBookToList_Fail() throws YearException {
        Content content = new Content(null, null, null);
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() - 1, Arrays.asList("author1"), "pib", "isbn");
        content.addToListBook(book);
    }
    @Test(expected = NullPointerException.class)
    public void shouldAddMovieToList_Fail() throws MovieYearShouldBeLessThanOrEqualCurrentYearException, AllowedWritersNumberExceededException, AttributeNotPresentedException {
        Content content = new Content(null, null, null);
        Movie movie = new Movie(3, "title", "genre", "format", LocalDate.now().getYear() - 1, "director", Collections.emptyList(), Collections.emptyList());
        content.addToListMovie(movie);
    }

    @Test(expected = NullPointerException.class)
    public void shouldAddMusicToList_Fail() throws YearException {
        Content content = new Content(null, null, null);
        Music music = new Music(12, "genre", "format", LocalDate.now().getYear() - 1, "artist", "title");
        content.addToListMusic(music);
    }
    @Test
    public void shouldAddBookToList_Pass() throws YearException {
        Content content = new Content(null, null, null);
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() - 1, Arrays.asList("author1"), "pib", "isbn");
        List<Book> books = new ArrayList<>();
        books.add(book);
        content.setBooks((ArrayList<Book>) books);

        Book bookToAdd = new Book(3, "title", "genre", "formqt", LocalDate.now().getYear() - 1, Arrays.asList("author1"), "pib", "isbn");

        content.addToListBook(bookToAdd);
        Assert.assertEquals(content.getBooks().size() , 2);
        Assert.assertEquals(content.getBooks().get(1) , bookToAdd);
    }
    @Test
    public void shouldAddMusicToList_Pass() throws YearException {
        Content content = new Content(null, null, null);
        Music music = new Music(12, "genre", "format", LocalDate.now().getYear() - 1, "artist", "title");
        List<Music> musics = new ArrayList<>();
        musics.add(music);
        content.setMusics((ArrayList<Music>) musics);

        Music musicToAdd = new Music(13, "genre", "format", LocalDate.now().getYear() - 1, "artist", "title");

        content.addToListMusic(musicToAdd);
        Assert.assertEquals(content.getMusics().size() , 2);
        Assert.assertEquals(content.getMusics().get(1) , musicToAdd);
    }
}