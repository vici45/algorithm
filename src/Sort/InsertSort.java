package Sort;

import Tools.AlgorithmTools;

public class InsertSort {
    private InsertSort(){}
    public static void sort(Comparable[] arr){
        int len=arr.length;
//        for (int i = 1; i < len; i++) {
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1])<0; j--) {
//                    AlgorithmTools.swap(arr,j,j-1);
//
//            }
//        }
        for (int i = 0; i < len; i++) {
            Comparable t=arr[i];
            int j=i;
            for(;j>0 && arr[j-1].compareTo(t)>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }

    public static void sort(Comparable[] arr,int l,int r){
        for (int i=l+1;i<=r;i++){
                Comparable t=arr[i];
                int j=i;
            for (;j>l&&arr[j-1].compareTo(t)>0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }
}
