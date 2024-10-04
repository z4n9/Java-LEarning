package Algorythms;
import java.util.Scanner;

public class LinarSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = {1, 2, 3, 4, -5, 6, 7, 12};
        int num = scanner.nextInt();

        linarSearch(arr, num);
    }

    private static void linarSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                System.out.println(arr[i]);
            }
        }
    }
}
