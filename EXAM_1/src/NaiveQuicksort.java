public class NaiveQuicksort {
    public static void main (String[] args) {

        int[] array = {5, 12, 83, 6, 59, 31, 74, 22, 90, 47};

        quickSort(array, 0, array.length - 1);

        for (int j : array) System.out.println(j);

    }

    public static int partition (int[] array, int low, int high) {

        int pivot = array[high];

        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        return i;

    }

    public static void quickSort (int[] array, int low, int high) {

        // BASE CASE
        if (low >= high) return;

        // HELPER CALL
        int i = partition(array, low, high);

        // RECURSIVE CASE
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);

    }
}
