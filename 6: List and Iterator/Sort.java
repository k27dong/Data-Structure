public class Sort {
    /**
     * list : the list of item to be sorted
     * marker: represents the rightmost position of the currently sorted portion of a list
     * pivot: the position just past the marker, the item to be considered
     * walk: a variable to help us move leftward from the marker
     */
    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();    // initially the marker is the first item in the list
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement(); // this is the number to be placed in the right position

            if (value > marker.getElement()) {
                // pivor is already in the sorted position
                marker = pivot;
            }
            else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value) {
                    // while walk is not the first element
                    // keep move the walk to the left until the next item is smaller than value
                    walk = list.before(walk);
                }
                list.remove(pivot); // remove the item to be sorted, because it is about to be placed in the right position
                list.addBefore(walk, value);    // since walk now points to the right position, add the pivot's value to the list, according to walk
            }
        }
    }
    
}