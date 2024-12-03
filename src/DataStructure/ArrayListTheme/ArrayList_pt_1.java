package DataStructure.ArrayListTheme;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayList_pt_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();

        while (true) {
            String word = scanner.next();

            if (word.equals("0")) {
                break;
            } else {
                strings.add(word);
            }
        }

        System.out.println(selectionSort(strings));
    }

    public static ArrayList<String> selectionSort(ArrayList<String> srtings) {
        for (int i = 0; i < srtings.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < srtings.size(); j++) {
                if (srtings.get(minIndex).length() > srtings.get(j).length()) {
                    minIndex = j;
                }
            }
            getSwap(i, minIndex, srtings);
        }
        return srtings;
    }

    private static void getSwap(int i, int minIndex, ArrayList<String> srtings) {
        String temp = srtings.get(i);
        srtings.set(i, srtings.get(minIndex));
        srtings.set(minIndex, temp);
    }
}
