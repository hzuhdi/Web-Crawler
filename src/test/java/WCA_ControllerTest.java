import exception.YearException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.Year;

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


}
