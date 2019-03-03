public class exponential {
    public static double power_1(double n, int e) {
        // basiclaly a for loop
        // for (int i = e; i > 0; i++) {
        //     n *= n;
        // }
        // O(n)
        if (e == 0) {
            return 1;
        }
        else {
            return n * power_1(n, e - 1);
        }
    }
    public static double power_2(double n, int e) {
        // *
        // (*...) (*...) (*)
        // O(n * log(n))
        if (e == 0) {
            return 1;
        }
        else {
            double partial = power_2(n, e / 2);
            double result = partial * partial;
            if (e % 2 == 1) {
                result *= n;
            }
            return result;
        }
    }

    /**
     * exponent = 
     * even + even -> n * n
     * even + odd -> n * n *n
     */
    public static void main(String[] args) {
        System.out.println(power_2(2, 1));
    }
}