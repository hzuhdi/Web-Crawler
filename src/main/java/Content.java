import models.Book;
import models.Movie;
import models.Music;

import java.util.ArrayList;

public class Content {
    ArrayList<Music> musics;
    ArrayList<Book> books;
    ArrayList<Movie> movies;

    /**
     *
     * @param musics
     * @param books
     * @param movies
     */
    public Content(ArrayList<Music> musics, ArrayList<Book> books, ArrayList<Movie> movies) {
        this.musics = musics;
        this.books = books;
        this.movies = movies;
    }

    public Content() {
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public String converToJson(){
        return null;
    }

    public void addToList(){

    }
    public void addToListBook(Book book) {
        this.books.add(book);
    }



    public void addToListMovie(Movie movie) {

    }
}
