
/**
 * Lab111
 *
 * Comparator for Employee names
 */
public class NameComparator implements Comparator<Employee> {

    /**
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Employee a, Employee b) {
        String valueA = a.getName();
        String valueB = b.getName();
        return valueA.compareTo(valueB);
    }
}
