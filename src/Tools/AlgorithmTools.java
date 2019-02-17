package Tools;

import java.lang.reflect.Method;

public class AlgorithmTools {
    //生成从[rangeL,rangeR]长度为n的随机数组
    public static Integer[] getRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }
    public static Integer[] generateNearOrderArray(int n,int swapNumber){
        Integer[] arr=new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i;
        }
        for (int i = 0; i < swapNumber; i++) {
            int x= (int) (Math.random()*n);
            int y= (int) (Math.random()*n);
            swap(arr,x,y);
        }

        return arr;
    }
    //打印一个数组的前n位
    public static void printArray(Object[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //将某一个数组的第i个和第j个进行交换
    public static void swap(Object[] arr,int i,int j){
        Object t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static boolean isSorted(Comparable[] arr){
        int len=arr.length;
        for (int i = 0; i < len-1; i++) {
            if (arr[i].compareTo(arr[i+1])>0){
                return false;
            }
        }
        return true;
    }

    public static void testSort(String sortClassName,Comparable[] arr){
        try {

            Class sortClass=Class.forName(sortClassName);
            Method sortMethod=sortClass.getMethod("sort",new Class[]{(Comparable[].class)});
            Object[] params=new Object[]{arr};
            long startTime=System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime=System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName()+":"+(endTime-startTime)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
