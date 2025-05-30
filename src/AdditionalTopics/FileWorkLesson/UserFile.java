package AdditionalTopics.FileWorkLesson;

//просто создаем класс Юзеров
public class UserFile{
    private int id;
    private String login;
    private String password;

    public UserFile(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + " " + login + " " + password;
    }
}