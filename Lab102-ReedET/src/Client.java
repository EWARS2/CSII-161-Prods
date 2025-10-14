
/**
 * Lab102
 * Example usage of the Scores class
 *
 * @author Ethan T. Reed
 * @version 09/12/2025
 */
import java.util.Random;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random random = new Random();

        /**
         * Create an Object of Type Scores using the overloaded constructor with
         * a value of 2 for the parameter.
         */
        Scores score = new Scores(2);

        /**
         * Use a for loop to populate the list in Scores object with 16 random
         * numbers between -10 and +10 inclusive. (Use the Random class from
         * java.util package to generate pseudorandom numbers).
         */
        for (int i = 0; i < 16; i++) {
            score.add(random.nextInt(-10, 11));   // TODO : replace magic numbers
        }

        /**
         * Call toString( ) to print the contents of the Scores object.
         */
        System.out.println("toString: " + score.toString());

        /**
         * Call the add( ) method to add the number 3 to Scores object.
         */
        score.add(3);

        /**
         * Call toString( ) to print the contents of the Scores object.
         */
        System.out.println("toString: " + score.toString());

        /**
         * Call the remove( ) method to randomly remove a number from Scores
         * object
         */
        score.remove();

        /**
         * Print the number that is at the 6th index position.
         */
        int index6 = score.get(6);
        System.out.println("index6: " + index6);

        /**
         * Call toString( ) to print the contents of the Scores object.
         */
        System.out.println("toString: " + score.toString());

        /**
         * Print the frequency of the number that is now at the 6th index
         * position.
         */
        index6 = score.get(6);
        System.out.println("getFrequencyOf(index6): "
                + score.getFrequencyOf(index6));

        /**
         * Call the appropriate overloaded remove method to remove the first
         * occurrence of number at the 6th index position from Scores object
         */
        score.remove(index6);

        /**
         * Print the frequency of the number you just removed.
         */
        System.out.println("getFrequencyOf(index6): "
                + score.getFrequencyOf(index6));

        /**
         * Call toString( ) to print the contents of the Scores object.
         */
        System.out.println("toString: " + score.toString());

        /**
         * Check whether the array in Scores object contains the number -5
         */
        System.out.println("contains(-5): " + score.contains(-5));

        /**
         * For each of the above steps, your main method should print out
         * appropriate labels/messages so that a reader of the output
         * understands what the main method is doing.
         */
        /**
         * Create a second instance of the Scores class and add random numbers
         * into this second instance so that it has the same size as the
         * instance that you were working on in the above steps.
         */
        Scores score2 = new Scores(0);
        for (int i = 0; i < score.size(); i++) {
            score2.add(random.nextInt(-10, 11));   // TODO : replace magic numbers
        }

        /**
         * Call toString( ) to print the contents of this second instance of the
         * Scores class.
         */
        System.out.println("2.toString: " + score2.toString());

        /**
         * Test your equals method with these two instances of the scores class.
         */
        System.out.println("equals: " + score.equals(score));

        /**
         * You have one test that returns a positive and one test that returns a
         * negative.
         */
        System.out.println("equals: " + score.equals(score2));
    }
}
