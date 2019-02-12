package lab1_cs245;

/** Driver class for Linear and Binary Search */
public class SearchDriver {
    public static void main(String[] args) {
        // Create an array of Strings
        String[] arr = {"dog", "show", "cat", "elephant", "cot", "tin", "car", "app", "tick", "dim" };

        // Run linear search and print the result
        System.out.println("linear search is " + LinearSearch.search(arr,"car"));

        // FILL IN CODE

        // Run recursive linear search and print the result
        // FILL IN CODE

        // Compute the running time fot non-recursive and recursive linear search
        // Show TA on the paper


        String[] arrSorted = {"app", "bin", "cat", "cot", "crate", "dim", "dome", "elf", "nose", "sam", "seam"};
        // Run binary search and print the result
        System.out.println("search 1 is" + BinarySearch.search2(arrSorted,"cot"));
        System.out.println("search 2 is " + BinarySearch.search2(arrSorted,"cot"));
        System.out.println("search recursively is " + BinarySearch.searchRecursive(arrSorted,"cot", 0, 10));


        // Run recursive binary search and print the result
        // FILL IN CODE


        // Compute the running time fot non-recursive and recursive binary search
        // Write on paper and show the TA
    }
}
