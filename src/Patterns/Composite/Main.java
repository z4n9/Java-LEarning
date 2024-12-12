package Patterns.Composite;

import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Нельзя добавлять компоненты в этот тип.");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Нельзя удалять компоненты из этого типа.");
    }

    public abstract void display(String indent);
}

class File extends FileSystemComponent {
    public File(String name) {
        super(name);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name);
    }
}

class Folder extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void add(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemComponent component : components) {
            component.display(indent + "  ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        File file4 = new File("threedvaodin");

        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");
        Folder root = new Folder("Root");

        folder2.add(file4);
        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        root.add(folder1);
        root.add(folder2);

        root.display("");
    }
}

