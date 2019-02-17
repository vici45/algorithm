package Sort;

import Tools.AlgorithmTools;

public class BubbleSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
//        for (int i = n; i > 0; i--) {
//            for (int j = 1; j <i; j++) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    AlgorithmTools.swap(arr, j, j - 1);
//                }
//            }
//        }
//
//        boolean swapped;
//        do{
//            swapped=false;
//            for (int i=1;i<n;i++){
//                if (arr[i-1].compareTo(arr[i])>0){
//                    AlgorithmTools.swap(arr,i-1,i);
//                    swapped=true;
//                }
//            }
//            n--;
//
//        }while (swapped);
/**
 * 改进方法:记录最后一次交换的位置，下一次循环只循环到上次最后交换的位置之前
 */
        for (int i=n;i>0;i--){
            int lastIndex=0;
            for (int j=1;j<n;j++){
                if (arr[j-1].compareTo(arr[j])>0){
                    AlgorithmTools.swap(arr,j,j-1);
                    lastIndex=j-1;
                }
            }
            n=lastIndex;

        }
    }
}
