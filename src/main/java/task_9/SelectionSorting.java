package task_9;

public class SelectionSorting {

    /**
     * Selection sort implementation
     *
     * @param array the array to be sorted
     */
    public void selectionSort(int[] array) {
        for (int min = 0; min < array.length; min++) {
            int least = min;
            for (int i = min + 1; i < array.length; i++) {
                if (array[i] < array[least]) {
                    least = i;
                }
            }
            int temp = array[min];
            array[min] = array[least];
            array[least] = temp;
        }
    }
}
