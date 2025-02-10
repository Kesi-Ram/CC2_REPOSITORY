import java.util.Arrays;

public class RadixSort {
    static int counter = 0;

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            counter++;
            countSort(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            counter++;
            if (arr[i] > max) {
                counter++;
                max = arr[i];
            }
        }
        return max;
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            counter++;
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            counter++;
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            counter++;
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            counter++;
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
        System.out.println("Instruction Count: " + counter);
    }
}