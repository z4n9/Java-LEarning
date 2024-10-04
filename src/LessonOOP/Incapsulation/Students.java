package LessonOOP.Incapsulation;

public class Students {
    private String login;
    private int id;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", ID=" + id + '\'' +
                ", Role=" + role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.isEmpty()){
            System.out.println("login is empty");
        }
        else
            this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0){
            System.out.println("null");
        }
        else
            this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.isEmpty()){
            System.out.println("role is empty");
        }
        else
            this.role = role;
    }

    public Students() {

    }

    public Students(int id, String login, String password, String role) {
        this.login = login;
        this.id = id;
        this.password = password;
        this.role = role;
    }
}
