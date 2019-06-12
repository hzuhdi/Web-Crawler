package models;


import exception.AllowedWritersNumberExceededException;
import exception.AttributeNotPresentedException;

import javax.naming.directory.AttributeInUseException;
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
    private List<String> stars = new ArrayList<>();

    /**
     * @param id
     * @param title
     * @param genre
     * @param format
     * @param year
     * @param director
     */
    public Movie(int id, String title, String genre, String format, int year, String director, List<String> writers, List<String> stars) {
        if (title == null) {
            throw new AttributeNotPresentedException("title should not be null or empty");
        }

        if (id <= 0) {
            throw new AttributeNotPresentedException("id should not be null or 0");
        }
        if (genre == null) {
            throw new AttributeNotPresentedException("genre should not be null or empty");
        }
        if (format == null) {
            throw new AttributeNotPresentedException("format should not be null or empty");
        }
        if (year <=0) {
            throw new AttributeNotPresentedException("year should not be null or 0");
        }
        if (director == null) {
            throw new AttributeNotPresentedException("director should not be null or empty");
        }
        if (writers == null) {
            throw new AttributeNotPresentedException("writers list should not be null or empty");
        }

        if (stars == null) {
            throw new AttributeNotPresentedException("stars list should not be null or empty");
        }

        if (writers.size() > 5) {
            throw new AllowedWritersNumberExceededException("More than 5 writers not allowed");
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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getGenre() {
        return genre;
    }

    public String getFormat() {
        return format;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getStars() {
        return stars;
    }
}
