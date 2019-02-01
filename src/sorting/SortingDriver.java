package sorting;
import java.util.Arrays;

/** Driver class for SortingAlgorithms */
public class SortingDriver {
    public static void main(String[] args) {
        int[] arr = {15, 5, 1, 9, 2, 10, 12, 4};
        SortingAlgorithms.selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        /*
        int[] arr2 = {15, 5, 1, 9, 2, 10, 12, 4};
        SortingAlgorithms.insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));
        */
    }
}
