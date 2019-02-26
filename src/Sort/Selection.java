package Sort;

import Tools.AlgorithmTools;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class Selection {
    private Selection(){}

    public static Comparable get(Comparable[] arr,int n){
        int len=arr.length-1;
        return get(arr,0,len,n);
    }

    private static Comparable get (Comparable[] arr,int l,int r,int n){
       if (l==r){
           return arr[l];
       }
       int p=partition(arr,l,r);
       if (n==p+1){
           return arr[p];
       }else if (n<p+1){
           return get(arr,l,p-1,n);
       }else {
           return get(arr,p+1,r,n);
       }

    }

    private static int partition(Comparable[] arr,int l,int r){
        AlgorithmTools.swap(arr,l, (int) (Math.random()*(r-l+1)+l));
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

    public static void main(String[] args) {
        Integer[] arr=AlgorithmTools.getRandomArray(20,0,1000);
        AlgorithmTools.printArray(arr,arr.length);
        System.out.println(get(arr,1));
        AlgorithmTools.printArray(arr,arr.length);

    }
}
