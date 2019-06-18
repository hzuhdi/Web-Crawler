import java.util.ArrayList;
import java.util.Set;

public class Crawler {

    private int MAX_PAGES;
    private Set<String> pages_visited;
    private ArrayList<String> pages_to_visit;
    private static final String URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public Crawler(){

    }

    public void loopUrl(String url){

    }

    public int getUrlSize(){
        return 0;
    }

    public void nextUrl(){

    }
}
