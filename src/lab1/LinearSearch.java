package lab1;

/** Contains static methods for iterative and recursive linear search */
public class LinearSearch {

    /**
     * Performs a non-recursive linear search
     * @param arr array of elements that can be compared to each other
     * @param elem element to search for
     * @return index of the element, if found; -1 otherwise
     */
    public static int search(Comparable[] arr, Comparable elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(elem) == 0)
                return i;
        }
        return -1;
    }

    /**
     *
     * @param arr Array of elements
     * @param i Index in the array where we start searching. We search from i to n-1
     * @param elem Element to search for
     * @return index of the element in the array, if found. -1 if not found.
     */
    public static int recursiveSearch(Comparable[] arr, int i, Comparable elem) {
        if (i == arr.length)
            return -1;
        if (arr[i].compareTo(elem) == 0)
            return i;
        else
            return recursiveSearch(arr, i+1, elem);
    }
}
