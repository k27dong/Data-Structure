public class P3_39 {
    // this is a circularly linked list
    // alphabet: ... -> letter -> letter (tail) -> letter -> ...

    public static class letter {
        // this is a simple node class
        private char c;
        private letter prev;
        private letter next;

        public letter(char input_c) {
            this(input_c, null, null);
        }

        public letter(char input_c, letter p, letter n) {   // constructor
            c = input_c;
            prev = p;
            next = n;
        }

        public letter get_prev() {
            return prev;
        }
        public letter get_next() {
            return next;
        }

        public void set_prev(letter p) {
            prev = p;
        }

        public void set_next(letter n) {
            next = n;
        }

        public char get_element() {
            return c;
        }

        public void set_element(char input_c) {
            c = input_c;
        }
    }

    public static class alphabet {
        private letter tail;

        public alphabet() {
            tail = null;
        }

        public void fill(String s) {
            for(int i  = 0; i < s.length(); i++) {
                add(s.charAt(i));
            }
        }

        public void add(char c) {
            
            if (tail == null) {
                // empty alphabet
                tail = new letter(c);
                tail.set_next(tail);
                tail.set_prev(tail);
            }
            else {
                letter newest = new letter(c);  // the letter to be added
                letter temp = tail; // start searching from the tail
                while (temp.get_next() != tail) {
                    temp = temp.get_next();
                }
                // now temp's next letter is tail
                temp.set_next(newest);
                newest.set_prev(temp);
                newest.set_next(tail);
                tail.set_prev(newest);
            }
        }

        public void print() {   // visualization
            letter temp = tail;
            System.out.print("[ ");
            while (temp.get_next() != tail) {
                System.out.print(temp.get_element() + " | ");
                temp = temp.get_next();
            }
            System.out.println(temp.get_element() + " ]");
        }

        public void shift_left() {
            // shift once to the left
            if (tail == null) {
                // do nothing
            }
            else {
                letter store = new letter(tail.get_element());
                letter temp = tail;
                while(temp.get_next() != tail) {
                    temp.set_element(temp.get_next().get_element());
                    temp = temp.get_next();
                }
                temp.set_element(store.get_element());
            }
        }

        public void shift_right() {
            // shift once to the right
            if (tail == null) {
                // do thing
            }
            else {
                letter store = new letter(tail.get_element());
                letter temp = tail;
                while(temp.get_prev() != tail) {
                    temp.set_element(temp.get_prev().get_element());
                    temp = temp.get_prev();
                }
                temp.set_element(store.get_element());
            }
        }

        public char get(int x) {
            // return the character stored in the x index of the alphabet
            letter temp = tail;
            for (int i = 0; i < x; i ++) {
                temp = temp.get_next();
            }
            return temp.get_element();
        }
    }


    public static void main(String[] args) {
        /**
         * Here I used an inefficient way to solve the caesar cipher
         * 
         * 1. Create a circularly linked list, fill it manually with the alphabet
         * 2. For the encrypted message, find the index of each letter in the alphabet and 
         *    store them in an array.
         * 3. With the password provided, shift the alphabet with the right time (either left or right)
         * 4. For the previous array, each item corresponds to an index, using this index, 
         *    find the decrypted letter in the shifted alphabet.
         */

        
         /* Preparation:  */
         // uses variable instead of user input
        String encrypted;
        String alphabet = "abcdefghijklmnopqrstuvwxyz 1234567890!?";
        int password;

        alphabet a = new alphabet();
        a.fill(alphabet);

        encrypted = "Hello World";
        password = 5;

        encrypted = encrypted.toLowerCase();

        int[] index_list = new int[encrypted.length()];

        /* Encrypting */
        // store all the index of the encrypted message in the alphabet inside this array
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            int temp = 0;
            while (temp < alphabet.length()) {
                if (alphabet.charAt(temp) == c) {
                    break;
                }
                else {
                    temp++;
                }
            }
            index_list[i] = temp;
        }

        // shift the alphabet
        for (int i = 0; i < Math.abs(password); i++) {
            if (password > 0) {
                a.shift_left();
            }
            else {
                a.shift_right();
            }
        }

        // get the decrypted message using the index list, and the shifted alphabet
        System.out.println("Encrypted: " + encrypted);
        System.out.print("Decrypted: ");
        for (int i = 0; i < encrypted.length(); i++) {
            System.out.print(a.get(index_list[i]));
        }
    }
}