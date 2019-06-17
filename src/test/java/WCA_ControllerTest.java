import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class WCA_ControllerTest {

    @Before
    public void setUp() {

    }

    @Test
    public void getAllReturnValidResponse()
    {
        // Arrange
        WCA_Controller controller = new WCA_Controller();
        Scraper scraper = new Scraper();
        Crawler crawler = new Crawler();
        Content content = new Content();
        String url = "";

        // Act
        String response = controller.getAll(scraper, crawler, content, url);

        // Assert
        assertNotNull("Response is null", response);
    }


}
