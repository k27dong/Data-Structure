public class factorial {
    public static int calculate_factorial (int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        else {
            if (n == 0) {
                return 1;
            }
            else {
                return n * calculate_factorial(n - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate_factorial(10));
    }
}