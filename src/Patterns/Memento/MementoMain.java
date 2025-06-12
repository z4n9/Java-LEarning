import java.util.Stack;

class TextMemento {
    private final String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getSavedText() {
        return text;
    }
}

class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void append(String newText) {
        text.append(newText);
    }

    public void deleteLast(int count) {
        int length = text.length();
        if (count > length) count = length;
        text.delete(length - count, length);
    }

    public String getText() {
        return text.toString();
    }

    public TextMemento save() {
        return new TextMemento(text.toString());
    }

    public void restore(TextMemento memento) {
        text = new StringBuilder(memento.getSavedText());
    }
}

class History {
    private final Stack<TextMemento> history = new Stack<>();

    public void push(TextMemento memento) {
        history.push(memento);
    }

    public TextMemento pop() {
        return history.isEmpty() ? new TextMemento("") : history.pop();
    }
}

public class MementoMain{
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.append("Привет");
        history.push(editor.save());

        editor.append(", мир!");
        history.push(editor.save());

        editor.append(" Как дела?");
        System.out.println("Текущее: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("Отмена: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("Ещё отмена: " + editor.getText());
    }
}

