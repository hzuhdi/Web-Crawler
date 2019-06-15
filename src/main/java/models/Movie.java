package models;


import exception.*;

import javax.naming.directory.AttributeInUseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String category = "Movies";
    private String genre;
    private String format;
    private int year;
    private String director;
    private List<String> writers = null;
    private List<String> stars = null;

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
        if (year <= 0) {
            throw new AttributeNotPresentedException("year should not be null or 0");
        }

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int currentYear = Integer.valueOf(formatter.format(currentDate));

        if(year > currentYear)
        {
            throw new MovieYearShouldBeLessThanOrEqualCurrentYearException("Movie year should be less than or equal current");
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


    /**
     * @param id
     * @param title
     * @param genre
     * @param format
     * @param year
     * @param director
     */
    public Movie(int id, String title, String genre, String format, int year, String director) {
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
        if (year <= 0) {
            throw new AttributeNotPresentedException("year should not be null or 0");
        }

        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int currentYear = Integer.valueOf(formatter.format(currentDate));

        if(year > currentYear)
        {
            throw new MovieYearShouldBeLessThanOrEqualCurrentYearException("Movie year should be less than or equal current");
        }

        if (director == null) {
            throw new AttributeNotPresentedException("director should not be null or empty");
        }


        this.id = id;
        this.title = title;
        this.genre = genre;
        this.format = format;
        this.year = year;
        this.director = director;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        throw new TitleCannotBeChangedAfterInitializationException("Title cannot be changed after creation");
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

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public void addStarToMovie(String star) {
        if (star == null || star.trim().isEmpty()) {
            throw new IllegalArgumentException("Should not be null or empty");
        }

        if (this.stars==null){
            throw new StarsListNotInitializedException("Star list should not be null");
        }
        this.stars.add(star);
    }

    public void addWriterToMovie(String writer) {
        if (writer == null || writer.trim().isEmpty()) {
            throw new IllegalArgumentException("Should not be null or empty");
        }
        if (this.writers==null){
            throw new WritersListNotInitializedException("Writer list should not be null");
        }
        this.writers.add(writer);
    }
}
