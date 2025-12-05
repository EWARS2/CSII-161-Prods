
/**
 * Lab111
 *
 * Comparator for Employee department
 */
public class DeptComparator implements Comparator<Employee> {

    /**
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Employee a, Employee b) {
        Integer valueA = a.getDept();
        Integer valueB = b.getDept();
        return valueA.compareTo(valueB);
    }
}
