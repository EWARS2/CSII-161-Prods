/**
 * Lab111
 *
 * Comparator for Employee names
 */
public class IDComparator implements Comparator<Employee> {

    /**
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Employee a, Employee b) {
        Integer valueA = a.getId();
        Integer valueB = b.getId();
        return valueA.compareTo(valueB);
    }
}
