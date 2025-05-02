package AdditionalTopics.AnonAndLamd;

public class Lambda {
    public static void main(String[] args) {
        //Класс операция алегбра расположен в классе анонимности, ищи там
        OperationAlgebra operationAlgebra1 = (x, y) -> x + y;
        System.out.println(operationAlgebra1.calculate(30, 20));
    }
}
