package Sort;

import Tools.AlgorithmTools;

public class QuickSort {

    private QuickSort(){}
    //对arr[0,n]进行快速排序
    public static void sort(Comparable[] arr){
        int n=arr.length;
        sort(arr,0,n-1);
        }
    private static void sort(Comparable[] arr,int l,int r){
        if (l>=r){
            return;
        }
//        if (r-l<=15){
//            InsertSort.sort(arr,l,r);
//            return;
//        }
        int p=partition2(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);


    }
    private  static int partition(Comparable[] arr,int l,int r){
        int randomIndex= (int) (Math.random()*(r-l+1)+l);
        AlgorithmTools.swap(arr,l,randomIndex);
        Comparable t=arr[l];
        int j=l;
        for (int i=l+1;i<=r;i++){
            if (arr[i].compareTo(t)<0){
                j++;
                AlgorithmTools.swap(arr,i,j);
            }
        }
        AlgorithmTools.swap(arr,l,j);
        return j;
    }

    private static int partition2(Comparable[] arr,int l,int r){
        int randomIndex= (int) (Math.random()*(r-l+1)+l);
        AlgorithmTools.swap(arr,l,randomIndex);
        Comparable t=arr[l];
        int i=l+1;
        int j=r;
        while (true){
            while (i<=r&&arr[i].compareTo(t)<0){
                i++;
            }
            while (j>=l+1&&arr[j].compareTo(t)>0){
                j--;
            }
            if (i>j){
                break;
            }
            AlgorithmTools.swap(arr,i,j);
            i++;
            j--;
        }
        AlgorithmTools.swap(arr,l,j);
        return j;
    }
}
