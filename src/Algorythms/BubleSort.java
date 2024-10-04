package Algorythms;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {

        int arr[] = {1, 4, 2, 6, 5, 3, -10, 5, 4,  5, 8, 98, 76, 54};

        getSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void getSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
