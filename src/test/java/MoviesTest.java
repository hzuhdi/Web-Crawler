
import exception.AllowedWritersNumberExceededException;
import exception.AttributeNotPresentedException;
import models.Movie;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoviesTest {

    private Movie movie;

    @Before
    public void setUp() {

    }

    @Test
    public void initializeMovieWithAllAttributesProvided() {
        // Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id,title, genre, format, year, director, writers, stars);

        // Assert
        assertThat(movie.getId(), equalTo(id));
        assertThat(movie.getTitle(), equalTo(title));
        assertThat(movie.getGenre(), equalTo(genre));
        assertThat(movie.getFormat(), equalTo(format));
        assertThat(movie.getYear(), equalTo(year));
        assertThat(movie.getDirector(), equalTo(director));
        assertThat(movie.getWriters().get(0), equalTo(writers.get(0)));
        assertThat(movie.getStars().get(1), equalTo(stars.get(1)));
    }

    @Test(expected = AttributeNotPresentedException.class)
    public void initializeMovieWithAllAttributesMissing() {
        // Arrange
        int id = 0;
        String title = null;
        String category = "Movies";
        String genre = null;
        String format = null;
        int year = 0;
        String director = null;
        List<String> writers = null;
        List<String> stars = null;

        // Act
        movie = new Movie(id,title, genre, format, year, director, writers, stars);
    }

    // Id should be bigger than zero
    @Test
    public void IdShouldBeBiggerThanZero_MovieObjectInitializedSuccessfully() {
        // Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id,title, genre, format, year, director, writers, stars);

        //Assert
        assertNotNull(movie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void IdLessThanOrEqualToZero_MovieObjectInitializationFail() {
        //Arrange
        String title = "Office Space";
        int id = 0;
        //Act
        movie = new Movie(id, title, null, null, 0, null,null,null);
        //Assert
    }

    @Test(expected = AllowedWritersNumberExceededException.class)
    public void SixWriters_MovieObjectInitializationFail() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens","Noah","Tamer","Yousuf"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id,title, genre, format, year, director, writers, stars);
    }

    @Test
    public void fiveWriters_MovieObjectInitializationPassed() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens","Noah","Tamer"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id,title, genre, format, year, director, writers, stars);

        // Assert
        assertThat(movie.getId(), equalTo(id));
        assertThat(movie.getTitle(), equalTo(title));
        assertThat(movie.getGenre(), equalTo(genre));
        assertThat(movie.getFormat(), equalTo(format));
        assertThat(movie.getYear(), equalTo(year));
        assertThat(movie.getDirector(), equalTo(director));
        assertThat(movie.getWriters().size(), equalTo(5));
        assertThat(movie.getStars().get(1), equalTo(stars.get(1)));
    }

    @Test
    public void fourStars_MovieObjectInitializationPassed() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens","Noah","Tamer"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id,title, genre, format, year, director, writers, stars);

        // Assert
        assertThat(movie.getId(), equalTo(id));
        assertThat(movie.getTitle(), equalTo(title));
        assertThat(movie.getGenre(), equalTo(genre));
        assertThat(movie.getFormat(), equalTo(format));
        assertThat(movie.getYear(), equalTo(year));
        assertThat(movie.getDirector(), equalTo(director));
        assertThat(movie.getWriters().size(), equalTo(5));
        assertThat(movie.getStars().size(), equalTo(4));
    }


}
