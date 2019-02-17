package Sort;

import Tools.AlgorithmTools;

public class SelectionSort {
    private SelectionSort(){}


    public static void sort(Comparable[] arr){
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex=i;
            for (int j = i+1; j < len; j++) {
                if (arr[minIndex].compareTo(arr[j])>0){
                    AlgorithmTools.swap(arr,minIndex,j);
                }
            }
        }
    }
}
