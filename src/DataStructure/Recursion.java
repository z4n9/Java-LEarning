package DataStructure;

public class Recursion {
    public static void main(String[] args) {

        System.out.println(facrotial(5));
        System.out.println(fibonachi(10));
    }

    static int facrotial(int x){
        if(x == 1){
            return 1;
        }
        return x * (facrotial(x - 1));
    }


    static int fibonachi(int n){

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else{
            return fibonachi(n - 1) + fibonachi(n - 2);
        }
    }
}
