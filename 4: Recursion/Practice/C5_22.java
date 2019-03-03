public class C5_22 {
    // data: sorted array of int in increasing order

    public static void find_sum(int[] data, int k, int low, int high) {
        if (low >= high) {
            // recursion stops here
            System.out.println("that's all");
        }
        else {
            if (data[low] > k) {
                // recursion stops here
                System.out.println("that's all");
            }
            else {
                if (data[high] > k) {
                    find_sum(data, k, low, high - 1);
                }
                else {
                    int sum = data[low] + data[high];
                    if (sum == k) {
                        // one pair is found
                        System.out.println(data[low] + ", " + data[high]);
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
        int[] n = {1, 2, 5, 7, 9, 10, 15, 17, 20};
        find_sum(n, 25, 0, n.length - 1);
    }
}