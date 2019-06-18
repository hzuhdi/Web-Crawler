import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Crawler {

    private int MAX_PAGES;
    private Set<String> pages_visited;
    private ArrayList<String> pages_to_visit;
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
    }

    public int getUrlSize(){
        return 0;
    }

    public void nextUrl(){
        if (URL_PATTERN == ""){
            throw new NullPointerException("Page should not be empty");
        }
        

    }
}
