package task_8;

import org.junit.Assert;

import org.junit.Test;

public class BubbleSortingTest {
    @Test
    public void testBubbleSort() {
        BubbleSorting test = new BubbleSorting();

        int[] unsorted = {6, 5, 4, 3, 3, 2, 25, 67, 55, 55};
        test.bubbleSort(unsorted);

        int[] sorted = {2, 3, 3, 4, 5, 6, 25, 55, 55, 67};

        Assert.assertArrayEquals(unsorted, sorted);
    }
}