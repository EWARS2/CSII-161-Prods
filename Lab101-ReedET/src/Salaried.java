
/**
 * Subclass
 * 
 * @author Ethan T. Reed
 * @version 09/08/2025
 */
public class Salaried extends Employee {

    private String title;   //  Salaried exclusive field
    private double salary;     //  Salaried exclusive field
    private static int salariedEmployeeCount = 0; // Incremented with each instance

    /**
     * Overload constructor
     */
    public Salaried() {
        super(-1, null);
        this.title = null;
        this.salary = -1;
        salariedEmployeeCount++;
    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param title
     * @param salary
     */
    public Salaried(int id, String name, String title, double salary) {
        super(id, name);
        this.title = title;
        this.salary = salary;
        salariedEmployeeCount++;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title updates title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary updates salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return number of times constructor has been called
     */
    public int getSalariedEmployeeCount() {
        return salariedEmployeeCount;
    }

    /**
     * @return contents of instance
     */
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + title + ":" + salary;
    }

    /**
     * @param o
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Salaried)) {
            return false;
        }

        Salaried s = (Salaried) o;

        return super.equals(s)
                && title.equals(s.title)
                && salary == s.salary;
    }
}
