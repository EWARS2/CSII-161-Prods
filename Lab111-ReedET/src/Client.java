
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.concurrent.*;

/**
 * Lab111
 *
 * Client class
 *
 * @author Ethan T. Reed
 * @version 2025/12/5
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long timeout = 6;   // 600 seconds is 10 minutes
        try {
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Enter timeout in Seconds: ");
            timeout = inputScanner.nextLong();
        } catch (Exception e) {
            System.out.println("Error, please try again with numbers.");
            System.out.println("Continuing with default value " + timeout);
        }
        final int TESTS = 4;            // Default 4, test 1
        final int START_SIZE = 1000;    // Default 1000, test 100
        final int INC_FACTOR = 10;      // Default 10
        Object[][] table = new Object[TESTS + 1][8];
        table[0] = new Object[]{"N", "Merge", "Quick", "Bubble", "eBubble",
            "Insertion", "Selection", "Radix"};
        Random r = new Random();
        Comparator compId = new IDComparator();
        Comparator compName = new NameComparator();
        Comparator compDept = new DeptComparator();
        Comparator compHired = new HiredComparator();
        for (int i = 1; i <= TESTS; i++) {
            // Get test size and add it to the output table
            int test_size = (int) (START_SIZE * Math.pow(INC_FACTOR, i - 1));
            table[i][0] = test_size;

            // Create an array of random Employees
            Employee[] array = new Employee[test_size];
            for (int j = test_size - 1; j >= 0; j--) {
                int id = r.nextInt(0, 100000000);   // 0-99,999,999
                int dept = r.nextInt(1, 6);         // 1-5
                int hired = r.nextInt(2008, 2019);  // 2008-2018

                int len = r.nextInt(5, 11);         // 5-10
                StringBuilder sb = new StringBuilder(len);
                for (int k = 0; k < len; k++) {
                    sb.append((char) ('a' + r.nextInt(26)));
                }

                array[j] = new Employee(id, sb.toString(), dept, hired);
            }

            // Run tests
            table[i][1] = test(array, Sort::mergeSort, compName,
                    timeout, table[i - 1][1]);
            table[i][2] = test(array, Sort::quickSort, compDept,
                    timeout, table[i - 1][2]);
            table[i][3] = test(array, Sort::simpleBubbleSort, compId,
                    timeout, table[i - 1][3]);
            table[i][4] = test(array, Sort::enhancedBubbleSort, compHired,
                    timeout, table[i - 1][4]);
            table[i][5] = test(array, Sort::insertionSort, compName,
                    timeout, table[i - 1][5]);
            table[i][6] = test(array, Sort::selectionSort, compId,
                    timeout, table[i - 1][6]);
            table[i][7] = testRadix(array, compDept, compHired, compName,
                    timeout, table[i - 1][7]);
            System.out.println("");
        }
        Utility.printtbl(table, "Run time in milliseconds");

    }

    /**
     * Test sorting method and return execution time in milliseconds
     *
     * @param array
     * @param sortMethod
     * @param comparator
     * @param timeout in seconds
     * @param prevResult to check if test should be skipped
     * @return time in milliseconds
     */
    public static Object test(Employee[] array,
            BiConsumer<Employee[], Comparator<Employee>> sortMethod,
            Comparator<Employee> comparator, long timeout, Object prevResult) {
        if ("timeOut".equals(prevResult) || "OutOfMemory".equals(prevResult)) {
            return prevResult;  // Skip test if previous result already failed
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Object> task = () -> {     // Actual test
            System.out.print(". ");
            Employee[] copy = Utility.arraycopy(array);
            long startTime = System.nanoTime();
            sortMethod.accept(copy, comparator);
            long endTime = System.nanoTime();
            //Utility.printArray(copy);
            return (endTime - startTime) / 1_000_000;
        };
        Future<Object> future = executor.submit(task);
        try {   // Await timeout and errors, then proceed accordingly.
            Object result = future.get(timeout, TimeUnit.SECONDS);
            return result;
        } catch (TimeoutException | InterruptedException ex) {
            return "timeOut";
        } catch (OutOfMemoryError e) {
            return "OutOfMemory";
        } catch (ExecutionException e) {
            return "error";
        } finally {
            future.cancel(true);
            executor.shutdownNow();
        }
    }

    /**
     * Test radix sorting method and return execution time in milliseconds
     *
     * @param array
     * @param comp1
     * @param comp2
     * @param comp3
     * @param timeout in seconds
     * @param prevResult to check if test should be skipped
     * @return
     */
    public static Object testRadix(Employee[] array,
            Comparator<Employee> comp1, Comparator<Employee> comp2,
            Comparator<Employee> comp3, long timeout, Object prevResult) {
        if ("timeOut".equals(prevResult) || "OutOfMemory".equals(prevResult)) {
            return prevResult;  // Skip test if previous result already failed
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Object> task = () -> {     // Actual test
            System.out.print(". ");
            Employee[] copy = Utility.arraycopy(array);
            long startTime = System.nanoTime();
            Sort.radixSort(copy, comp1, comp2, comp3);
            long endTime = System.nanoTime();
            //Utility.printArray(copy);
            return (endTime - startTime) / 1_000_000;
        };
        Future<Object> future = executor.submit(task);
        try {   // Await timeout and errors, then proceed accordingly.
            Object result = future.get(timeout, TimeUnit.SECONDS);
            return result;
        } catch (TimeoutException | InterruptedException ex) {
            return "timeOut";
        } catch (OutOfMemoryError e) {
            return "OutOfMemory";
        } catch (ExecutionException e) {
            return "error";
        } finally {
            future.cancel(true);
            executor.shutdownNow();
        }
    }
}
