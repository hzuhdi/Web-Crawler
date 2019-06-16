import exception.YearException;
import models.Book;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class ContentTest {
    @Test(expected = YearException.class)
    public void YearOfBookNotAfterTodayDate() throws YearException {
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() + 1, Arrays.asList("author1"), "pib", "isbn");
    }
}
