
import exception.*;
import models.Movie;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        movie = new Movie(id, title, genre, format, year, director, writers, stars);

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
        movie = new Movie(id, title, genre, format, year, director, writers, stars);
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
        movie = new Movie(id, title, genre, format, year, director, writers, stars);

        //Assert
        assertNotNull(movie);
    }

    @Test(expected = AttributeNotPresentedException.class)
    public void IdLessThanOrEqualToZero_MovieObjectInitializationFail() {
        // Arrange
        int id = -2;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);
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
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens", "Noah", "Tamer", "Yousuf"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);
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
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens", "Noah", "Tamer"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);

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
        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens", "Noah", "Tamer"));
        List<String> stars = new ArrayList<>(Arrays.asList("Ron Livingston", "Jennifer Aniston", "Ali", "Ahmed"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);

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

    // --------------------------------- Star ---------------------------------------------------------
    @Test
    public void addStarToMovie_Passed() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        // Act
        movie = new Movie(id, title, genre, format, year, director);
        movie.setStars(new ArrayList<String>());
        movie.addStarToMovie("Ron Livingston");
        movie.addStarToMovie("Jennifer Aniston");
        movie.addStarToMovie("Ali");

        // Assert
        assertThat(movie.getStars().size(), equalTo(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStarToMovie_NullValueProvided_ThrowIllegalArgumentException() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        // Act
        movie = new Movie(id, title, genre, format, year, director);
        movie.addStarToMovie(null);
    }

    @Test
    public void addStarToMovie_MockitoUsedToVerifyPassed() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens", "Noah", "Tamer"));
        List<String> stars = mock(List.class);

        // expectations
        when(stars.size())
                .thenReturn(3);

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);
        movie.addStarToMovie("Ron Livingston");
        movie.addStarToMovie("Jennifer Aniston");
        movie.addStarToMovie("Ali");

        // Assert
        assertThat(movie.getStars().size(), equalTo(3));
        verify(stars, times(3)).add(anyString());

    }

    @Test(expected = StarsListNotInitializedException.class)
    public void addStarToMovie_StarsListNotInitialized_ThrowStarsListNotInitializedException() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        List<String> writers = new ArrayList<>(Arrays.asList("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens", "Noah", "Tamer"));
        List<String> stars = null;

        // Act
        movie = new Movie(id, title, genre, format, year, director);
        movie.addStarToMovie("Ron Livingston");
        movie.addStarToMovie("Jennifer Aniston");
        movie.addStarToMovie("Ali");
    }

    // --------------------------------- Writer ---------------------------------------------------------
    @Test
    public void addWriterToMovie_Passed() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        // Act
        movie = new Movie(id, title, genre, format, year, director);
        movie.setWriters(new ArrayList<String>());
        movie.addWriterToMovie("Writer 1");
        movie.addWriterToMovie("Writer 2");
        movie.addWriterToMovie("Writer 3");

        // Assert
        assertThat(movie.getWriters().size(), equalTo(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWriterToMovie_NullValueProvided_ThrowIllegalArgumentException() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        // Act
        movie = new Movie(id, title, genre, format, year, director);
        movie.addWriterToMovie(null);
    }

    @Test
    public void addWriterToMovie_MockitoUsedToVerifyPassed() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        List<String> writers = mock(List.class);
        List<String> stars = new ArrayList<>(Arrays.asList("Star 1", "Star 2", "Star 3"));

        // expectations
        when(writers.size())
                .thenReturn(3);

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);
        movie.addWriterToMovie("Writer 1");
        movie.addWriterToMovie("Writer 2");
        movie.addWriterToMovie("Writer 3");

        // Assert
        assertThat(movie.getWriters().size(), equalTo(3));
        verify(writers, times(3)).add(anyString());

    }

    @Test(expected = WritersListNotInitializedException.class)
    public void addWriterToMovie_WritersListNotInitialized_ThrowWritersListNotInitializedException() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        List<String> writers = null;
        List<String> stars = new ArrayList<>(Arrays.asList("Star 1", "Star 2", "Star 3"));

        // Act
        movie = new Movie(id, title, genre, format, year, director);
        movie.addWriterToMovie("Writer 1");
        movie.addWriterToMovie("Writer 2");
        movie.addWriterToMovie("Writer 3");
    }

    //-------------------------------------------------------------------------------------------------------------

    @Test(expected = TitleCannotBeChangedAfterInitializationException.class)
    public void movieTitleCannotBeChangedAfterCreation() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2001;
        String director = "Peter Jackson";

        List<String> writers = new ArrayList<>(Arrays.asList("Writer 1", "Writer 2", "Writer 3"));
        List<String> stars = new ArrayList<>(Arrays.asList("Star 1", "Star 2", "Star 3"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);
        movie.setTitle("another title");

        // Assert
        assertThat(movie.getTitle(), equalTo(title));
    }


    @Test
    public void movieYearShouldBeEqualOrLowerThanCurrentYear() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2009;
        String director = "Peter Jackson";

        List<String> writers = new ArrayList<>(Arrays.asList("Writer 1", "Writer 2", "Writer 3"));
        List<String> stars = new ArrayList<>(Arrays.asList("Star 1", "Star 2", "Star 3"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int currentYear = Integer.valueOf(formatter.format(currentDate));

        // Assert
        assertThat(movie.getYear(), lessThanOrEqualTo(currentYear));
    }

    @Test(expected = MovieYearShouldBeLessThanOrEqualCurrentYearException.class)
    public void movieYearShouldNotBeGreaterThanCurrentYear() {
        //Arrange
        int id = 1;
        String title = "Office Space";
        String category = "Movies";
        String genre = "Drama";
        String format = "Blu-ray";
        int year = 2020;
        String director = "Peter Jackson";

        List<String> writers = new ArrayList<>(Arrays.asList("Writer 1", "Writer 2", "Writer 3"));
        List<String> stars = new ArrayList<>(Arrays.asList("Star 1", "Star 2", "Star 3"));

        // Act
        movie = new Movie(id, title, genre, format, year, director, writers, stars);

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int currentYear = Integer.valueOf(formatter.format(currentDate));

        // Assert
        assertThat(movie.getYear(), lessThanOrEqualTo(currentYear));
    }
}
