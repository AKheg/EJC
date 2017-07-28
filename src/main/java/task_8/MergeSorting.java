package task_8;

/**
 * Merge sort implementation
 */
public class MergeSorting {
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
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < result.length; i++) {
            if ((secondIndex >= right.length) ||
                    ((firstIndex < left.length) && (left[firstIndex] <= right[secondIndex]))) {
                result[i] = left[firstIndex];
                firstIndex++;
            } else {
                result[i] = right[secondIndex];
                secondIndex++;
            }
        }
    }
}
