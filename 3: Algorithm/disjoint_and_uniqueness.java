import java.util.Arrays;

public class disjoint_and_uniqueness {
    // # of for loop = n's exponent

    public static boolean disjoint_1(int[] A, int[] B, int[] C) {
        /* Worst Case: O(n^3) */
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    if ((a == b) && (a == c)) return false; 
                }
            }
        }
        return true;
    }

    public static boolean disjoint_2(int[] A, int[] B, int[] C) {
        /* Worst Case: O(n^2) */
        for (int a : A) {
            for (int b : B) {
                if (a == b) {
                    for (int c : C) {
                        if (b == c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean unique_1(int[] A) {
        // O(n^2)
        for (int  i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean unique_2(int[] A) {
        // Sort function: O(n * log(n))
        // For loop: O(n)
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i+1]) {
                return false;
            }
        }
        return true;
    }
}