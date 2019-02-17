package Sort;

import Tools.AlgorithmTools;

public class ShellSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        n = n / 2;
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = i+n; j < arr.length; j += n) {
                    for (int l = j ; l - n >= 0 && arr[l].compareTo(arr[l - n]) < 0; l -=n) {
                        AlgorithmTools.swap(arr,l,l-n);
                    }
                }
            }
            n=n/2;
        }
    }
}
