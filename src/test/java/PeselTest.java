import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeselTest {

    Pesel pesel;

    @Before
    public void setUp(){
        pesel = new Pesel();
    }

    @Test
    public void isPeselValid() {
        pesel.setPesel("123");
        boolean result = pesel.isPeselValid();
        assertFalse(result);
    }

    @Test
    public void isPeselValid2() {
        pesel.setPesel("12345678901");
        boolean result = pesel.isPeselValid();
        assertFalse(result);
    }

    @Test
    public void isPeselValid3() {
        pesel.setPesel("94090302865");
        boolean result = pesel.isPeselValid();
        assertTrue(result);
    }
}