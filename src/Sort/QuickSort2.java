package Sort;

import Tools.AlgorithmTools;

public class QuickSort2 {

    public static void main(String[] args) {
        int n=1000000;
        Integer[] arr=AlgorithmTools.getRandomArray(n,0,n);
        AlgorithmTools.testSort("Sort.QuickSort2",arr);
    }
    private QuickSort2(){}
    public static void sort(Comparable[] arr){
        int n=arr.length;
        sort1(arr,0,n-1);
    }

    private static void sort1(Comparable[] arr,int l,int r){
        if (r-l<=15){
            InsertSort.sort(arr,l,r);
            return;
        }
        AlgorithmTools.swap(arr,l, (int) (Math.random()*(r-l+1)+l));

        Comparable t=arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while (i<gt){
            if (arr[i].compareTo(t)>0){
                AlgorithmTools.swap(arr,i,gt-1);
                gt--;
            }
            else if (arr[i].compareTo(t)==0){
                i++;
            }
            else {
                AlgorithmTools.swap(arr, i, lt+1);
                lt++;
                i++;
            }
        }
        AlgorithmTools.swap(arr,l,lt);
        sort1(arr,l,lt-1);
        sort1(arr,gt,r);
    }
}
