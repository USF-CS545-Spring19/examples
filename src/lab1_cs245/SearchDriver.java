package lab1;

/** Driver class for Linear and Binary Search */
public class SearchDriver {
    public static void main(String[] args) {
        // Create an array of Comparable-s - try it with Strings first, then
        // references to objects of some custom class like Student
        Comparable [] arr = {"dog", "show", "cat", "elephant", "cot", "tin", "car", "app", "tick", "dim" };

        // Run linear search and print the result
        // FILL IN CODE
        System.out.println("linear search is " + LinearSearch.search(arr,"car"));

        // Run recursive linear search and print the result
        // FILL IN CODE

        // Compute the running time fot non-recursive and recursive linear search
        // Show TA on the paper


        Comparable [] arrSorted = {"app", "bin", "cat", "cot", "crate", "dim", "dome", "elf", "nose", "sam", "seam"};
        // Run binary search and print the result
        // FILL IN CODE
        System.out.println("search 1 is" + BinarySearch.search2(arrSorted,"app"));
        System.out.println("search 2 is " + BinarySearch.search2(arrSorted,"app"));
        System.out.println("search recursively is " + BinarySearch.searchRecursive(arrSorted,"app", 0, 10));

        // Run recursive binary search and print the result
        // FILL IN CODE


        // Compute the running time fot non-recursive and recursive binary search
        // Write on paper and show the TA
    }
}
