public class C5_20 {
    public static void sort_parity(int[] data, int low, int high) {
        if (low >= high) {
            // do nothing
        }
        else {
            if ((data[low] & 1) == 1) {
                // if the first entry is odd
                if ((data[high] & 1) == 1) {
                    // if the last entry is odd
                    // last is clear
                    sort_parity(data, low, high - 1);
                }
                else {
                    // if the last entry is even, swap
                    // first and last are clear
                    int temp = data[high];
                    data[high] = data[low];
                    data[low] = temp;
                    sort_parity(data, low + 1, high - 1);
                }
            }
            else {
                // if the first entry is even
                // first is clear
                sort_parity(data, low + 1, high);
            }
        }
    }

    public static void main(String[] args) {    // test
        int[] array = {9, 2, 8, 10, 1, 2, 5, 10, 9, 9, 6, 10, 7, 7, 5};
        sort_parity(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}