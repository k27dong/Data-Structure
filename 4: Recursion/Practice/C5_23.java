public class C5_23 {

    public static void find_child(int[] data, int low, int high) {
        if (high <= 0) {
            // recursion stops here
            System.out.println("that's all");
        }
        else {
            find_sum(data, data[high], low, high - 1);
            find_child(data, low, high - 1);
        }
    }

    public static void find_sum(int[] data, int k, int low, int high) {
        if (low >= high) {
            // recursion stops here
        }
        else {
            if (data[low] > k) {
                // recursion stops here
            }
            else {
                if (data[high] > k) {
                    find_sum(data, k, low, high - 1);
                }
                else {
                    int sum = data[low] + data[high];
                    if (sum == k) {
                        // one pair is found
                        System.out.println(k + " = " + data[low] + ", " + data[high]);
                        find_sum(data, k, low + 1, high - 1);
                    }
                    else if (sum > k) {
                        // need to get smaller
                        find_sum(data, k, low, high - 1);
                    }
                    else {  // sum < k
                        // need to get bigger
                        find_sum(data, k, low + 1, high);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 6, 8, 9, 13, 15, 17, 21};
        find_child(n, 0, n.length - 1);
    }
}