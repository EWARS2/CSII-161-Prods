
/**
 * Lab101
 * A client to demonstrate inheritance and polymorphism.
 * Code based on an example by Joseph Latimer from 08/29/2025.
 *
 * @author Ethan T. Reed
 * @version 09/08/2025
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Create an array named employeeList of type Employee with a length of
         * 10
         */
        Employee employeeList[] = new Employee[10];

        /**
         * Populate the employeeList array with the following records by
         * creating an appropriate instance of either the Salaried or Hourly
         * class for each employee and then add the instance to the array. The
         * employees should be added to the employeeList array in the order that
         * they are listed, i.e. Al should be at index 0, Kelly should be at
         * index 1, etc.
         */
        // 0. A salaried employee named Al who is the Manager and is paid 
        // $60,000 per year.
        employeeList[0] = new Salaried(0, "Al", "Manager", 60000);

        // 1. An hourly employee named Kelly who is a Hostess and is paid $25.75
        // per hour.
        employeeList[1] = new Hourly(1, "Kelly", "Hostess", 25.75);

        // 2. A salaried employee named Peggy who is the CEO and is paid
        // $120,000 per year.
        employeeList[2] = new Salaried(2, "Peggy", "CEO", 120000);

        // 3. An hourly employee named Bud who is a Busboy and is paid $15.00
        // per hour.
        employeeList[3] = new Hourly(3, "Bud", "Busboy", 15.00);

        // 4. An hourly employee named Marcy who is a Server and is paid $10.00
        // per hour.
        employeeList[4] = new Hourly(4, "Marcy", "Server", 10.00);

        // 5. An hourly employee named Jefferson who is a Cook and is paid
        // $35.00 per hour.
        employeeList[5] = new Hourly(5, "Jefferson", "Cook", 35.00);

        /**
         * Once you have populated the array
         */
        // print out the contents of the array using a for loop.
        System.out.println("\nContents:");
        System.out.println("=========");
        for (Employee employee : employeeList) {
            // Hint – just call the toString( ) method to print the contents of
            // an instance.
            System.out.println(employee);
            // This loop should print out the contents of every entry in the
            // array including the blank (null) entries.
        }

        /**
         * Now give everyone in the employeeList array a 33% raise.
         */
        for (Employee employee : employeeList) {
            // When applying the raises use a loop to step across the array.
            double raise = 1.33;

            if (employee instanceof Salaried salariedEmployee) {
                salariedEmployee.setSalary(salariedEmployee.getSalary() * raise);
            }
            if (employee instanceof Hourly hourlyEmployee) {
                hourlyEmployee.setHourlyRate(hourlyEmployee.getHourlyRate() * raise);
            }
            /**
             * Your code must dynamically determine the type of employee at each
             * array location by using the instanceof operator (i.e. your code
             * should correctly apply raises regardless of the order in which
             * the employees are entered into the array).
             */
        }

        /**
         * After you have given everyone a 33% raise:
         */
        // Print out the contents of the array using a for loop.
        System.out.println("\nContents:");
        System.out.println("=========");
        for (Employee employee : employeeList) {
            // This time do not print the blank (null) entries.
            if (employee != null) {
                System.out.println(employee.toString());
            }
            //Your code must dynamically determine if an entry is null and not
            //print out the null entries.
        }
        /**
         * Finally, explicitly test the equals methods for each of your classes.
         */
        // This will require four tests.

        // Show at least one test where the equals( ) method returns true and
        // one test where the equals( ) method returns false for the Hourly
        // class
        Hourly hourly1 = (Hourly) employeeList[1];
        Hourly hourly3 = (Hourly) employeeList[3];
        System.out.println("\nCompare hourly employee 1 & 1");
        System.out.println(hourly1.equals(hourly1));
        System.out.println("\nCompare hourly employee 1 & 3");
        System.out.println(hourly1.equals(hourly3));

        // Show at least one test where the equals( ) method returns true and
        // one test where the equals( ) method returns false for the Salaried
        // class
        Salaried salaried0 = (Salaried) employeeList[0];
        Salaried salaried2 = (Salaried) employeeList[2];
        System.out.println("\nCompare salaried employee 0 & 0");
        System.out.println(salaried0.equals(salaried0));
        System.out.println("\nCompare salaried employee 0 & 2");
        System.out.println(salaried0.equals(salaried2));
    }
}
