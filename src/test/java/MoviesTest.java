
import models.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoviesTest {

    private Movie movie;

    @Before
    public void setUp() {

    }

    @Test
    public void titleShouldNotBeNull_MovieObjectInitializedSuccessfully() {
        //Arrange
        String title = "Office Space";
        //Act
        movie=new Movie(0,title,null,null,0,null,null,null);
        //Assert
        assertNotNull(movie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void titleIsNull_MovieObjectInitializationFail() {
        //Arrange
        String title = null;
        //Act
        movie=new Movie(0,title,null,null,0,null,null,null);
        //Assert
        assertNotNull(movie);
    }

    // Id should be bigger than zero
    @Test
    public void IdShouldBeBiggerThanZero_MovieObjectInitializedSuccessfully() {
        //Arrange
        String title = "Office Space";
        int id = 10;
        //Act
        movie=new Movie(id,title,null,null,0,null,null,null);
        //Assert
        assertNotNull(movie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void IdLessThanOrEqualToZero_MovieObjectInitializationFail() {
        //Arrange
        String title = "Office Space";
        int id = 0;
        //Act
        movie=new Movie(id,title,null,null,0,null,null,null);
        //Assert
    }
}
