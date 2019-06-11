import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

    private String USER_AGENT;
    private Document document;
    private Element element;
    private Elements elements;
    private String search;

    public Scraper() {
    }

    public void addToList(){

    }

    public void parseAll(String url){

    }

    public boolean parseSpecific(String url, String keyword){
        return false;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }
}
