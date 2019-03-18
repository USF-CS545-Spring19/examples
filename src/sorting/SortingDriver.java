package sorting;
import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

/** Driver class for SortingAlgorithms */
public class SortingDriver {
    public static void main(String[] args) {
        int[] arr = {2, 80, 4, 1, 11, 15, 9, 8};
        //int[] arr = {764, 134, 721, 122, 893, 345, 413, 833, 407, 225, 638, 961};
        Scanner sc = new Scanner(System.in);
        System.out.println("Which sorting algorithm you'd like to sort it with? ");
        System.out.println("Type one of the following: selection, bubble, insertion, shell, merge, quickSort, radixSort");

        String input = sc.nextLine();
        if (!input.equals("radixSort"))
            System.out.println("Input array: " + Arrays.toString(arr));

        if (input.equals("selection"))
          SortingAlgorithms.selectionSort(arr);
        else if (input.equals("bubble"))
            SortingAlgorithms.bubbleSort(arr);
        else if (input.equals("insertion"))
            SortingAlgorithms.insertionSort(arr);
        else if (input.equals("shell"))
            SortingAlgorithms.shellSort(arr);
        else if (input.equals("merge"))
            SortingAlgorithms.mergeSort(arr);
        else if (input.equals("quickSort"))
            SortingAlgorithms.quickSort(arr);
        else if (input.equals("radixSort")) {
            //Elem[] records = {new Elem(711, "a"), new Elem(234, "c"), new Elem(603, "b"), new Elem(241, "d") };
            Elem[] records = {new Elem(764, ""), new Elem(134, null), new Elem(721, ""), new Elem(122, ""), new Elem(893,""), new Elem(345, null), new Elem(413, null), new Elem(833, null), new Elem(407, null), new Elem(225, null), new Elem(638, null), new Elem(961, null)};
            SortingAlgorithms.radixSort(records);
            for (int k =  0 ; k < records.length; k++) {
                System.out.print("(" + records[k].key() +  " " + records[k].data() + "); ");
            }
            System.out.println();
            return;
        }
        else {
            System.out.println("Not available.");
            return;
        }
        System.out.print("After sorting with " + input  + ": ");
        System.out.println(Arrays.toString(arr));

    }
}
