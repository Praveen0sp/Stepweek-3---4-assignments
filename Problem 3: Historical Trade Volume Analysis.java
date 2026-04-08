import java.util.*;

class Trade {
    String id;
    int volume;
    public Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }
}
public class TradeAnalysis {
    public static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(Trade[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }
    public static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume; // Lomuto pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].volume > pivot) { // DESC
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static Trade[] mergeTwoSorted(Trade[] a, Trade[] b) {
        int n1 = a.length, n2 = b.length;
        Trade[] result = new Trade[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < n1)
            result[k++] = a[i++];
        while (j < n2)
            result[k++] = b[j++];
        return result;
    }
    public static int totalVolume(Trade[] arr) {
        int sum = 0;

        for (Trade t : arr) {
            sum += t.volume;
        }

        return sum;
    }
    public static void main(String[] args) {

        Trade[] trades = {
            new Trade("trade3", 500),
            new Trade("trade1", 100),
            new Trade("trade2", 300)
        };
        Trade[] mergeArr = trades.clone();
        Trade[] quickArr = trades.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        quickSort(quickArr, 0, quickArr.length - 1);
        Trade[] morning = {
            new Trade("m1", 100),
            new Trade("m2", 200)
        };
        Trade[] afternoon = {
            new Trade("a1", 300),
            new Trade("a2", 400)
        };

        Trade[] merged = mergeTwoSorted(morning, afternoon);
        int total = totalVolume(merged);
    }
}
