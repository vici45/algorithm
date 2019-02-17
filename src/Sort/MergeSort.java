package Sort;

import Tools.AlgorithmTools;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

    }

    private static void mergeSort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }
        int mid = (r + l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        /*对近乎有序的数组有较好的优化效果，对纯随机数组可能会影响性能*/
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int m, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
