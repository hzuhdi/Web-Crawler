public class WCA_Controller {

    Scraper scraper;
    Crawler crawler;
    Content content;

    public WCA_Controller(Scraper scraper, Crawler crawler, Content content) {
        this.scraper = scraper;
        this.crawler = crawler;
        this.content = content;
    }

    public WCA_Controller() {
    }

    public String getAll(String url){
        return "";
    }

    public String getSpecific(String url, String keyword){
        return "";
    }


}
