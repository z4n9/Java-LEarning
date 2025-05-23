package Patterns.Observer;

import java.util.*;

// Интерфейс наблюдателя
interface IObserver {
    void update(String news);
}

// Интерфейс субъекта
interface Subject {
    void addObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers();
}

// Конкретный субъект — новостной канал
class NewsChannel implements Subject {
    private List<IObserver> observers = new ArrayList<>();
    private String latestNews;

    public void setNews(String news) {
        this.latestNews = news;
        notifyObservers(); // уведомляем всех подписчиков
    }

    public void addObserver(IObserver o) {
        observers.add(o);
    }

    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update(latestNews);
        }
    }
}

// Конкретный наблюдатель — пользователь
class User implements IObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " получил новость: " + news);
    }
}

// Точка входа
public class Observer {
    public static void main(String[] args) {
        NewsChannel channel = new NewsChannel();

        User alice = new User("Алиса");
        User bob = new User("Боб");

        channel.addObserver(alice);
        channel.addObserver(bob);

        channel.setNews("Сегодня солнечно.");
        channel.setNews("Завтра дождь.");

        channel.removeObserver(bob);

        channel.setNews("Появился новый курс Java!");
    }
}
