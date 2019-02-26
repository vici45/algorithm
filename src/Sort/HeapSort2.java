package Sort;

import java.util.Date;


public class HeapSort2 {
    private HeapSort2(){}

    public static void sort(Comparable[] arr){
        int n=arr.length;

        for (int i=(n-1-1)/2;i>=0;i--){
            shiftDown2(arr,n,i);
        }
        for (int i=n-1;i>0;i--){
            swap(arr,0,i);
            shiftDown2(arr,i,0);
        }
    }

    private static void shiftDown(Comparable[] arr,int n,int k) {
        while (2*k+1<n){
            int j=2*k+1;
            if (j+1<n&&arr[j].compareTo(arr[j+1])<0){
                j++;
            }
            if (arr[k].compareTo(arr[j])>=0){
                    break;
            }
            swap(arr,k,j);
            k=j;
        }
    }

    private static void shiftDown2(Comparable[] arr,int n,int k){
        Comparable e=arr[k];
        while (2*k+1<n){
            int j=2*k+1;
            if (j+1<n&&arr[j].compareTo(arr[j+1])<0){
                j++;
            }
            if (e.compareTo(arr[j])>=0){
                break;
            }
            arr[k]=arr[j];
            k=j;
        }
        arr[k]=e;
    }

    private static void swap(Comparable[] arr,int i,int j){
        Comparable t=arr[j];
        arr[j]=arr[i];
        arr[i]=t;
    }
}
