public class OutOfPlaceQuickSort {
    public static void main (String[] args) {

        int[] array = {5, 12, 83, 6, 59, 31, 74, 22, 90, 47};

        int[] sortedArray = quickSort(array);

        for (int j : sortedArray) System.out.println(j);

    }

    public static int[] quickSort(int[] array) {

        // BASE CASE
        if (array.length <= 1) return array;

        int pivot = array[array.length - 1];

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] < pivot) leftCount++;
            else rightCount++;
        }

        int[] leftArray = new int[leftCount];
        int leftArrayPointer = 0;
        int[] rightArray = new int[rightCount];
        int rightArrayPointer = 0;

        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] < pivot) {
                leftArray[leftArrayPointer] = array[i];
                leftArrayPointer++;
            }
            else {
                rightArray[rightArrayPointer] = array[i];
                rightArrayPointer++;
            }
        }

        leftArray = quickSort(leftArray);
        rightArray = quickSort(rightArray);
        return concatenate(leftArray, rightArray, pivot);

    }

    public static int[] concatenate(int[] leftArray, int[] rightArray, int pivot) {
        int[] newArray = new int[leftArray.length + rightArray.length + 1];
        int counter = 0;

        for (int i : leftArray) newArray[counter++] = i;
        newArray[counter++] = pivot;
        for (int j : rightArray) newArray[counter++] = j;

        return newArray;
    }


}
