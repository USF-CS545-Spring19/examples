package sorting;

import java.util.Arrays;

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
            print(arr);
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


    /**
     * Sort a given array using shell sort and n/2, n/4, n/8 etc increments. The
     * code is modified from the code of Prof. Galles.
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int increment, offset;
        for (increment = n / 2; increment > 0; increment = increment / 2) {
            for (offset = 0; offset < increment; offset++)
                insertionSort(arr, offset, increment);
            for (int k = 0; k < arr.length; k++)
                System.out.print(arr[k] + " ");
            System.out.println();
        }
    }

    /**
     * Another version of the insertion sort that sorts a sublist of a given
     * list. Used in Shell Sort. Takes an offset (the first element of the list
     * will be at arr[offset]) and increment (the gap between the elements of
     * the list)
     */
    public static void insertionSort(int[] arr, int offset, int increment) {
        int i, j;
        int n = arr.length;
        for (i = offset + increment; i < n; i = i + increment) {
            int curr = arr[i];
            j = i - increment;
            while (j >= 0 && arr[j] > curr) {
                arr[j + increment] = arr[j];
                j = j - increment;
            }
            arr[j + increment] = curr;
        }
    }

    /** public method for mergeSort - called from outside of the class
     *
     * @param arr input array of integers
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    /**
     * A private mergeSort method - takes an array, a temporary array, and the
     * indices that specify what part of the list we are working with (we need
     * to sort the part from low to high)
     *
     * @param arr array of integers
     * @param temp temporary array used in the algorithm for merging
     * @param low index of the first element of the part of the array we need to sort
     * @param high index of the last element of the part of the array we need to sort
     */
    private static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return;
        // divide in half
        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);

        merge(arr, temp, low, mid, high); // merge two sorted halves into one
        // sorted list
        print(arr);

    }

    /**
     * Merge two sorted sublists together, one that goes from low to mid another
     * goes from mid+1 to high. Uses a temporary array.
     *
     * @param arr array of integers
     * @param temp temporary array
     * @param low start index in sub-array 1
     * @param mid  end index in sub-array 1
     * @param high end index in sub-array 2
     */
    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int k = low;
        int i = low;
        int j = mid + 1;
        while (k <= high) {
            if (i > mid) {// ran out of elements in the i sublist
                temp[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {// ran out of elements in the j sublist
                temp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] < arr[j]) { // place arr[i] in temp, move i
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        // copy the result from temp back to arr
        for (k = low; k <= high; k++)
            arr[k] = temp[k];
    }


    /**
     * Quick sort - public method
     * @param arr input array if integers
     */
    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Quick sort implementation. Uses partition as a helper method.
     * @param arr array of integers
     * @param low index of the first element of the sub-array to sort
     * @param high index of the last element of the sub-array to sort
     */
    private static void quickSort(int arr[], int low, int high) {
        int indexOfPivot;
        if (low <= high) {
            indexOfPivot = partition(arr, low, high); // the index of pivot element
            System.out.println("Pivot: " + arr[indexOfPivot]);
            print(arr);
            quickSort(arr, low, indexOfPivot - 1);
            quickSort(arr, indexOfPivot + 1, high);
        }
    }

    /**
     * Helper method for the quick sort. Rearranges the array so that it
     * first has elements < pivot, then pivot, and then elements >= pivot.
     * Chooses the middle element as the pivot.
     * @param arr array
     * @param low index of the first element of the sub-array
     * @param high index of the last element of the sub-array
     * @return index of the pivot after partition
     */
    public static int partition(int arr[], int low, int high) {
        int mid = (low + high) / 2;
        int pivotElem = arr[mid];

        // Swap pivot with the element at the last index
        int tmp = arr[high];
        arr[high] = pivotElem;
        arr[mid] = tmp;

        int i = low;
        int j = high - 1;
        while (i <= j) {
            while ( (arr[i] < pivotElem))
                i++;

            while ((j >= low) && (arr[j] >= pivotElem))
                j--;

            if (i > j)
                break;
            else { // swap elements at indices i and j
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        } // while
        if (i > j) {
            // swap arr[i] and last elem
            tmp = arr[i];
            arr[i] = arr[high];
            arr[high] = tmp;
        }
        return i;
    }


    /**
     * Sorts an array of records using Radix Sort.
     * Assumes the number of digits in each key is the same.
     * @param arr array of elements of type Elem.
     */
    public static void radixSort(Elem[] arr) {
        // First, compute the number of digits in each key
        // Since we assume they all have the same # of digits,
        // it's enough to compute the # of digits in the first key
        if (arr.length == 0)
            return;
        int ndigits = (int) (Math.log10(arr[0].key()) + 1);

        Elem[] temp = new Elem[arr.length];

        int[] count = new int[10]; // count array for counting sort
        for (int i = 0, place = 1; i < ndigits; i++, place *= 10) {
            // place will be 1, then 10, then 100, then 1000, etc.
            // initialize count array
            for (int j = 0; j < 10; j++)
                count[j] = 0;
            // iterate over arr and fill out count array
            for (int j = 0; j < arr.length; j++) {
                int k = (arr[j].key() / place) % 10;
                count[k]++;
            }

            for (int j = 1; j < 10; j++) // modified count array
                count[j] += count[j - 1];

            // result will be in temp
            for (int j = arr.length - 1; j >= 0; j--)
                temp[--count[(arr[j].key() / place) % 10]] = arr[j];

            // copy the result back into arr
            for (int j = 0; j < arr.length; j++) {
                arr[j] = temp[j];
                System.out.print(arr[j].key() + " " );
            }
            System.out.println();

        }
    }

    /** Print a given array of integers
     *
     * @param arr array of integers to print
     */
    public static void print(int[] arr) {
        for (int elem : arr)
            System.out.print(elem + " ");
        System.out.println();
    }

}
