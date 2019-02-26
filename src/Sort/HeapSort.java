package Sort;

import Heap.MaxHeap;
import Tools.AlgorithmTools;

public class HeapSort {
    public static void sort(Comparable[] arr){
       int n=arr.length;
        MaxHeap<Comparable> heap=new MaxHeap(arr,arr.length);
        for (int i=n-1;i>0;i--){
            arr[i]=heap.extractMax();
        }
    }

    public static void main(String[] args) {

    }
}
