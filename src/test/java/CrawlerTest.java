import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CrawlerTest {
    @Test
    public void getURLSizeReturnIntValue() throws IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("http://localhost/sample_site_to_crawl/catalog.php");
        assertEquals(12, crawler.getUrlSize());
    }
    @Test(expected = IllegalArgumentException.class)
    public void parameterOfLoopUrlShouldNotBeNull() throws IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl(null, null);
    }
    @Test(expected = IOException.class)
    public void loopUrlInvalid() throws IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("Invalid Url here", "demoWord");
    }
    /*@Test(expected = NullPointerException.class)
    public void pageToVisitIsNotEmpty() throws IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("https://www.youtube.com/","demoWorld");
    }*/
}
