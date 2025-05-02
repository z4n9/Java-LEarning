package AdditionalTopics.AnonAndLamd;

public class Anonymous {
    public static void main(String[] args) {


        OperationAlgebra operationAlgebra = new OperationAlgebra() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println(operationAlgebra.calculate(10, 18));
    }
}

interface OperationAlgebra{
    int calculate(int a, int b);
}