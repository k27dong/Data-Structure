public class factorial {
    public static int calculate_factorial (int n){
        if (n == 0) {
            return 1;
        }
        else {
            return n * calculate_factorial(n - 1);
        }
    }
}