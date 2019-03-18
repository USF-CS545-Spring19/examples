package lab1_cs245;

/** Contains static methods for iterative and recursive linear search */
public class LinearSearch {

    /**
     * Performs a non-recursive linear search
     * @param arr array of Strings
     * @param elem string to search for
     * @return index of the element, if found; -1 otherwise
     */
    public static int search(String[] arr, String elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(elem) == 0)
                return i;
        }
        return -1;
    }


    /**
     *
     * @param arr Array of Strings
     * @param i Index in the array where we start searching. We search from i to n-1
     * @param elem string to search for
     * @return index of the element in the array, if found. -1 if not found.
     */
    public static int recursiveSearch(String[] arr, int i, String elem) {
        if (i == arr.length)
            return -1;
        if (arr[i].compareTo(elem) == 0)
            return i;
        else
            return recursiveSearch(arr, i+1, elem);
    }
}
