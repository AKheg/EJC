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
        int intAmount = 25;
        ArrayList<Integer> arrayList = new ArrayList<>(intAmount);

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

    private static int partition(ArrayList<Integer> arrayList, int bottomIndex, int endIndex) {
        int middleIndex = (bottomIndex + endIndex) / 2;
        int start = bottomIndex;
        int end = endIndex;
        int middleValue = arrayList.get(middleIndex);

        while (start <= end) {
            while (arrayList.get(start) < middleValue) {
                start++;
            }
            while (middleValue < arrayList.get(end)) {
                end--;
            }
            if (start <= end) {
                Collections.swap(arrayList, start, end);
                start++;
                end--;
            }
        }
        return --start;
    }

    static void quickSort(ArrayList<Integer> arrayList, int start, int end){
        int partition;

        if(start < end) {
            partition = partition(arrayList, start, end);
            quickSort(arrayList, start, partition);
            quickSort(arrayList,partition + 1, end);
        }
    }
}
