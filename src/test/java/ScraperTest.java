import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

public class ScraperTest {

    private String url;

    @Before
    public void setUp(){
        url = "http://example.com";
    }

    @Test
    public void scraperTestParseUrl(){
        //Arrange
        Document document = mock(Document.class);
        Elements element = mock(Elements.class);
        Scraper scraper = new Scraper();
        //Act
        //The document will take only a search on the class div of media-details
        scraper.setDocument(document);
        when(document.getElementsByClass("media-details")).thenReturn(element);
        scraper.parseAll(url);
        //Assert
        //Since it's a void we will only verify the calls of the method
        verify(document, times(0)).getElementsByClass("media-details");
    }
}
