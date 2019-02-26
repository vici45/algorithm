package Sort;

import Tools.AlgorithmTools;

import java.util.Arrays;

public class InversionCount {
    private InversionCount(){}

    public static long sort(Comparable[] arr){
        int n=arr.length;
        return sort(arr,0,n-1);
    }

    public static long sort(Comparable[] arr,int l,int r){
        if (l>=r){
            return 0L;
        }
        int mid=(r-l)/2+l;
        long res1=sort(arr,l,mid);
        long res2=sort(arr,mid+1,r);
        return res1+res2+merge(arr,l,mid,r);
    }

    public static long merge(Comparable[] arr,int l,int mid,int r){
        Comparable[] aux=Arrays.copyOfRange(arr,l,r+1);
        int i=l,j=mid+1;
        long res=0L;
        for (int k=l;k<=r;k++){
            if (i>mid){
                arr[k]=aux[j-l];
                j++;
            }
            else if (j>r){
                arr[k]=aux[i-l];
                i++;
            }
            else if(aux[i-l].compareTo(aux[j-l])<=0){
                arr[k]=aux[i-l];
                i++;
            }else {
                arr[k]=aux[j-l];
                j++;
                res+=(long)(mid-i+1);
            }


        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr=AlgorithmTools.getRandomArray(5,0,10000);
        AlgorithmTools.printArray(arr,5);
        System.out.println(sort(arr));

        Integer[] arr2=AlgorithmTools.generateNearOrderArray(5,0);
        System.out.println(sort(arr2));

        Integer[] arr3={5,4,3,2,1};
        System.out.println(sort(arr3));

    }
}
