package task_8;

import java.util.Arrays;

/**
 * Binary search implementation
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[20];
        int i = 0;

        while (i < 20) {
            int random = (int) (Math.random() * 100);
            if (!(random == 42)) {
                array[i] = random;
                i++;
            }
        }
        int randomIndex = (int) (Math.random() * 20);
        array[randomIndex] = 42;
        new MergeSorting().mergeSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println(new BinarySearch().find(array, 42));
    }

    int find(int[] array, int x) {
        int i = -1;

        if (array != null) {
            int bottomIndex = 0;
            int endIndex = array.length;
            int middleIndex;
            while (bottomIndex < endIndex) {
                middleIndex = (bottomIndex + endIndex) / 2;
                if (x == array[middleIndex]) {
                    i = middleIndex;
                    break;
                } else {
                    if (x < array[middleIndex]) {
                        endIndex = middleIndex;
                    } else {
                        bottomIndex = middleIndex + 1;
                    }
                }
            }
        }
        return i;
    }
}
