import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CrawlerTest {
    @Test
    public void getURLSizeReturnIntValue() throws IOException {
        Crawler crawler = new Crawler();
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

    @Test
    public void shouldGetAllUrl() throws IOException {
        Crawler crawler = new Crawler();
        String url = "http://localhost/sample_site_to_crawl/catalog.php";
        crawler.getAllUrl(url);
        int x = crawler.getPagesToVisit().size();
        assertEquals(12, x);
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
        assertEquals(false, x);
    }

    @Test
    public void checkCategoryUrlShouldbeInvalidOfNotReferingToTheId(){
        Crawler crawler = new Crawler();
        String url = "http://localhost/sample_site_to_crawl/catalog.php?cat=books";
        boolean x = crawler.checkIfCategoryUrl(url);
        assertEquals(false, x);
    }
}
