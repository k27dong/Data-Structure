public class P2_30 {
    private static class letter {
        private char e;
        private letter next;
        private int count;


        public letter(char c) {
            e = c;
            next = null;
            count = 1;
        }

        public letter() {
            e = 0;
            next = null;
            count = 0;
        }
        
        public int size() {
            return count;
        }

        public void add() {
            count++;
        }

        public void set_next(letter l) {
            next = l;
        }

        public letter get_next() {
            return next;
        }

        public char get_element() {
            return e;
        }
    }

    private letter head;

    public P2_30() {    // alphabet itself
        head = new letter();
    }

    public void add_new(char c) {
        letter temp = head;
        while(temp.get_next() != null) {
            temp = temp.get_next();
            if(temp.get_element() == c) {
                temp.add();
                System.out.println("added: " + c);
                break;
            }
        }
        letter newest = new letter(c);
        temp.set_next(newest);
        System.out.println("created: " + c);
    }

    public void print() {
        letter temp = head;
        while(temp.get_next() != null) {
            temp = temp.get_next();
            System.out.println(temp.get_element() + ": " + temp.size());
        }
        System.out.println("End.");
    }



    public static void main(String[] args) {    // test
        P2_30 p = new P2_30();

        // use variable instead of reading input from user
        String input = "hellotodayisaogoddatyasdcbasc";
        System.out.println("Input: " + input);
        
        char[] c = "hellotodayisagoodday".toLowerCase().toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            p.add_new(c[i]);
        }
        
        p.print();
    }


}