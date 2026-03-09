public class InstructorSolution {
    public static void main (String[] args) {

        int[] arr = {10, 8, 4, 12, 3, 17, 9, 6};

        qSort(arr,0,arr.length-1);

        for(int i : arr) System.out.println(i);

    }

    public static void qSort(int[] arr, int l, int h) {

        // BASE CASE
        if(l >= h)
            return;

        int position = partition(arr,l,h);
        qSort(arr,l,position-1);
        qSort(arr,position+1,h);
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int[] left = new int[h-l];
        int[] right = new int[h-l];

        int n1 = 0;
        int n2 = 0;

        for(int i = 0; i < h - l - 1; i++)
            if(arr[l+i] < pivot)
                left[n1++] = arr[l+i];
            else
                right[n2++] = arr[l+i];

        for(int i = 0; i < n1; i++)
            arr[l+i] = left[i];

        arr[n1] = pivot;

        for(int i = 0; i < n2; i++)
            arr[l+i+n1+1] = right[i];

        return l+n1;

    }
}