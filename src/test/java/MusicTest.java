import models.Music;
import org.junit.Test;
import exception.YearException;
import java.util.Arrays;

public class MusicTest {

    private Music music ;


    @Test(expected = IllegalArgumentException.class)
    public void titleShouldNotBeNull() throws YearException {
        music = new Music(1, "genre1", "format", 2011, Arrays.asList("artist1"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fourArtistsShouldFail() throws YearException {
        music = new Music(1, "genre1", "format", 2011, Arrays.asList("artist1", "artist2", "artist3", "artist4"), "title2");
    }
}
