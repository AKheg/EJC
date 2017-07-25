package task_7;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InsertionSortingTest {
    @Test
    public void testInsertionSort() {
        ArrayList<Integer> originalArray = new ArrayList<>();
        originalArray.add(9);
        originalArray.add(8);
        originalArray.add(7);
        originalArray.add(6);
        originalArray.add(5);
        originalArray.add(4);
        originalArray.add(3);
        originalArray.add(2);
        originalArray.add(1);
        originalArray.add(9);
        originalArray.add(8);
        originalArray.add(7);
        originalArray.add(6);
        originalArray.add(-7);
        originalArray.add(-6);

        InsertionSorting.insertionSort(originalArray);

        ArrayList<Integer> sortedOriginalArray = new ArrayList<>();
        sortedOriginalArray.add(-7);
        sortedOriginalArray.add(-6);
        sortedOriginalArray.add(1);
        sortedOriginalArray.add(2);
        sortedOriginalArray.add(3);
        sortedOriginalArray.add(4);
        sortedOriginalArray.add(5);
        sortedOriginalArray.add(6);
        sortedOriginalArray.add(6);
        sortedOriginalArray.add(7);
        sortedOriginalArray.add(7);
        sortedOriginalArray.add(8);
        sortedOriginalArray.add(8);
        sortedOriginalArray.add(9);
        sortedOriginalArray.add(9);

        assertEquals(sortedOriginalArray, originalArray);
    }
}
