import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

public class DuplicateSearchTest {
    private final Collection<Number> numbers = Arrays.asList(1.001, 3, 44.25, 4.2, 5, null);
    private final Collection<Integer> integerNumbers = Arrays.asList(1, null, 2, 3, 4, 5, 6);

    @Test
    public void haveDuplicateTest() {
        assertTrue(Main.haveDuplicate(numbers, integerNumbers));
    }

    @Test
    public void searchDuplicatesTest() {
        HashSet<Number> set = new HashSet<>(Arrays.asList(3, 5, null));
        assertEquals(set, Main.searchDuplicates(numbers, integerNumbers));
    }

    @Test
    public void countDuplicatesTest() {
        assertEquals(3, Main.countDuplicates(numbers, integerNumbers));
    }

}
