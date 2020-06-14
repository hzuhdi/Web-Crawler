import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CrawlerTest {

    @Test(expected = NullPointerException.class)
    public void parameterOfGetUrlShouldNotBeNull() throws IOException {
        Crawler crawler = new Crawler();
        crawler.getAllUrl(null);
        //crawler.loopUrl(null, null);
    }
    @Test(expected = IOException.class)
    public void getAllUrlInvalid() throws IOException {
        Crawler crawler = new Crawler();
        crawler.getAllUrl("http://haha");
    }

    @Test
    public void shouldGetAllUrl() throws IOException {
        Crawler crawler = new Crawler();
        String url = "http://localhost/sample_site_to_crawl/catalog.php";
        crawler.getAllUrl(url);
        int x = crawler.getPagesToVisit().size();
        assertEquals("It's returned a correct number of url", 12, x);
    }

    @Test (expected = IOException.class)
    public void shouldThrownAnExceptionIfItsANull() throws IOException {
        Crawler crawler = new Crawler();
        String url = "";
        crawler.getAllUrl(url);
    }

    @Test
    public void checkCategoryUrl(){
        Crawler crawler = new Crawler();
        String url = "http://twitter.com";
        boolean x = crawler.checkIfCategoryUrl(url);
        assertEquals("It doesn't fit with the url criteria", false, x);
    }

    @Test
    public void checkCategoryUrlShouldbeInvalidOfNotReferingToTheId(){
        Crawler crawler = new Crawler();
        String url = "http://localhost/sample_site_to_crawl/catalog.php?cat=books";
        boolean x = crawler.checkIfCategoryUrl(url);
        assertEquals("It doesn't fit with the url criteria", false, x);
    }
}
