import java.util.Arrays;

public class RecursiveMergeSort {
    public static int[] mergeSort(int[] array) {
        // BASE CASE
        if (array.length <= 1) return array;

        // IDENTIFY MIDDLE OF INCOMING ARRAY
        int middle = array.length / 2;

        // SPLIT ARRAY IN HALF
        int[] leftHalf = Arrays.copyOfRange(array, 0, middle);
        int[] rightHalf = Arrays.copyOfRange(array, middle, array.length);

        // RECURSIVE CALL
        int[] sortedLeft = mergeSort(leftHalf);
        int[] sortedRight = mergeSort(rightHalf);

        return merge(sortedLeft, sortedRight);


    }

    public static int[] merge (int[] left, int[] right) {

        // SAME CODE FROM PREVIOUS PROBLEM

        int[] newArray = new int[left.length + right.length];
        int i = 0, j = 0;

        while(i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                newArray[i + j] = left[i++];
            }
            else {
                newArray[i + j] = right[j++];
            }

        }

        while (i < left.length) {
            newArray[i + j] = left[i];
            i++;
        }
        while (j < right.length) {
            newArray[i + j] = right[j];
            j++;
        }

        return(newArray);

    }

    public static void main (String[] args) {
        int[] unsortedArray = {3, 7, 6, -10, 15, 23, 55, -13};
        System.out.println(Arrays.toString(mergeSort(unsortedArray)));

    }

}