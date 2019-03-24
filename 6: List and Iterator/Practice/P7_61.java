import src.*;

public class P7_61 {
    public static class txt_editor {
        PositionalList<Character> txt;
        Position<Character> cursor;
        String stored = "";
        

        public txt_editor() {
            this("DEFAULT");
        }

        public txt_editor(String s) {
            stored = s;
            txt = new LinkedPositionalList<>();

            for (int i = 0; i < s.length(); i++) {
                txt.addLast(s.charAt(i));
                cursor = txt.first();
            }
        }

        public char cursor() {
            return cursor.getElement();
        }

        public void left() {
            if (cursor == txt.first()) {
                // do nothing
            }
            else {
                cursor = txt.before(cursor);
            }
        }

        public void right() {
            if (cursor == txt.last()) {
                // do nothing
            }
            else {
                cursor = txt.after(cursor);
            }
        }

        public void insert(char c) {
            txt.addAfter(cursor, c);
        }

        public void delete() {
            if (txt.size() == 1) {
                // do nothing
                System.out.println("nothing is left");
            }
            else {
                if (cursor == txt.first()) {
                    right();
                    txt.remove(txt.before(cursor));
                }
                else {
                    left();
                    txt.remove(txt.after(cursor));
                }
            }
        }

        public void print() {
            Position<Character> temp = txt.first();
            
            while (temp != null) {
                System.out.print(temp.getElement());
                temp = txt.after(temp);
            }
        }
    }

    public static void main(String[] args) {
        txt_editor t = new txt_editor("abc");
        t.print();
    }
}