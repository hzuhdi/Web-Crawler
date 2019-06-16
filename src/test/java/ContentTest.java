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
}