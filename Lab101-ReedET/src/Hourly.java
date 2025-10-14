
/**
 * Subclass
 * 
 * @author Ethan T. Reed
 * @version 09/08/2025
 */
public class Hourly extends Employee {

    private String position;   //  Hourly exclusive field
    private double hourlyRate;     //  Hourly exclusive field
    private static int hourlyEmployeeCount = 0; // Incremented with each instance

    /**
     * Overload constructor
     */
    public Hourly() {
        super(-1, null);
        this.position = null;
        this.hourlyRate = -1;
        hourlyEmployeeCount++;
    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param position
     * @param hourlyRate
     */
    public Hourly(int id, String name, String position, double hourlyRate) {
        super(id, name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        hourlyEmployeeCount++;
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position updates position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return hourlyRate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * @param hourlyRate updates hourlyRate
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * @return number of times constructor has been called
     */
    public int getHourlyEmployeeCount() {
        return hourlyEmployeeCount;
    }

    /**
     * @return contents of instance
     */
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + position + ":" + hourlyRate;
    }

    /**
     * @param o
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hourly)) {
            return false;
        }

        Hourly s = (Hourly) o;

        return super.equals(s)
                && position.equals(s.position)
                && hourlyRate == s.hourlyRate;
    }
}
