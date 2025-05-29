package AdditionalTopics.Exeptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //выбросит ошибку о невозможности деления на  0
        //int a = 10 / 0;

        //если ввести букву или другой символ не являющийся цифрой,
        //будет ошибка о не подходящем типе переменной
        //int b = input.nextInt();

        //будет ошибка с размером массива
        //int[] arr = new int[1];
        //arr[0] = 88;
        //arr[1] = 88;

        //подобные ошибки мы отлавливаем с помощью операторов: try, catch, finally, throw
        //все исключения в Java наследуются от класса "Trowable"

        //StackOverflowError
        //print();

        //программа упадет потому что в первую очередь выпадет ошибка
//        int a = 10 / 0;
//        System.out.println("After / by zero");
//        try {
//            int a = 10 / 0;
//        }catch (Exception e){
//            //выводит ошибку
//            //e.printStackTrace();
//
//            //выводит наше сообщение,
//            // оператор "err" подсвечивает сообщение красным цветом
//            System.err.println("Error by / zero");
//        }
//        //блок finally сработает при любых условиях
//        finally {
//            System.out.println("Я сработаю в любом случае");
//        }
//        System.out.println("After / by zero");
        
//        int arr[] = {1, 3, 4};
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 3) {
//                throw new RuntimeException("Значение равно 3");
//            }
//        }

        //getSqrt(-100);

        int arr[] = {1, 5, -10, 7};

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                throw new MyMatrixException(i);
            }
        }

    }

//    private static int getSqrt(int a){
//        if(a < 0){
//            throw new IllegalArgumentException("Значение меньше нуля");
//        }
//        return -1;
//    }
//    public static void print(){
//        print();
//    }
}
