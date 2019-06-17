import exception.YearException;

import java.util.Date;

public class WCA_Controller {

    Scraper scraper;
    Crawler crawler;
    Content content;

    private Date startTime;
    private Date endTime;
    private long timeElapsedInMS;

    public WCA_Controller(Scraper scraper, Crawler crawler, Content content) {
        this.scraper = scraper;
        this.crawler = crawler;
        this.content = content;
    }

    public WCA_Controller() {
    }

    public String getAll(String url) throws YearException {
        startTime = new Date();

        scraper.parseAll(url);

        endTime = new Date();

        timeElapsedInMS = endTime.getTime() - startTime.getTime();

        content.addToList(scraper.getBooks(), scraper.getMovies(), scraper.getMusics());

        return content.converToJson();
    }

    public String getSpecific(String url, String keyword){
        return "";
    }


}
