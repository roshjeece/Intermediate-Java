import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Create my array:
        int[] unsortedArray = {10, 5, 7, 12, 3};

        for(int i = 0; i < unsortedArray.length - 1; i++) {
            for(int j = 0; j < unsortedArray.length - 1 - i; j++) {
                if (unsortedArray[j] > unsortedArray[j+1]) {
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j+1];
                    unsortedArray[j+1] = temp;
                }
            }
        }

        System.out.print(Arrays.toString(unsortedArray));
        }
    }

    /*
    Journal Entry: Intermediate Java - Bubble Sort
    I started to bridge data structures and algorithmic thinking by approaching the bubble
    sort problem. This algorithm runs in O(n^2) (or is it O(nlogn)). It carries this bigO value
    because you must compare each unsorted datum against its neighbors once for every pass over
    the data set. Bubble Sort is a simple algorithm that's easy to code but inefficient overall.
    First, you create the array with an unsorted list of numbers.
    Second, you need a loop that will pass over the array n times (n representing the number of
    values in that array --> length. This loop will only hold another loop.
    Third, you need a loop that will iterate through the comparison of neighbor datums (one less
    than the total length of the array).
    Within the nested loop, you will see if one number (j) is bigger than the number
    on the right (j+1). If it is bigger, assign the left(j) number to a temp variable. Then, shift the smaller
    number on the right(j+1) to the left position (j). Assign the temp variable to (j+1).
    Then all of this repeats as the "largest" numbers "bubble" to the top.
     */