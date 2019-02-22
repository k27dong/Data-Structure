public class Maryland extends State {
    Maryland() {

    }
    public void printMe() {
        System.out.println("Read it."); 
    }

    /*
    Object -> Place -> Region -> State -> Maryland
                buy ->  box   -> ship  -> read
    
    
    

    

    */
    
    public static void main(String[ ] args) {
        Region east = new State();
        State md = new Maryland();
        Object obj = new Place();
        Place usa = new Region();

        /*
        east: State
        md: Maryland
        obj: Place
        usa: Region
        */

        md.printMe( );              // read
        east.printMe( );            // ship

                                    // Place -> Place
        ((Place) obj).printMe();    // buy
        
        obj = md;                   // Maryland -> Maryland
        ((Maryland) obj).printMe(); // read
        
        obj = usa;                  // Region -x-> Place
        ((Place) obj).printMe();    // box
        
        usa = md;                   // Maryland -x-> Place
        ((Place) usa).printMe();    // read
    }
}
class State extends Region {
    State() {
        
    }
    public void printMe() {
        System.out.println("Ship it.");
    }
}

class Region extends Place {
    Region() {
        
    }
    public void printMe() {
        System.out.println("Box it.");
    }
}

class Place extends Object {
    Place() {
        
    }
    public void printMe() {
        System.out.println("Buy it.");
    }
}