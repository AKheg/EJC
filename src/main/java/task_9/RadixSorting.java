package task_9;

import java.util.Arrays;

public class RadixSorting {

    /**
     * Radix sort implementation
     *
     * @param array the array to be sorted
     */
     public void radixSort(int[] array) {
        int digit = 1;
        int maxArrayNumber = getMax(array);
        int[] tempArray = new int[array.length];
        
        while (maxArrayNumber / digit > 0) {
            int[] bucket = new int[10];
            Arrays.fill(bucket, 0);
            for (int arg : array) {
                bucket[(arg / digit) % 10]++;
            }
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = array.length - 1; i >=0 ; i--) {
                tempArray[--bucket[(array[i] / digit) % 10]] = array[i];
            }
            System.arraycopy(tempArray, 0, array, 0, array.length);
            digit *= 10;
        }
    }

    /**
     * @param array array of integers
     * @return max element of array
     */
    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
