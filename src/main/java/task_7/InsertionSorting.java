package task_7;

import java.util.ArrayList;

/**
 * Insertion sort implementation
 */

public class InsertionSorting {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(100);

        for (int i = 0; i < 99; i++) {
            int rnd = (int) (Math.random() * 1000);
            arrayList.add(rnd);
        }
        insertionSort(arrayList);
        System.out.println(arrayList);
    }

    static void insertionSort(ArrayList<Integer> array) {

        for (int i = 1; i < array.size(); i++) {
            int x = array.get(i);
            int j = i;
            while ((j > 0) && (array.get(j - 1) > x)) {
                array.set(j, array.get(j - 1));
                j--;
            }
            array.set(j, x);
        }
    }
}
