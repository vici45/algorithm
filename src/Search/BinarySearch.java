package Search;

public class BinarySearch {

    public static int search(Comparable[] arr,Comparable target){
        int l=0,r=arr.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (arr[mid].compareTo(target)==0){
                return mid;
            }
            else if (arr[mid].compareTo(target)>0){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Comparable[] arr=new Comparable[1000];
        for (int i=0;i<1000;i++){
            arr[i]=i;
        }
        System.out.println(search(arr,111,0,111));
    }

    public static int search(Comparable[] arr,Comparable target,int l,int r){
        if (l>r){
            return -1;
        }
        int mid=(r-l)/2+l;
        if (arr[mid].compareTo(target)==0){
            return mid;
        }else if(arr[mid].compareTo(target)>0){
            return search(arr,target,l,mid-1);
        }else {
            return search(arr,target,mid+1,r);
        }
    }
}
