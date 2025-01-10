package Patterns.Proxy;

import java.util.HashMap;
import java.util.Map;

interface IBook {
    Page getPage(int pageNumber);
}

class Page {
    private final int number;
    private final String text;

    public Page(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Page " + number + ": " + text;
    }
}

class BookStore implements IBook {
    private final Map<Integer, Page> database;

    public BookStore() {
        database = new HashMap<>();
        database.put(1, new Page(1, "Once upon a time..."));
        database.put(2, new Page(2, "The story continues..."));
        database.put(3, new Page(3, "The end."));
    }

    @Override
    public Page getPage(int pageNumber) {
        System.out.println("Fetching page " + pageNumber + " from database...");
        return database.get(pageNumber);
    }
}

class BookStoreProxy implements IBook {
    private final BookStore bookStore;
    private final Map<Integer, Page> cache;

    public BookStoreProxy() {
        this.bookStore = new BookStore();
        this.cache = new HashMap<>();
    }

    @Override
    public Page getPage(int pageNumber) {
        if (cache.containsKey(pageNumber)) {
            System.out.println("Fetching page " + pageNumber + " from cache...");
            return cache.get(pageNumber);
        }

        System.out.println("Page " + pageNumber + " not in cache. Fetching from BookStore...");
        Page page = bookStore.getPage(pageNumber);
        if (page != null) {
            cache.put(pageNumber, page);
        }
        return page;
    }
}

public class Main {
    public static void main(String[] args) {
        IBook bookProxy = new BookStoreProxy();

        System.out.println(bookProxy.getPage(1));
        System.out.println(bookProxy.getPage(1));
        System.out.println(bookProxy.getPage(2));
        System.out.println(bookProxy.getPage(3));
        System.out.println(bookProxy.getPage(3));
    }
}

