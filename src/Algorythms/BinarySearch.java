package Algorythms;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(binarySearch(arr, 10000-1));

    }

    public static int binarySearch(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        int middle;
        while(start <= end){
            middle = start + (end - start) / 2;
            if (arr[middle] == target){
                return middle;
            }
            else if (arr[middle] > target) {
                end = middle - 1;
            }
            else
                start = middle + 1;
        }
        return -1;
    }
}
