package lab1_cs245;

/** Contains iterative and recursive binary search methods. */
public class BinarySearch {

    /**
     * Performs a non-recursive binary search on a sorted array
     *
     * @param arr  sorted array of Strings
     * @param elem element to search for
     * @return index of the element, if found; -1 otherwise
     */
    public static int search1(String[] arr, String elem) {
        // Compute the middle index
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(low + " " + mid + " " + high);
            int val = arr[mid].compareTo(elem);
            if (val == 0)
                return mid;

            if (val > 0) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return -1;
    }

    /**
     * Performs a non-recursive binary search on a sorted array
     *
     * @param arr  sorted array of Strings
     * @param elem element to search for
     * @return index of the element, if found; -1 otherwise
     */
    public static int search2(String[] arr, String elem) {
        int low = 0;
        int high = arr.length-1;
        while(low + 1 < high){
            int mid = low + (high-low)/2;
            // System.out.println(low + " " + mid + " " + high);
            int val = arr[mid].compareTo(elem);
            if (val == 0) {
                return mid;
            }
            else if(val>0){
                high = mid;
            }
            else {
                low = mid;
            }
        }
        if (arr[low].compareTo(elem) == 0) {
            return low;
        }
        if (arr[high].compareTo(elem) == 0) {
            return high;
        }
        return -1;
    }



    /**
     * Recursive binary search on a sorted array.
     * Searches in the part of the array from low to high.
     *
     * @param arr  sorted array of strings
     * @param elem element to search for
     * @param low  index of the first element where to start the search
     * @param high index of the last element to consider.
     * @return index of the element in the array, if found. -1 otherwise.
     */
    public static int searchRecursive(String[] arr, String elem, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        System.out.println(low + " " + mid + " " + high);
        int val = arr[mid].compareTo(elem);
        if (val == 0)
            return mid;

        if (val > 0) {
            high = mid - 1;
        } else
            low = mid + 1;

        return searchRecursive(arr, elem, low, high);
    }
}
