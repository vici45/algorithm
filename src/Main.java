import Tools.AlgorithmTools;

public class Main {

    public static void main(String[] args) {

        Integer[] arr=AlgorithmTools.getRandomArray(1000000,0,1000000);
//        Integer[] arr=AlgorithmTools.generateNearOrderArray(1000000,100);
        Integer[] arr2=arr.clone();
        Integer[] arr3=arr.clone();
        Integer[] arr4=arr.clone();
        Integer[] arr5=arr.clone();
        Integer[] arr6=arr.clone();
//        AlgorithmTools.testSort("Sort.SelectionSort",arr);
//        AlgorithmTools.testSort("Sort.InsertSort",arr2);
//        AlgorithmTools.testSort("Sort.BubbleSort",arr3);
//        AlgorithmTools.testSort("Sort.ShellSort",arr4);
        AlgorithmTools.testSort("Sort.MergeSort",arr4);
        AlgorithmTools.testSort("Sort.QuickSort",arr3);
        AlgorithmTools.testSort("Sort.QuickSort2",arr2);
        AlgorithmTools.testSort("Sort.HeapSort",arr);
        AlgorithmTools.testSort("Sort.HeapSort2",arr5);



//        AlgorithmTools.printArray(arr,arr.length);
//        AlgorithmTools.printArray(arr2,arr2.length);
//        AlgorithmTools.printArray(arr5,arr5.length);
    }
}
