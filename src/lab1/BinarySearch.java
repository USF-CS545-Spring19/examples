package lab1;

/** Contains iterative and recursive binary search methods. */
public class BinarySearch {

    /**
     * Performs a non-recursive binary search
     *
     * @param arr  array of elements that can be compared to each other
     * @param elem element to search for
     * @return index of the element, if found; -1 otherwise
     */
    public static int search1(Comparable[] arr, Comparable elem) {
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
     * Performs a non-recursive binary search
     *
     * @param arr  array of elements that can be compared to each other
     * @param elem element to search for
     * @return index of the element, if found; -1 otherwise
     */
    public static int search2(Comparable[] arr, Comparable elem) {
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
     * Recursive binary search. Searches in the part of the array from low to high.
     *
     * @param arr  array of elements
     * @param elem element to search for
     * @param low  index of the first element where to start the search
     * @param high index of the last element to consider.
     * @return index of the element in the array, if found. -1 otherwise.
     */
    public static int searchRecursive(Comparable[] arr, Comparable elem, int low, int high) {
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

    /**
     * Leetcode 278
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * You are given an API bool isBadVersion(version)which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     * Example:
     * Given n = 5, and version = 4 is the first bad version.
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * Then 4 is the first bad version. 
     *
     */

    //Recursive
//    public int firstBadVersion(int n) {
//
//        if(n==0) {
//            return 0;
//        }
//
//        return helper(n,1,n);
//    }
//
//
//    public int helper(int n, int start, int end) {
//
//        if(start>=end) {
//            return start;
//        }
//        int middle = start+(end-start)/2;
//
//        if(isBadVersion(middle)) {
//            return helper(n,start,middle);
//        } else {
//            return helper(n,middle+1,end);
//
//        }
//    }

    //Non-recursive

//    public int firstBadVersion(int n) {
//        int low = 1;
//        int high = n;
//        int mid = 0;
//        while(low + 1 < high){
//            mid = low + (high - low)/2;
//            if(isBadVersion(mid)){
//                high = mid;
//            }else{
//                low = mid;
//            }
//        }
//        if(isBadVersion(low))
//            return low;
//        return high;
//
//    }

}
