package task_9;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortingTest {
    @Test
    public void testRadixSort() {
        int[] firstUnsortedArray = {8, 7, 4565, 666, 42343, 44, 543, 365, 42, 314, 2578};
        int[] firstSortedArray = {7, 8, 42, 44, 314, 365, 543, 666, 2578, 4565, 42343};
        int[] secondUnsortedArray = {34534, 545, 675646, 123, 54535, 6757, 65654, 455, 4, 2, 1, 45345345};
        int[] secondSortedArray = {1, 2, 4, 123, 455, 545, 6757, 34534, 54535, 65654, 675646, 45345345};
        RadixSorting radixSorting = new RadixSorting();
        radixSorting.radixSort(firstUnsortedArray);
        radixSorting.radixSort(secondUnsortedArray);
        Assert.assertArrayEquals(firstSortedArray, firstUnsortedArray);
        Assert.assertArrayEquals(secondSortedArray, secondUnsortedArray);
    }

}