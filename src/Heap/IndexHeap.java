package Heap;

import java.util.Arrays;

public class IndexHeap<T extends Comparable> {

    private T[] data;
    private int capacity;
    private int count;
    private int[] indexes;
    private int[] reverse;

    public IndexHeap(int capacity){
        data= (T[]) new Comparable[capacity+1];
        count=0;
        this.capacity=capacity;
        indexes=new int[capacity+1];
        reverse=new int[capacity+1];
    }

    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public void insert(int i,Comparable t){
        assert count+1<capacity;
        assert i+1>1&&i+1<capacity;

        i+=1;
        data[i]= (T) t;
        indexes[count+1]=i;
        reverse[i]=count+1;
        count++;
        shiftUp(i);

    }

    public T extractMax(){
        assert count>0;
        T t=data[indexes[1]];
        swapIndexes(1,count);
        reverse[indexes[count]]=0;
        count--;
        shiftDown(1);
        return t;
    }

    public int extracMaxIndex(){
        int ret=indexes[1]-1;
        swapIndexes(1,count);
        reverse[indexes[count]]=0;
        count--;
        shiftDown(1);
        return ret;
    }
    public T getMax(){
        return data[indexes[1]];
    }
    public int getMaxIndex(){
        return indexes[1]-1;
    }
    public T getT(int i){
        return data[i+1];
    }

    public void shiftUp(int k){
        while (k>1&&data[indexes[k/2]].compareTo(data[indexes[k]])<0){
            swapIndexes(k/2,k);
            k /=2;
        }
    }

    public void shiftDown(int k){
        while (2*k<=count){
            int j=2*k;
            if (j+1<=count&&data[indexes[j]].compareTo(data[indexes[j+1]])<=0){
                j++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]])>=0){
                break;
            }
                swapIndexes(k,j);
            k=j;
        }
    }

    public void swap(Comparable[] arr,int i,int j){
        Comparable t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public void swapIndexes(int i,int j){
        int t=indexes[i];
        indexes[i]=indexes[j];
        indexes[j]=t;

        reverse[indexes[i]]=i;
        reverse[indexes[j]]=j;
    }

    public void change(int i,T t){
        i+=1;
        data[i]=t;
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    public static void main(String[] args) {
        IndexHeap<Integer> heap=new IndexHeap(100);
        for (int i=0;i<5;i++){
            heap.insert(i,i+1);
        }
        heap.change(0,10);


    }

    @Override
    public String toString() {
        return "IndexHeap{" +
                "data=" + Arrays.toString(data) +
                ", capacity=" + capacity +
                ", count=" + count +
                ", indexes=" + Arrays.toString(indexes) +
                '}';
    }
}
