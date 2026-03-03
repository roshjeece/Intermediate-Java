import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        // create two sorted arrays
        int[] arr1 = {2, 10, 15, 17, 21};
        int[] arr2 = {6, 8, 19};
        int[] newArray = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;


        // in O(n) time, combine these into new array

        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                newArray[i + j] = arr1[i++];
            }
            else {
                newArray[i + j] = arr2[j++];
            }

        }

        /* This could also be written using a ternary operator (compact if/else statement):

           while (i < arr1.length && j < arr2.length) {
                newArray[i + j] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];

                // ? acts as if/else statement. the comparison is in the 'if.' else, arr2[j++].

         */

        while (i < arr1.length) {
            newArray[i + j] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            newArray[i + j] = arr2[j];
            j++;
        }
        // Need to "drain" the remaining array



        System.out.println(Arrays.toString(newArray));

    }

}


/*
* 1. Point to arr1[0] and arr2[0], then compare
* 2. assign arr1[0] to newArray [0]
* 3. compare arr1[1] to arr2[0]
* 4. assign arr2[0] to newArray[1]
*
*
* */

// newArray pointer could be i + j