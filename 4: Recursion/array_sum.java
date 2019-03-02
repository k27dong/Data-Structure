public class array_sum {
    public static int linear_sum(int[] data, int low, int high) {
        if (low > high) {
            return 0;
        }
        else if (low == high) {
            return data[low];
        }
        else {
            return data[high] + linear_sum(data, low, high - 1);
        }
    }

    public static int binary_sum(int[] data, int low, int high) {
        if (low > high) {
            return 0;
        }
        else if (low == high) {
            return data[low];
        }
        else {  // low < high
            int mid = (low + high) / 2;
            return binary_sum(data, low, mid) + binary_sum(data, mid, high);
        }
    }
}