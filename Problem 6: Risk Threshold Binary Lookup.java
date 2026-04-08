import java.util.*;

public class RiskThresholdSearch {
    public static int linearSearch(int[] arr, int target, int[] comparisons) {
        for (int i = 0; i < arr.length; i++) {
            comparisons[0]++;
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; 
    }

    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static Integer floor(int[] arr, int target) {
        int idx = lowerBound(arr, target);

        if (idx < arr.length && arr[idx] == target) {
            return arr[idx];
        }

        if (idx == 0) return null;

        return arr[idx - 1];
    }
    public static Integer ceiling(int[] arr, int target) {
        int idx = lowerBound(arr, target);

        if (idx == arr.length) return null;

        return arr[idx];
    }
    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100}; // sorted
        int[] linearComp = {0};

        int linearIndex = linearSearch(risks, 30, linearComp);

        int insertPos = lowerBound(risks, 30);

        Integer floorValue = floor(risks, 30);
        Integer ceilingValue = ceiling(risks, 30);
    }
}
