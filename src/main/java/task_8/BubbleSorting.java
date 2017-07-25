package task_8;

import java.util.Arrays;

public class BubbleSorting {

    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 0; i < 99; i++) {
            int rnd = (int) (Math.random() * 1000);
            array[i] = rnd;
        }
        new BubbleSorting().bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * simple bubble sort implementation
     */
    void bubbleSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
