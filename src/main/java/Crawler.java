import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Crawler {

    private static final int MAX_PAGES = 10;
    private Set<String> pages_visited= new HashSet<>();
    //private ArrayList<String> pages_to_visit;
    private List<String> pagesToVisit = new LinkedList<>();
    private static final String URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    public Crawler(){

    }
    /**
     * Our main launching point for the Spider's functionality. It creates spider legs
     * that make an HTTP request and parse the response (the web page).
     *
     * @param url        - The starting point of the spider
     * @param searchWord - The word or string that you are searching for
     */
    public void loopUrl(String url,String searchWord)throws IOException{
        if (url == null || searchWord == null) {
            throw new IllegalArgumentException("Arguments should not be null");
        } else if (!url.matches(URL_PATTERN)) {
            throw new IOException("The url is not valid");
        }
        while (this.pages_visited.size() < MAX_PAGES) {
            String currentUrl;

            if (this.pagesToVisit.isEmpty()) {
                currentUrl = url;
                this.pages_visited.add(url);
            } else {
                currentUrl = this.nextUrl();
            }
    }}

    public int getUrlSize(){
        return 0;
    }
    /**
     * Returns the next URL to visit (in the order that they were found). We also do a check to make
     * sure this method doesn't return a URL that has already been visited.
     *
     * @return
     */
    public String nextUrl(){
        String nextUrl = null;
        if (nextUrl == ""){
            throw new NullPointerException("Page should not be empty");
        }
        do {
            nextUrl = this.pagesToVisit.remove(0);
        } while (this.pages_visited.contains(nextUrl));
        this.pages_visited.add(nextUrl);

        return nextUrl;
    }

}
class CrawlerUtil {
    private List<String> links = new LinkedList<>();
    private Document htmlDocument;
    private static final String USER_AGENT ="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    public boolean crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            if (connection.response().statusCode() == 200) {
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if (!connection.response().contentType().contains("text/html")) {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for (Element link : linksOnPage) {
                this.links.add(link.absUrl("href"));
            }
            return true;
        } catch (IOException ioe) {
            // We were not successful in our HTTP request
            return false;
        }

    }
    public boolean searchForWord(String searchWord){
        if (this.htmlDocument == null) {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
            return false;
        }

        return true;}
    public List<String> getLinks() {
        return links;
    }
    }

