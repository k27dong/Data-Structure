public class reverse_array {
    public static int[] reverse(int[] data, int low, int high) {
        if (low > high) {
            // do nothing (the process would stop here)
        }
        else {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverse(data, low + 1, high - 1);
        }
    }
}