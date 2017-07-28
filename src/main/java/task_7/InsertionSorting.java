package task_7;

import java.util.ArrayList;

/**
 * Insertion sort implementation with array filled with random values
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
            int currentElement = array.get(i);
            int currentIndex = i;
            while ((currentIndex > 0) && (array.get(currentIndex - 1) > currentElement)) {
                array.set(currentIndex, array.get(currentIndex - 1));
                currentIndex--;
            }
            array.set(currentIndex, currentElement);
        }
    }
}
