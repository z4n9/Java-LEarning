package LessonOOP.Incapsulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Students[] all = new Students[4];

        for (int i = 0; i < all.length; i++) {
            all[i] = new Students(input.nextInt(), input.next(), input.next(), input.next());
            if (all[i] == null) {
                continue;
            }
        }
        for (Students students : all) {
            System.out.println(students.getLogin());
            System.out.println(students.getId());
            System.out.println(students.getRole());
        }
    }
}