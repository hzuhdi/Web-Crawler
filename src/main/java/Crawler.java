import exception.YearException;
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
    private static final String USER_AGENT ="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private static final String URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    public Crawler(){

    }
//    /**
//     * Our main launching point for the Spider's functionality. It creates spider legs
//     * that make an HTTP request and parse the response (the web page).
//     *
//     * @param url        - The starting point of the spider
//     * @param searchWord - The word or string that you are searching for
//     */
//    public void loopUrl(String url,String searchWord)throws IOException{
//        if (url == null || searchWord == null) {
//            throw new IllegalArgumentException("Arguments should not be null");
//        } else if (!url.matches(URL_PATTERN)) {
//            throw new IOException("The url is not valid");
//        }
//        while (this.pages_visited.size() < MAX_PAGES) {
//            String currentUrl;
//
//            if (this.pagesToVisit.isEmpty()) {
//                currentUrl = url;
//                this.pages_visited.add(url);
//            } else {
//                currentUrl = this.nextUrl();
//            }
//    }}
//
//    public int getUrlSize(){
//        return 0;
//    }

//    public void loopUrl(String url) throws YearException, IOException {
//        List<String> links = new LinkedList<String >();
//        this.pagesToVisit.add(url);
//        Document htmlDocument = Jsoup.connect(url).userAgent(USER_AGENT).get();
//        Elements htmlElements =  htmlDocument.select("a[href]");
//        int sizeActual = htmlElements.size();
//        //will be looping until the pageToVisit zero
//        while(this.pagesToVisit.size() < sizeActual){
//            String currentUrl;
//            System.out.println("\n**Visiting** Received web page at " + url);
//            Document htmlDocument1 = Jsoup.connect(url).userAgent(USER_AGENT).get();
//            Elements htmlElements1 =  htmlDocument1.select("a[href]");
//            System.out.println("Found (" + htmlElements1.size() + ") links");
//
//            for(Element element: htmlElements1){
//                if(!pages_visited.contains(element.absUrl("href"))){
//                    links.add(element.absUrl("href"));
//                    System.out.println(element.absUrl("href"));
//                    pagesToVisit.add(element.absUrl("href"));
//                }
//            }
//        }
//        this.pagesToVisit = links;
//    }

    //This methods intends to thDocument
    public void getAllUrl(String url) throws IOException {
        if(url.isEmpty()){
            throw new IOException();
        }
        Document document = Jsoup.connect(url).userAgent(USER_AGENT).get();
        Elements htmlElements = document.select("a[href]");
        for(Element element: htmlElements){
            String link = element.absUrl("href").toString();
            System.out.println(link);
            pagesToVisit.add(link);
        }
    }

    public boolean checkIfCategoryUrl(String url){
        boolean myStatus = true;
        if(url.contains(".com")){
            myStatus = false;
        }
        return myStatus;
    }

    public Set<String> getPages_visited() {
        return pages_visited;
    }

    public void setPages_visited(Set<String> pages_visited) {
        this.pages_visited = pages_visited;
    }

    public List<String> getPagesToVisit() {
        return pagesToVisit;
    }

    public void setPagesToVisit(List<String> pagesToVisit) {
        this.pagesToVisit = pagesToVisit;
    }

    /**
     *
     * Returns the next URL to visit (in the order that they were found). We also do a check to make
     * sure this method doesn't return a URL that has already been visited.
     *
     * @return
     */
//    public String nextUrl(){
//        String nextUrl = null;
//        if (nextUrl == ""){
//            throw new NullPointerException("Page should not be empty");
//        }
//        do {
//            nextUrl = this.pagesToVisit.remove(0);
//        } while (this.pages_visited.contains(nextUrl));
//        this.pages_visited.add(nextUrl);
//
//        return nextUrl;
//    }

}

