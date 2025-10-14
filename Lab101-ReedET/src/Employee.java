
/**
 * Superclass
 * 
 * @author Ethan T. Reed
 * @version 09/08/2025
 */
public class Employee {

    private int id; // Common field
    private String name; // Common field
    private static int employeeCount = 0; // Incremented with each instance

    /**
     * Overload constructor
     */
    public Employee() {
        this.id = -1;
        this.name = null;
        employeeCount++;
    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     */
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        employeeCount++;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id updates id instance variable
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name updates name instance variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return number of times constructor has been called
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     * @return contents of Employee instance
     */
    public String toString() {
        return getClass().getName() + "@" + id + ":" + name + ":" + employeeCount;
    }

    /**
     * @param o object to be compared
     * @return true if objects equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee e = (Employee) o;

        return id == e.id
                && name.equals(e.name);
    }
}
