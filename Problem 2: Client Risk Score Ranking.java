import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;
    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }
}
public class RiskRankingSystem {
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 &&
                  (arr[j].riskScore < key.riskScore ||
                  (arr[j].riskScore == key.riskScore &&
                   arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
    public static List<Client> getTopK(Client[] arr, int k) {
        List<Client> result = new ArrayList<>();

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            result.add(arr[i]);
        }

        return result;
    }
    public static void main(String[] args) {

        Client[] clients = {
            new Client("clientC", 80, 5000),
            new Client("clientA", 20, 2000),
            new Client("clientB", 50, 3000)
        };

        Client[] bubbleArr = clients.clone();
        Client[] insertionArr = clients.clone();

        bubbleSort(bubbleArr);
        insertionSort(insertionArr);

        List<Client> topClients = getTopK(insertionArr, 10);
    }
}
