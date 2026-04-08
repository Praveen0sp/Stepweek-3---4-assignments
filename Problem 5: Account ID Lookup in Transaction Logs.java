import java.util.*;

class AccountSearch {
    public static int linearFirst(String[] arr, String target, int[] comparisons) {
        for (int i = 0; i < arr.length; i++) {
            comparisons[0]++;
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static int linearLast(String[] arr, String target, int[] comparisons) {
        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons[0]++;
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(String[] arr, String target, int[] comparisons) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons[0]++;
            int cmp = arr[mid].compareTo(target);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;

        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }
    private static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    private static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};
        int[] linearComp = {0};
        int[] binaryComp = {0};
        int firstIndex = linearFirst(logs, "accB", linearComp);
        int lastIndex = linearLast(logs, "accB", linearComp);
        int binaryIndex = binarySearch(logs, "accB", binaryComp);
        int count = countOccurrences(logs, "accB");
    }
}
