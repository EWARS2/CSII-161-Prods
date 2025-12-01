
import java.util.Objects;

/**
 * Lab111
 *
 * Employee class
 *
 * @author Ethan T. Reed
 * @version 2025/12/5
 */
public class Employee {

    private int id;    // 0 to 99,999,999
    private String name;
    private int dept;       // 1 to 5 inclusive
    private int hired;      // 2008 to 2018 inclusive

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param dept
     * @param hired
     */
    public Employee(int id, String name, int dept, int hired) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.hired = hired;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
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
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return dept
     */
    public int getDept() {
        return dept;
    }

    /**
     * @param dept
     */
    public void setDept(int dept) {
        this.dept = dept;
    }

    /**
     * @return hired
     */
    public int getHired() {
        return hired;
    }

    /**
     * @param hired
     */
    public void setHired(int hired) {
        this.hired = hired;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", dept=" + dept
                + ", hired=" + hired + '}';
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + this.dept;
        hash = 47 * hash + this.hired;
        return hash;
    }

    /**
     * @param obj
     * @return Boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.dept != other.dept) {
            return false;
        }
        if (this.hired != other.hired) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
}