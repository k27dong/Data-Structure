public class prefix_avg {
    public static double[] prefix_avg_1 (double[] x) {
        // O(n^2)
        double[] n = new double[x.length];  // O(1)
        for (int i = 0; i < n.length; i++) {// O(n)
            double sum = 0;
            for (int j = 0; j <= i; j++) {  // O(n^2)
                sum += x[j];
            }
            n[i] = sum / (i + 1);
        }
        return n;
    }

    public static double[] prefix_avg_2 (double[] x) {
        // O(n)
        double[] n = new double[x.length];
        double sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += x[i];
            n[i] = sum / (i + 1);
        }
        return n;
    }
}