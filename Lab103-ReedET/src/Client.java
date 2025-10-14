
/**
 * Lab103 Demonstration of ArrayBag and LinkedBag The latter of which relies on
 * SinglyLinkedList
 *
 * @author Ethan T. Reed
 * @version 2025/09/19
 */
public class Client {

    public static void sout(String s, Object[] o) {
        System.out.println(s + ". " + o[0] + ": " + o[1]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * - Create an instance of ArrayBag called mensTeam to store players’
         * information of NDSU’s Men’s football team using the overload
         * constructor to make the initial length of the list array equal to 2.
         */
        ArrayBag mensTeam = new ArrayBag();
        Object[] mensTeamObj = {"mensTeam", mensTeam};

        /**
         * 1. Add eight players to mensTeam by hardcoding eight calls to the add
         * method (one for each player).
         */
        mensTeam.add(new Player("John Cena", "idk", 67));
        mensTeam.add(new Player("Xhong China", "Chinese Cousin", 97));
        mensTeam.add(new Player("Bill Murray", "Super Ghostbuster", 42));
        mensTeam.add(new Player("GRAND DAD?!", "FLEENSTONES?! Argh...", 7));

        mensTeam.add(new Player("Obama", "Gamer", 69));
        mensTeam.add(new Player("Waluigi", "Tennis", 0));
        mensTeam.add(new Player("Gurpreet", "Who is he??", 4));
        mensTeam.add(new Player("Water Boy", "https://youtu.be/uUop8LhIk4g", 44));

        /**
         * 2. Display the contents of mensTeam.
         */
        //System.out.println("2. mensTeam: " + mensTeam);
        sout("2", mensTeamObj);

        /**
         * 3. Remove a random player from mensTeam.
         */
        mensTeam.remove();

        /**
         * 4. Display the contents of mensTeam.
         */
        //System.out.println("4. mensTeam: " + mensTeam);
        sout("4", mensTeamObj);

        /**
         * 5. Get but do not remove a reference to the 5th item in the bag.
         */
        Object fifthItem = mensTeam.get(5);
        Object[] fifthItemObj = {"Fifth Item", fifthItem};

        /**
         * 6. Display the contents of the reference you “got” in step 5.
         */
        //System.out.println("6. Fifth Item: " + fifthItem);
        sout("6", fifthItemObj);

        /**
         * 7. Add another Player with another hardcoded add method call.
         */
        mensTeam.add(new Player("Strong Bad", "Checka ma email", 1));

        /**
         * 8. Display the contents of mensTeam.
         */
        //System.out.println("8. mensTeam: " + mensTeam);
        sout("8", mensTeamObj);

        /**
         * 9. Remove the Player that you “got” in step 5 using a call to the
         * remove(E e)method.
         */
        mensTeam.remove(fifthItem);

        /**
         * 10. Display the contents of mensTeam.
         */
        //System.out.println("10. mensTeam: " + mensTeam);
        sout("10", mensTeamObj);

        /**
         * 11. To demonstrate that your generic class can support objects of
         * different types:
         */
        /**
         * a. Create an instance of an ArrayBag called courses to store the
         * course ids of the courses that you are taking this semester (CSci
         * 161, .....) as Strings.
         */
        ArrayBag courses = new ArrayBag();

        /**
         * b. Populate courses with each of your courses.
         */
        courses.add("CSCI 161");
        courses.add("COMM 212");
        courses.add("ENGL 120");
        courses.add("HNES 100");
        courses.add("MATH 166");

        /**
         * c. Display the contents of courses.
         */
        System.out.println("c. Courses: " + courses);

        /**
         * d. Remove a random course id from courses.
         */
        courses.remove();

        /**
         * e. Display the contents of courses.
         */
        System.out.println("e. Courses: " + courses);

        /**
         * - Create an instance of LinkedBag called womensTeam to store the
         * players’ information of NDSU’s Women’s basketball team.
         */
        LinkedBag womensTeam = new LinkedBag();

        /**
         * - Repeat steps 1 through 9 above for the womensTeam that uses an
         * instance of the LinkedBag class.*
         */
        /**
         * 1. Add eight players to womensTeam by hardcoding eight calls to the
         * add method (one for each player).
         */
        // I was writing the example names at 1AM please don't hurt me
        womensTeam.add(new Player("Dora", "The Exploder", 2));
        womensTeam.add(new Player("Scott the Woz", "Hey all", 5));
        womensTeam.add(new Player("SiIvaGunner", "High Quality Ripper", 777));
        womensTeam.add(new Player("Lorna Doone", "Certified Cookie", 30));

        womensTeam.add(new Player("Samsung Refrigerator", "Spy in the base", 40));
        womensTeam.add(new Player("Sans Undertale", "'sup?", 99));
        womensTeam.add(new Player("George H. W. Bush", "Ask him for $8", 41));
        womensTeam.add(new Player("Peter Griffin", "neheheh", 12));

        /**
         * 2. Display the contents of womensTeam.
         */
        System.out.println("2. womensTeam: " + womensTeam);

        /**
         * 3. Remove a random player from womensTeam.
         */
        womensTeam.remove();

        /**
         * 4. Display the contents of womensTeam.
         */
        System.out.println("4. womensTeam: " + womensTeam);

        /**
         * 5. Get but do not remove a reference to the 5th item in the bag.
         */
        Object fifthItem2;
        fifthItem2 = womensTeam.get(5);

        /**
         * 6. Display the contents of the reference you “got” in step 5.
         */
        System.out.println("6. Fifth Item: " + fifthItem2);

        /**
         * 7. Add another Player with another hardcoded add method call.
         */
        womensTeam.add(new Player("Your Mom", "Your Mom", 303));

        /**
         * 8. Display the contents of womensTeam.
         */
        System.out.println("8. womensTeam: " + womensTeam);

        /**
         * 9. Remove the Player that you “got” in step 5 using a call to the
         * remove(E e)method.
         */
        womensTeam.remove(fifthItem2);

        /**
         * 10. Display the contents of womensTeam.
         */
        System.out.println("10. womensTeam: " + womensTeam);
    }

}
