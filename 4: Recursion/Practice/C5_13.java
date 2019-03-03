public class C5_13 {
    public static int multiply(int m, int n) {
        if (n < 0) {
            if (m < 0) {
                m *= -1;
                n *= -1;
            }
            else {
                int temp = m;
                m = n;
                n = temp;
            }
        }
        if (n == 1) {
            return m;
        }
        else {
            return m + multiply(m, Math.abs(n - 1));
        }
    }
}