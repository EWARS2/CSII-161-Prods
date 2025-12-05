
/**
 * Lab111
 *
 * Comparator for Employee hired date
 */
public class HiredComparator implements Comparator<Employee> {

    /**
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Employee a, Employee b) {
        Integer valueA = a.getHired();
        Integer valueB = b.getHired();
        return valueA.compareTo(valueB);
    }
}
