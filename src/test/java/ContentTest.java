import exception.YearException;
import models.Book;
import models.Music;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class ContentTest {
    @Test(expected = YearException.class)
    public void YearOfBookNotAfterTodayDate() throws YearException {
        Book book = new Book(2, "title", "genre", "formqt", LocalDate.now().getYear() + 1, Arrays.asList("author1"), "pib", "isbn");
    }

    @Test(expected = YearException.class)
    public void YearOfMusicNotAfterTodayDate() throws YearException {
        Music music = new Music(12, "genre", "format", LocalDate.now().getYear() + 1, "artist", "title");
    }
}