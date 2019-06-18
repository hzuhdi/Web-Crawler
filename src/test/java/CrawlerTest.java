import org.junit.Test;

import java.io.IOException;

public class CrawlerTest {
    @Test
    public void getURLSizeReturnIntValue() throws IOException {
        Crawler crawler = new Crawler();
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
    @Test(expected = NullPointerException.class)
    public void pageToVisitIsNotEmpty() throws IOException {
        Crawler crawler = new Crawler();
        crawler.loopUrl("http://localhost/sample_site_to_crawl/details.php?id=201","demoWorld");
    }
}
