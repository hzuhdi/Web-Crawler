package models;
import java.time.LocalDate;
import java.util.List;
import exception.YearException;

public class Music {

    private int id;
    private String genre;
    private String format;
    private  int year;
    private String artist;
    private String title;

    public Music (){

    }

    /**
     *
     * @param id
     * @param genre
     * @param format
     * @param year
     * @param artist
     */
    public Music(int id, String genre, String format, int year, String artist , String title) throws YearException{
        if (title == null) {
            throw new IllegalArgumentException("Title should not be null");
        }
        /*else if (artist != null && artist.size() > 3) {
            throw new IllegalArgumentException("Artists should not be more than 3");
        }*/
        else if( id <=0) {
            throw new IllegalArgumentException("id should be greater than 0");
        }
        else if ( year > LocalDate.now().getYear()) {
            throw new YearException("year should be lower than or equal current year");
        }
        this.id = id;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.artist = artist;
        this.title=title;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre ()
    {
        return genre;
    }

    public String getFormat() {
        return format;
    }

    public int getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }
    public String getTitle(){
        return title;
    }

    public void setGenre(String genre) {
        this.genre= genre;
    }
    public void setFormat(String format) {
        this.format= format;
    }
    public void setYear(int year) {
        this.year=year;
    }
    public void setArtist(String artist) {
        this.year= year ;
    }
    public  void setTitle(String title){
        this.title= title;
    }

}
