package AdditionalTopics.Exeptions;

public class MyMatrixException extends MyException{
    private int index;

    public MyMatrixException() {
    }

    public MyMatrixException(int index) {
        super("Ошибка у элемента под индексом " + index);
        this.index = index;
    }
}
