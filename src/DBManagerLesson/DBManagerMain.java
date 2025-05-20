package DBManagerLesson;

import java.util.Scanner;

public class DBManagerMain {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
//        System.out.println("insert login ");
//        String login = scanner.next();
//        System.out.println("insert password ");
//        String password = scanner.next();
//
//        boolean check = DBManager.authUser(login, password);
//        System.out.println(check);

        System.out.println("insert login ");
        String login = scanner.next();
        System.out.println("insert password ");
        String password = scanner.next();

        DBManager.registerUser(new User(login, password));
        System.out.println(DBManager.getUsers());
    }
}
