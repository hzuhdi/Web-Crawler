import exception.YearException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class WCA_ControllerTest {

    @Before
    public void setUp() {

    }

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


}
