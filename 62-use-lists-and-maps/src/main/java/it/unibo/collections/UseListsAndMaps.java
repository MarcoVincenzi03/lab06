package it.unibo.collections;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 100_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        for(int i = 1000; i < 2000; i++){
            arrayInt.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> listInt = new LinkedList<Integer>();
        listInt.addAll(arrayInt);
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = arrayInt.get(0);
        arrayInt.set(0, arrayInt.get(arrayInt.size()));
        arrayInt.set(arrayInt.get(arrayInt.size()), temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : listInt) {
            System.err.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long arrayListTime = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            arrayInt.add(i);
        }

        arrayListTime = System.nanoTime() - arrayListTime;

        long linkedListTime = System.nanoTime();

        for (int i = 1; i <= ELEMS; i++) {
            listInt.add(i);
        }

        linkedListTime = System.nanoTime() - linkedListTime;

        var arrayMS = TimeUnit.NANOSECONDS.toMillis(arrayListTime);
        var listMS = TimeUnit.NANOSECONDS.toMillis(linkedListTime);

        System.out.println(
            "Adding "
                + arrayInt.size()
                + " ints into ArrayList took "
                + arrayListTime
                + "ns ("
                + arrayMS
                + "ms)"
        );

        System.out.println(
            "Adding "
                + listInt.size()
                + " ints into LinkedList took "
                + linkedListTime
                + "ns ("
                + listMS
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        arrayListTime = System.nanoTime();

        for (int i = 1; i <= 1000; i++) {
            arrayInt.get(500_000);
        }

        arrayListTime = System.nanoTime() - arrayListTime;

        linkedListTime = System.nanoTime();

        for (int i = 1; i <= 1000; i++) {
            listInt.get(500_000);
        }

        linkedListTime = System.nanoTime() - linkedListTime;

        arrayMS = TimeUnit.NANOSECONDS.toMillis(arrayListTime);
        listMS = TimeUnit.NANOSECONDS.toMillis(linkedListTime);

        System.out.println(
            "Reading an element from the middle of ArrayList 1000 times took "
                + arrayListTime
                + "ns ("
                + arrayMS
                + "ms)"
        );

        System.out.println(
            "Reading an element from the middle of ArrayList 1000 times took "
                + linkedListTime
                + "ns ("
                + listMS
                + "ms)"
        );


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

         final Map<String, Double> map = new HashMap<>(); 

         map.put("Africa",1110635000.0);
         map.put("Americas",972005000.0);
         map.put("Antarctica",0.0);
         map.put("Asia",4298723000.0);
         map.put("Europe",742452000.0);
         map.put("Oceania",38304000.0);

        /*
         * 8) Compute the population of the world
         */
    }
}
