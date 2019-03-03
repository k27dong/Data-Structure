public class array_max {
    public static double arrayMax(double[] data) {
        // finds the maximum value of a non-empty array
        int n = data.length;
        double currentMax = data[0];    // default max
        for (int i = 0; i < n; i ++) {  // goes through every entry in this array
            if (data[i] > currentMax) { // if a larger one is found
                currentMax = data[i];   // replace the currentMax with the larger entry
            }
        }
        return currentMax;
        
        /**
         * f(x) = O(n)
         * 
         * c' : inside the loop
         * c'': outside the loop
         * 
         * the function only requires constant number of primitive operations
         * so does every iteration of the loop, which executes n - 1 times
         * 
         * running time = c' * (n - 1) + c''
         *              = c' * n + (c'' - c')
         * 
         * we assume(?) c'' <= c', then running time is O(n)
         */
    }


}