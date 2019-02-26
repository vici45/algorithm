package Heap;

import java.util.Arrays;

public class MaxHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity=capacity;
    }

    public MaxHeap(Comparable[] arr,int n){
        data= (T[]) new Comparable[n+1];
        count=n;
        capacity=n;
        for (int i=0;i<n;i++){
            data[i+1]= (T) arr[i];
        }
        for (int i=count/2;i>=1;i--){
            shiftUp(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(100);
        for (int i = 0; i < 60; i++) {
            heap.insert((int) (Math.random() * 250));
        }
        System.out.println(heap);
       while (!heap.isEmpty()){
           System.out.println(heap.extractMax());
       }
    }

    public void insert(T t) {
        assert count+1<=capacity;
        data[count + 1] = t;
        count++;
        shiftUp(count);

    }

    public T extractMax() {
        assert count>0;
        T t=data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return t;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (2*k<=count) {
            int j=2*k;
            if (j+1<=count&&data[j].compareTo(data[j+1])<0){
                j++;
            }
            if (data[k].compareTo(data[j])>0){
                break;
            }
            swap(k,j);
            k=j;
        }
    }

    private void swap(int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + Arrays.toString(data) +
                ", count=" + count +
                '}';
    }
}
