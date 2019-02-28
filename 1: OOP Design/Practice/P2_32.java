import java.util.Random;

public class P2_32 {
    public static void main(String[] args) {    // test
        river r = new river();
        int times = 10;

        r.fill();
        r.show();
        // r.show_gender();

        for (int i = 0; i < times; i++) {
            r.move();
        }
    }
}

class river {
    private Animal[] ecosystem;

    public river() {
        ecosystem = new Animal[10]; // any length
    }

    public void add_new(Animal a, int i) {
        ecosystem[i] = a;
    }

    public void fill() {    // fill the array with random breed (bear, fish, or null)
        Random rnd = new Random();
        
        for (int i = 0; i < ecosystem.length; i++) {
            int seed = rnd.nextInt(3) + 1;
            Animal newest;
            if(seed == 1) {
                newest = new Bear();
                ecosystem[i] = newest;
            }
            else if (seed == 2) {
                newest = new Fish();
                ecosystem[i] = newest;
            }
            else if (seed == 3) {
                newest = null;
                ecosystem[i] = newest;
            }
        }
    }

    
    public void show() {    // display the entire array
        System.out.print("[ ");
        for (int i = 0; i < ecosystem.length-1; i++) {
            if (ecosystem[i] == null) {
                System.out.print("null" + " | ");
            }
            else {
                System.out.print(ecosystem[i].name() + " | ");
            }
        }
        if (ecosystem[ecosystem.length-1] != null) {
            System.out.println(ecosystem[ecosystem.length-1].name().toUpperCase() + " ]");   
        }
        else {
            System.out.println("null" + " ]");
        }
    }

    public void show_gender() {
        System.out.print("[ ");
        for (int i = 0; i < ecosystem.length-1; i++) {
            if (ecosystem[i] == null) {
                System.out.print("null" + " | ");
            }
            else {
                System.out.print(ecosystem[i].gender() + " | ");
            }
        }
        if (ecosystem[ecosystem.length-1] != null) {
            System.out.println(ecosystem[ecosystem.length-1].gender() + " ]");   
        }
        else {
            System.out.println("null" + " ]");
        }
    }

    public void move() {    // move all object once
        for (int i = 0; i < ecosystem.length; i++) {
            if (ecosystem[i] != null && ecosystem[i].moved()) {
                // nothing happens
            }
            else {
                // generate the next move
                Random rnd = new Random();
                int step = rnd.nextInt(3) - 1;
                
                // prevent bugs at the two ends of the array
                if (i == 0 && step == -1) step += 1;
                if (i == ecosystem.length-1 && step == 1) step -= 1;
    
                // get the current position and the target position
                String current, next;
                if (ecosystem[i] == null) {
                    current = "null";
                }
                else {
                    current = ecosystem[i].name();
                }
                if (ecosystem[i+step] == null) {
                    next = "null";
                }
                else {
                    next = ecosystem[i + step].name();
                }
    
                // actually moving procedure
                if (current == next) {
                    if (ecosystem[i + step] != null && ecosystem[i + step].moved()) {
                        // give birth
                        if (next == "bear") {
                            ecosystem[i-2] = new Bear(true);
                        }
                        else {
                            ecosystem[i-2] = new Fish(true);
                        }
                    }
                    // if both positions are empty (null), or the targeted position
                    // has not been moved, do nothing 
                }
                else if (current == "fish" && next == "bear") {
                    // nothing happens
                }
                else if (current == "bear" && next == "fish") {
                    // bear eats fish
                    ecosystem[i] = null;
                    ecosystem[i+step] = new Bear(true);
                }
                else if (current != "null" && next == "null") {
                    // move to an empty space
                    ecosystem[i] = null;
                    if (current == "bear") {
                        ecosystem[i+step] = new Bear(true);
                    }
                    else {
                        ecosystem[i+step] = new Fish(true);
                    }
                }
            }
        }
        show();
        reset();
    }

    public void reset() {
        for (int i = 0; i < ecosystem.length; i++) {
            if (ecosystem[i] != null) {
                ecosystem[i].set_moved(false);
            }
        }
    }

    public boolean random_boolean() {
        Random rnd = new Random();
        int r = rnd.nextInt(2);
        if (r == 0) {
            return true;
        }
        else return false;
    }
}


class Animal {
    private boolean moved = false;

    // true = female
    // false = male
    private boolean gender;

    public Animal() {
        gender = random_boolean();
    }

    public String name() {
        return "null";
    }

    public boolean moved() {
        return moved;
    }

    public void set_moved(boolean b) {
        moved = b;
    }

    public boolean gender() {
        return gender;
    }

    public void set_gender(boolean b) {
        gender = b;
    }
    
}

class Bear extends Animal {
    public Bear() {
        set_gender(random_boolean());
    };
    public Bear(boolean b) {
        set_moved(b);
        set_gender(random_boolean());
    }

    public String name() {
        return "bear";
    }
}

class Fish extends Animal {
    public Fish() {
        set_gender(random_boolean());
    };

    public Fish(boolean b) {
        set_moved(b);
        set_gender(random_boolean());
    }

    public String name() {
        return "fish";
    }
}