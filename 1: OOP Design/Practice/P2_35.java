import java.util.ArrayList;

public class P2_35 {

    public static String remove_first(String s) {
        String temp = "";
        char c;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            temp += c;
        }
        return temp;  
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // use string input instead of Scanner
        String input = "happy not ways parameters father door rail stone angel father door rail rail rail happy bbbb";
        
        String all = "";

        int spaces = 1;

        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            all += c[i];
            if (c[i] == ' ' && c[i-1] != ' ' && i != 0 && i != c.length-1) {
                spaces++;
            }
            // at this point all = input
            // this would be the method used if the input source is a Scanner
        }

        
        // a two dimensional array is used to store the data
        // first row: words
        // second row: the frequency of its appearance
        // it's not effencient at all

        String[][] list = new String[2][spaces];

        for (int i = 0; i < spaces; i++) {
            list[0][i] = "";
            list[1][i] = "0";
        }

        System.out.println("User Input: " + all);
        System.out.println("# of words: " + spaces);

        for (int i = 0; i < spaces; i++) {
            char b = all.charAt(0);
            String temp = "";
            while (b != ' ' && all.length() != 0) { // there is no space at the end of string
                temp += b;
                all = P2_35.remove_first(all); // remove the first char from string
                if (all.length() != 0) b = all.charAt(0);
            }
            all = P2_35.remove_first(all);
            // by this point, we have a full word 'temp', with the original context
            // removed from the original user input
            // now we need to add this word to the array:
            // to do this, we first find its correct position, then increment the number on the second row by one

            // find the position:
            int n = 0;
            do {
                String search = list[0][n];
                if (search.equals(temp)) {
                    // if the word matches, increment the number below it by one
                    int x = Integer.parseInt(list[1][n]);
                    x++;
                    list[1][n] = Integer.toString(x);
                    break;
                }
                else if (search == "") {
                    // if reaches the end of the list, put the word in the array and change 
                    // the '0' below it to '1' by adding one
                    list[0][n] = temp;
                    int x = Integer.parseInt(list[1][n]);
                    x++;
                    list[1][n] = Integer.toString(x);
                    break;
                }
                else {
                    // keep going to the next element
                    n++;
                }
            }
            while (n <= spaces);
        }

        // Now print the entire array
        for (int i = 0; i < spaces; i++) {
            if (list[0][i] != "") {
                System.out.println("[" + list[0][i] + "]  [" + list[1][i] + "]");
            }
        }
    }
}