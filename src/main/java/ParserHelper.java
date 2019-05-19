import javax.swing.text.Document;
import java.util.List;

public class ParserHelper {
    private   int USER_AGENT;
    private List <String> links;
    private Document htmlDocument ;


    /**
     *
     * @param url as a html url that will be processed to HTML parser
     * @return a condition whether the http response ok or not
     */
    public  boolean crawl (String url){
        return true;
    }

    /**
     *
     * @param word as a keyword that want to take a look
     * @return a condition whether the keyword found or not
     */
    public  boolean searchForward (String word){
        return  true;
    }


    /**
     *
     * @return a list of all links in the website
     */
    public List<String> getLinks() {
         return links;
    }
}
