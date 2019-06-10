import exception.IDException;
import models.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.ArrayList;
import java.util.Calendar;

public class BookTest {

    private Book book;
    ArrayList<String> authors;

    @Before
    public void setUp(){
        authors = new ArrayList<>();
        String author1 = "Paul Pogba";
        authors.add(author1);
    }

    @Test
    public void bookShouldBeCreated() {
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
        assertThat(book.getAuthors(), equalTo(authors));
        assertEquals("How to code in Java", book.getTitle());
        assertEquals("ISBN123456789", book.getISBN());
        assertEquals("Computer", book.getGenre());
        assertEquals("pdf", book.getFormat());
        assertEquals(2009, book.getYear());
        assertEquals(authors, book.getAuthors());
        assertEquals("Gramedia Publisher", book.getPublisher());
    }

    @Test(expected = NullPointerException.class)
    public void titleShouldNotBeNull(){
        book = new Book(1, null, "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void idShouldBeBiggerThanZero() {
        book = new Book(0, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
    }

    @Test
    public void fiveAuthorsOfTheBookShouldBeAdded() {
        //Arrange
        String author2 = "Dani Alves";
        String author3 = "Christiano Ronaldo";
        String author4 = "Lionel Messi";
        String author5 = "Muhammad Salah";
        //Act
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
        //Assert
        assertEquals(book.getAuthors().size(), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionWhileAddingMoreThanFiveAuthors(){
        //Arrange
        String author2 = "Dani Alves";
        String author3 = "Christiano Ronaldo";
        String author4 = "De Jong";
        String author5 = "Mesut Ozil";
        String author6 = "Galileo Galilei";
        //Act
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        authors.add(author6);
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
        //Assert
        assertNull(book);
    }

    @Test(expected = IllegalArgumentException.class)
    public void authorShouldNotBeNull(){
        //Arrange
        ArrayList<String> auth = new ArrayList<String>();
        //Act
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2009, auth, "Gramedia Publisher", "ISBN123456789");
        //Assert
        assertEquals(0, book.getAuthors().size());
    }

    @Test
    public void dateBookShouldBeLowerThanOrEqualToTodayYear(){
        //Arrange
        int year = Calendar.getInstance().get(Calendar.YEAR);
        //Act
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2019, authors, "Gramedia Publisher", "ISBN123456789");
        //Assert
        assertThat(book.getYear(), lessThanOrEqualTo(year));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionOfAYearBookBiggerThanTodayYear(){
        //Arrange
        int year = Calendar.getInstance().get(Calendar.YEAR);
        //Act
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2020, authors, "Gramedia Publisher", "ISBN123456789");
        //Assert
        assertThat(book.getYear(), lessThanOrEqualTo(year));
    }

}
