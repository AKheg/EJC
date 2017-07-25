package task_8;

import java.util.Arrays;

/**
 * Merge sort implementation
 */

public class MergeSorting {
    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < 99; i++) {
            int rnd = (int) (Math.random() * 1000);
            array[i] = rnd;
        }
        new MergeSorting().mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    void mergeSort(int[] array) {

        if (array.length > 1) {
            int[] arrayLeft = new int[array.length / 2];
            System.arraycopy(array, 0, arrayLeft, 0, array.length / 2);

            int size = array.length - (array.length / 2);
            int[] arrayRight = new int[size];
            System.arraycopy(array, array.length / 2, arrayRight, 0, size);

            mergeSort(arrayLeft);
            mergeSort(arrayRight);
            merge(array, arrayLeft, arrayRight);
        }
    }

    private void merge(int[] result, int[] left, int[] right) {
        int fstInd = 0;
        int scndInd = 0;

        for (int i = 0; i < result.length; i++) {
            if ((scndInd >= right.length) || ((fstInd < left.length) && (left[fstInd] <= right[scndInd]))) {
                result[i] = left[fstInd];
                fstInd++;
            } else {
                result[i] = right[scndInd];
                scndInd++;
            }
        }
    }
}
