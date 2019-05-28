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
        String author2 = "Dani Alves";
        authors.add(author1);
    }

    @Test
    public void constructorShouldNotNull() throws IDException {
        book = new Book(1, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
        assertThat(book.getAuthors(), equalTo(authors));
//        assertEquals(book.getTitle(), "How to code in Java");
//        assertEquals(book.getISBN(), "ISBN123456789");
//        assertEquals(book.ge);
    }

    @Test(expected = IDException.class)
    public void idShouldBeBiggerThanZero() throws IDException {
        book = new Book(0, "How to code in Java", "Computer", "pdf", 2009, authors, "Gramedia Publisher", "ISBN123456789");
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrownAnExceptionWhileAddingBookWithSomeNullParams() throws IDException{
        book = new Book(1, "", "", "", 2009, authors, "", "");
    }

}
