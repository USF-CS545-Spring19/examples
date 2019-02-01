package sorting;

/**
 * A class that contains static methods for sorting an array of integers using
 * various sorts */
public class SortingAlgorithms {

    /** Sort a given array using selection sort.
     *
     * @param arr array of integers
     */
    public static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int indexOfMin = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[indexOfMin])
                        indexOfMin = j;
                }
                // swap
                int tmp = arr[indexOfMin];
                arr[indexOfMin] = arr[i];
                arr[i] = tmp;
            }
        }


    /**
     * Sort a given array using bubble sort. At each pass, we "bubble up" the
     * current smallest element
     *
     * @param arr array of integers
     */
    public static void bubbleSort(int[] arr) {
        for (int pos = 0; pos < arr.length - 1; pos++) {
            for (int j = arr.length - 1; j > pos; j--) {
                if (arr[j] < arr[j - 1]) {
                    // swap them
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }

    }

    /** Sort a given array using insertion sort
     *
     * @param arr array of integers
     */
    public static void insertionSort(int[] arr) {
        int curr;
        int j;
        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j]; // shift elems to the right
                j--;
            }
            arr[j + 1] = curr;

        }
    }
    
    /** Print a given array of integers */
    public static void print(int[] arr) {
        for (int elem : arr)
            System.out.print(elem + " ");
        System.out.println();
    }

}
