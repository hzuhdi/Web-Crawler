import javax.swing.text.Document;
import java.util.List;

public class ParserHelper {
    private   int USER_AGENT;
    private List <String> links;
    private Document htmlDocument ;


    public  boolean crawl (String url){
        return true;
    }

    public  boolean searchForward (String word){
        return  true;
    }

    public List<String> getLinks() {
         return links;
    }
}
