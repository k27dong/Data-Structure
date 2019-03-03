public class binary_search {
    public static boolean b_search(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true;
            }
            else if (target < data[mid]) {
                return b_search(data, target, low, mid + 1);
            }
            else {  // target > data[mid]
                return b_search(data, target, mid + 1, high);
            }
        }
    }
}