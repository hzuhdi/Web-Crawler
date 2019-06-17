import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WCA_ControllerTest {

    @Before
    public void setUp() {

    }

    @Test
    public void getAllReturnValidResponse()
    {
        // Arrange
        Scraper scraper = new Scraper();
        Crawler crawler = new Crawler();
        Content content = new Content();
        String url = "";

        WCA_Controller controller = new WCA_Controller(scraper, crawler, content);

        // Act
        String response = controller.getAll(url);

        // Assert
        assertNotNull("Response is null", response);
        assertFalse("Response is empty", response.trim().isEmpty());
    }


}
