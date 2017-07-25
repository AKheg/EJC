package task_8;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[20];
        int i = 0;

        while (i < 20) {
            int rnd = (int) (Math.random() * 100);
            if (!(rnd == 42)) {
                array[i] = rnd;
                i++;
            }
        }
        int rndInd = (int) (Math.random() * 20);
        array[rndInd] = 42;
        new MergeSorting().mergeSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println(new BinarySearch().find(array, 42));
    }

    int find(int[] array, int x) {
        int i = -1;

        if (array != null) {
            int low = 0;
            int high = array.length;
            int mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (x == array[mid]) {
                    i = mid;
                    break;
                } else {
                    if (x < array[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return i;
    }
}
