import java.util.Arrays;

public class BetterRecursiveMergeSort {

    public static void mergeSort(int[] array, int low, int high) {
        if (high - low <= 1) return;                        // BASE CASE: 1 or 0 elements

        int middle = (low + high) / 2;                      // FIND THE MIDDLE

        mergeSort(array, low, middle);                      // SORT LEFT HALF
        mergeSort(array, middle, high);                     // SORT RIGHT HALF
        merge(array, low, middle, high);                    // MERGE SORTED HALVES
    }

    public static void merge(int[] array, int low, int middle, int high) {
        int[] tempArray = Arrays.copyOfRange(array, low, high);     // TEMPORARY WORKING COPY
        int leftSize = middle - low;                        // SIZE OF LEFT SIDE OF ARRAY

        int i = 0;                                          // INDEX INTO LEFT HALF OF TEMP
        int j = middle - low;                               // INDEX INTO RIGHT HALF OF TEMP
        int k = low;                                        // INDEX INTO ORIGINAL ARRAY

        while (i < leftSize && j < tempArray.length) {
            if (tempArray[i] <= tempArray[j]) {
                array[k++] = tempArray[i++];
            } else {
                array[k++] = tempArray[j++];
            }
        }

        while (i < leftSize)        array[k++] = tempArray[i++];   // FLUSH REMAINING LEFT
        while (j < tempArray.length) array[k++] = tempArray[j++];  // FLUSH REMAINING RIGHT
    }

    public static void main(String[] args) {
        int[] unsortedArray = {4, 3, 2, 1};
        mergeSort(unsortedArray, 0, unsortedArray.length);
        System.out.println(Arrays.toString(unsortedArray));
    }
}