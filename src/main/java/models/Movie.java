package models;


import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String category = "Movies";
    private String genre;
    private String format;
    private int year;
    private String director;
    private List<String> writers = new ArrayList<>();
    private List<String> stars;

    /**
     * @param id
     * @param title
     * @param genre
     * @param format
     * @param year
     * @param director
     * @param writers
     * @param stars
     */
    public Movie(int id, String title, String genre, String format, int year, String director, List<String> writers, List<String> stars) {
        if (title == null) {
            throw new IllegalArgumentException();
        }

        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.writers.size() > 5) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.director = director;
        this.writers = writers;
        this.stars = stars;
    }
}
