import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    // Your tests go here.
    static CharacterComparator offByOne  = new OffByOne();

    @Test
    public void testequalChars() {
        char tp1 = 'q';
        char tq1 = 'p';
        assertTrue(offByOne .equalChars(tp1, tq1));
        char tp2 = 'q';
        char tq2 = 'r';
        assertTrue(offByOne .equalChars(tp2, tq2));
        char tp3 = 'q';
        char tq3 = 's';
        assertFalse(offByOne .equalChars(tp3, tq3));

    }
}
