import com.google.gson.Gson;
import exception.YearException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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

    public String getAll(String url) throws YearException, IOException {
        startTime = new Date();
        scraper =  new Scraper();
        crawler = new Crawler();
        crawler.getAllUrl(url);
        List<String> pagesToVisit = crawler.getPagesToVisit();
        for(int i =0; i<pagesToVisit.size(); i++){
            System.out.println(pagesToVisit.get(i));
            scraper.parseAll(pagesToVisit.get(i));
        }

        endTime = new Date();

        timeElapsedInMS = endTime.getTime() - startTime.getTime();

        content.setBooks(scraper.getBooks());
        content.setMovies(scraper.getMovies());
        content.setMusics(scraper.getMusics());

        return content.converToJson();
    }

    public String getSpecific(String url, String keyword) throws YearException, IOException {

        startTime = new Date();

        Object o = scraper.parseSpecific(url, keyword);

        endTime = new Date();

        timeElapsedInMS = endTime.getTime() - startTime.getTime();

        String x=new Gson().toJson(o).toString();
        return new Gson().toJson(o).toString();
    }


    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
