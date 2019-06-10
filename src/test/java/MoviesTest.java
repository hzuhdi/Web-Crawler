
import models.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MoviesTest {

    private Movie movie;

    @Before
    public void setUp() {

    }

    @Test
    public void titleShouldNotBeNull() {
        //Arrange
        String title = "X Man";
        //Act
        movie=new Movie(title);
        //Assert
    }

}
