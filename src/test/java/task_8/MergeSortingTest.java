package task_8;

import org.junit.Assert;

import org.junit.Test;

public class MergeSortingTest {

    private MergeSorting test = new MergeSorting();
    @Test
    public void testMergeSort() {

        int[] unsorted = {6, 5, 4, 3, 3, 2, 25, 67, 55, 55};
        test.mergeSort(unsorted);
        int[] unsorted2 = {};
        test.mergeSort(unsorted2);
        int[] unsorted3 = {8};
        test.mergeSort(unsorted3);

        int[] sorted = {2, 3, 3, 4, 5, 6, 25, 55, 55, 67};
        int[] sorted2 = {};
        int[] sorted3 = {8};

        Assert.assertArrayEquals(unsorted, sorted);
        Assert.assertArrayEquals(unsorted2, sorted2);
        Assert.assertArrayEquals(unsorted3, sorted3);

    }
}