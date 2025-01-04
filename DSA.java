import java.util.Arrays;

public class DSA {
    public static void main(String[] args) {
        int[] arr={16,21,32,44,56,66,69,78,86};
        int[] arr2={16,76,92,14,24,66,9,71,26};
        int target=16;
        int[] ans=linearsearch(arr,target);
        long starttime=System.nanoTime();
        System.out.println("output linear search: "+Arrays.toString(ans) + " in "+(System.nanoTime()-starttime)+"ns");
        starttime=System.nanoTime();
        int[] ans2=binarysearch(arr,target);
        System.out.println("output binary search: "+Arrays.toString(ans2) + " in "+(System.nanoTime()-starttime)+"ns");
        starttime=System.nanoTime();
        int ans3=largestsearch(arr2);
        System.out.println("output largest search: "+ans3+ " in "+(System.nanoTime()-starttime)+"ns");
        starttime=System.nanoTime();
        int ans4=smallestsearch(arr2);
        System.out.println("output smallest search: "+ans4+ " in "+(System.nanoTime()-starttime)+"ns");
        starttime=System.nanoTime();
        int ans5=secondlargestsearch(arr2);
        System.out.println("output second largest search: "+ans5+ " in "+(System.nanoTime()-starttime)+"ns");
        
    }
    public  static int largestsearch(int[] arr){
        int start=0;
        int largest=Integer.MIN_VALUE;
        while(start<arr.length){
            if(arr[start]>=largest){
                largest=arr[start];
            }
            start++;
        }
        return largest;
    }
    public  static int smallestsearch(int[] arr){
        int start=0;
        int smallest=Integer.MAX_VALUE;
        while(start<arr.length){
            if(arr[start]<=smallest){
                smallest=arr[start];
            }
            start++;
        }
        return smallest;
    }
    public  static int[] linearsearch(int[] arr,int target){
        int start=0;
        while(start<arr.length){
            if(arr[start]==target){
                return new int[]{start};
            }
            start++;
        }
        return null;
    }
    public static int[] binarysearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return new int[]{mid};  
            }
            else if (arr[mid] > target) {
                end = mid - 1;  
            } else {
                start = mid + 1;  
            }
        }
        
        return null;
    }
    //find second largest
    public  static int secondlargestsearch(int[] arr){
        int start=0;
        int largest=Integer.MIN_VALUE;
        int secondlargest=Integer.MIN_VALUE;
        while(start<arr.length){
            if(arr[start]>=largest){
                secondlargest= largest;
                largest=arr[start];
                
            }else if (arr[start]<largest && arr[start] >=secondlargest){
                secondlargest=arr[start];
            }
            start++;
        }
        return secondlargest;
    }
    
}
