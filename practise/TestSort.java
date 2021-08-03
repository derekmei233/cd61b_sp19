/**
 * Test the sort class
 */
public class TestSort{
    /** Test the Sort.sort method */
    public static void testSort(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        // or use java.utils.Array.equals(input, expected) to compare
        org.junit.Assert.assertArrayEquals(expected, input);
    }

    public static void testFindSmallest(){
        // Test case1:
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.FindSmallest(input, 0);
        org.junit.Assert.assertEquals(expected, actual);
        // Test case2:
        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;
        int actual2 = Sort.FindSmallest(input2, 0);
        org.junit.Assert.assertEquals(expected2, actual2);
    }
    public static void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        int a = 1;
        int b = 3;
        String[] expected = {"i", "egg", "an", "have"};
        Sort.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);
    }
    public static void main(String[] args){
        testSort();
        //testFindSmallest();
        //testSwap();
    }
}