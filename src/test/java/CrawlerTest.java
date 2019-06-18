import exception.YearException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CrawlerTest {
    @Test
    public void getURLSizeReturnIntValue() throws IOException, YearException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("http://localhost/sample_site_to_crawl/catalog.php");
        assertEquals(19, crawler.getUrlSize());
    }

    @Test
    public void getOtherURLSizeReturnIntValue() throws YearException, IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("http://localhost/sample_site_to_crawl/catalog.php?cat=books");
        assertEquals(12, crawler.getUrlSize());
    }

    @Test
    public void getPageVisitedSize(){
        Crawler crawler = new Crawler();
        int x = crawler.getPagevisitedSize();
        assertEquals(0, x);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parameterOfLoopUrlShouldNotBeNull() throws IOException {
        Crawler crawler = new Crawler();
        //crawler.loopUrl(null, null);
    }
    @Test(expected = IOException.class)
    public void loopUrlInvalid() throws IOException {
        Crawler crawler = new Crawler();
        //crawler.loopUrl("Invalid Url here", "demoWord");
    }
    /*@Test(expected = NullPointerException.class)
    public void pageToVisitIsNotEmpty() throws IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("https://www.youtube.com/","demoWorld");
    }*/
}
