import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome() {
        String test1 = "cat";
        assertFalse(palindrome.isPalindrome(test1));
        String test2 = "";
        assertTrue(palindrome.isPalindrome(test2));
        String test3 = "t";
        assertTrue(palindrome.isPalindrome(test3));
        String test4 = "pstsp";
        assertTrue(palindrome.isPalindrome(test4));
        String test5 = "asffsa";
        assertTrue(palindrome.isPalindrome(test5));
        String test6 = "asftqdatfsa";
        assertFalse(palindrome.isPalindrome(test6));

        OffByOne offbyone = new OffByOne();
        String test21 = "cat";
        assertFalse(palindrome.isPalindrome(test21, offbyone));
        String test22 = "";
        assertTrue(palindrome.isPalindrome(test22, offbyone));
        String test23 = "t";
        assertTrue(palindrome.isPalindrome(test23, offbyone));
        String test24 = "pstsp";
        assertFalse(palindrome.isPalindrome(test24, offbyone));
        String test25 = "asfetb";
        assertTrue(palindrome.isPalindrome(test25, offbyone));
        String test26 = "asftqdatfsa";
        assertFalse(palindrome.isPalindrome(test26, offbyone));
        String test27 = "aresbdatfsb";
        assertTrue(palindrome.isPalindrome(test27, offbyone));
    }
}
