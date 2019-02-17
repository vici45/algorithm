package Sort;

import Tools.AlgorithmTools;

public class QuickSort {
    //对arr[0,n]进行快速排序
    public static void sort(Comparable[] arr){
        int n=arr.length;
        sort(arr,0,n-1);
        }
    private static void sort(Comparable[] arr,int l,int r){
//        if (l>=r){
//            return;
//        }
        if (r-l<=15){
            InsertSort.sort(arr,l,r);
            return;
        }
        int p=partition(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);


    }
    private  static int partition(Comparable[] arr,int l,int r){
        Comparable t=arr[l];
        int j=l;
        for (int i=l+1;i<=r;i++){
            if (t.compareTo(arr[i])>0){
               AlgorithmTools.swap(arr,i,j+1);
               j++;
            }
        }
        AlgorithmTools.swap(arr,l,j);
        return j;
    }
}
