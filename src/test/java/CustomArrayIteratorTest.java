import org.junit.Test;
import iterator.CustomArrayIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CustomArrayIteratorTest {

    private final String[][] strings = new String[][] { {"Vlad", "Vika"},
                                                        {},
                                                        {},
                                                        {},
                                                        {"Vasya"},
                                                        {} };

    @Test (expected = NoSuchElementException.class)
    public void hasNestTest() {
        CustomArrayIterator<String> iterator = new CustomArrayIterator<>(strings);

        assertEquals("Vlad", iterator.next());
        assertEquals("Vika", iterator.next());
        assertEquals("Vasya", iterator.next());
        iterator.next();
    }

    @Test
    public void hasNextTest() {
        CustomArrayIterator<String> iterator = new CustomArrayIterator<>(strings);

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();

        assertFalse(iterator.hasNext());
    }
}
