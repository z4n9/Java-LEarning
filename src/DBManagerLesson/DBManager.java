package DBManagerLesson;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<User> users = new ArrayList<>();


    //локальная БД
    static {
        users.add(new User( 1L, "Arthur", "123"));
        users.add(new User( 2L, "Max", "456"));
        users.add(new User( 3L, "John", "789"));
    }

    static Long id = 4L;

    public static void registerUser(User user) {
        users.add(user);
        user.setId(id);
        id++;
    }

    public static boolean authUser(String login, String password) {
        boolean check = true;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) {
                check = true;
                break;
            }else {
                check = false;
            }
        }
        return check;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
