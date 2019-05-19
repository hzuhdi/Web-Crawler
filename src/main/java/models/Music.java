package models;

public class Music {
    private String genre;
    private String format;
    private  int year;
    private String artist;

    public Music (){

    }
    public Music(String genre, String format, int year, String artist) {
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.artist = artist;
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
