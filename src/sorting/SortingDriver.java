package sorting;
import java.util.Arrays;
import java.util.Scanner;

/** Driver class for SortingAlgorithms */
public class SortingDriver {
    public static void main(String[] args) {
        //int[] arr = {15, 5, 1, 9, 2, 10, 12, 4};
        int[] arr = {17, 10, 15, 13, 4, 12, 7, 9, 16, 8, 5, 14, 3 };
        System.out.println("Input array: " + Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("Which sorting algorithm you'd like to sort it with? ");
        System.out.println("Type one of the following: selection, bubble, insertion, shell, merge, quickSort");

        String input = sc.nextLine();
        if (input.equals("selection"))
          SortingAlgorithms.selectionSort(arr);
        else if (input.equals("bubble"))
            SortingAlgorithms.bubbleSort(arr);
        else if (input.equals("insertion"))
            SortingAlgorithms.insertionSort(arr);
        else if (input.equals("merge"))
            SortingAlgorithms.mergeSort(arr);
        else if (input.equals("quickSort"))
            SortingAlgorithms.quickSort(arr);
        else {
            System.out.println("Not available.");
            return;
        }
        System.out.print("After sorting with " + input  + ": ");
        System.out.println(Arrays.toString(arr));

    }
}
