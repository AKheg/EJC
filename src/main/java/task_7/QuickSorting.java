package task_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Create collection - 25 numbers from the keyboard
 * Output - 25 numbers before and after sorting
 */

public class QuickSorting {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(25);
        int intAmount = 25;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (intAmount > 0) {
                String input = reader.readLine();
                if (input.matches("[-+]?\\d+")) {
                    arrayList.add(Integer.parseInt(input));
                    intAmount--;
                } else {
                    System.out.println("Wrong input");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(arrayList);
        quickSort(arrayList, 0, arrayList.size() - 1);
        System.out.println(arrayList);
    }

    private static int partition(ArrayList<Integer> arrayList, int low, int high) {
        int middle = (low + high) / 2;
        int i = low;
        int j = high;
        int middleValue = arrayList.get(middle);

        while (i <= j) {
            while (arrayList.get(i) < middleValue) {
                i++;
            }
            while (middleValue < arrayList.get(j)) {
                j--;
            }
            if (i <= j) {
                Collections.swap(arrayList, i, j);
                i++;
                j--;
            }
        }
        return --i;
    }

    static void quickSort(ArrayList<Integer> arrayList,int start,int end){
        int q;

        if(start < end) {
            q = partition(arrayList, start, end);
            quickSort(arrayList, start, q);
            quickSort(arrayList,q + 1, end);
        }
    }
}
