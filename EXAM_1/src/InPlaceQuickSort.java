public class InPlaceQuickSort {
    public static void main (String[] args) {

        // 1. INITIALIZE ARRAY OF INTEGERS
        int[] array = {5, 12, 83, 6, 59, 31, 74, 22, 90, 47};

        // 2. QUICKSORT! PASSING LOW AND HIGH VALUES
        quickSort(array, 0, array.length - 1);

        for (int j : array) System.out.println(j);
    }

    public static void quickSort(int[] array, int low, int high) {

        // BASE CASE: if I run out of values to compare, then we're done
        if (low >= high) return;

        // PIVOT
        int pivot = array[high]; // Last element in the current partition serves as the pivot

        int i = low - 1; // Tracks the current right most position of a left array

        // SPLIT ORIGINAL ARRAY INTO TWO ARRAYS:
        // 1. ALL ITEMS LARGER THAN PIVOT
        // 2. ALL ITEMS SMALLER THAN PIVOT
        for(int j = low; j < high; j++) { // Walk through the current partition
            if (array[j] < pivot) { // If the current element belongs in the left zone
                i++;                // Expand the left zone boundary
                int temp = array[i]; // Temp storage of the left zone boundary value so it isn't lost
                array[i] = array[j]; // overwrite the boundary position with the smaller element
                array[j] = temp;     // put the displaced element into the position the smaller element just vacated
            }
        }

        // PIVOT PLACED BETWEEN THOSE ARRAYS
        i++;                         // expand the left zone boundary to make space for pivot
        int temp = array[i];         // temporarily store the element at the pivot's destination so it isn't lost
        array[i] = array[high];      // place the pivot into its final sorted position
        array[high] = temp;          // move the displaced element where the pivot was

        // REPEAT WITH THE RESULTING ARRAYS (RECURSIVE CALL)
        quickSort(array, low, i - 1); // recursive quicksort left
        quickSort(array, i + 1, high); // recursive quicksort right

    }
}