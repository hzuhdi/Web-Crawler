package models;

public class Music {

    private int id;
    private String genre;
    private String format;
    private  int year;
    private String artist;

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
    public Music(int id, String genre, String format, int year, String artist) {
        this.id = id;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.artist = artist;
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

}
