import exception.IDException;
import models.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.ArrayList;

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
    public void shouldAddAnAuthorToTheBook() {
        //Arrange
        String author2 = "Dani Alves";
        String author3 = "Christiano Ronaldo";
        //Act
        authors.add(author2);
        authors.add(author3);
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
        //Assert
        assertEquals(book.getAuthors().size(), 3);
    }

}
