package Algorythms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        String[] arr = {"2H", "7S", "6T", "VT","9K", "3S", "5H"};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String curr_card = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].charAt(0) > curr_card.charAt(0)){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr_card;

        }

    }

}

// решение гопоты
//import java.util.Arrays;
//
//public class CardSorter {
//
//    // Массив карт для сортировки
//    static String[] cards = {"2H", "3D", "5S", "9C", "KH", "7S", "6H", "10C", "JD", "QS"};
//
//    // Значения рангов карт от двойки до туза
//    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
//
//    // Масти карт: червы, бубны, трефы, пики
//    static String[] suits = {"H", "D", "C", "S"};
//
//    // Получаем индекс ранга карты
//    public static int rankValue(String card) {
//        String rank = card.substring(0, card.length() - 1);
//        for (int i = 0; i < ranks.length; i++) {
//            if (ranks[i].equals(rank)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    // Получаем индекс масти карты
//    public static int suitValue(String card) {
//        String suit = card.substring(card.length() - 1);
//        for (int i = 0; i < suits.length; i++) {
//            if (suits[i].equals(suit)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    // Сортировка пузырьком
//    public static void bubbleSort(String[] arr) {
//        int n = arr.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (compareCards(arr[j], arr[j + 1]) > 0) {
//                    // Меняем местами карты, если они не в порядке
//                    String temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }
//
//    // Сортировка вставками
//    public static void insertionSort(String[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            String key = arr[i];
//            int j = i - 1;
//
//            while (j >= 0 && compareCards(arr[j], key) > 0) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
//    }
//
//    // Сравнение карт: сначала по масти, затем по рангу
//    public static int compareCards(String card1, String card2) {
//        int suitComparison = Integer.compare(suitValue(card1), suitValue(card2));
//        if (suitComparison != 0) {
//            return suitComparison;
//        } else {
//            return Integer.compare(rankValue(card1), rankValue(card2));
//        }
//    }
//
//    // Основной метод
//    public static void main(String[] args) {
//        // Исходный массив карт
//        System.out.println("Исходный массив карт: " + Arrays.toString(cards));
//
//        // Сортировка пузырьком
//        String[] bubbleSortedCards = Arrays.copyOf(cards, cards.length);
//        bubbleSort(bubbleSortedCards);
//        System.out.println("Отсортировано пузырьком: " + Arrays.toString(bubbleSortedCards));
//
//        // Сортировка вставками
//        String[] insertionSortedCards = Arrays.copyOf(cards, cards.length);
//        insertionSort(insertionSortedCards);
//        System.out.println("Отсортировано вставками: " + Arrays.toString(insertionSortedCards));
//    }
//}

