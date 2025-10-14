
/**
 * Lab103 Example user-defined class with data
 *
 * @author Ethan T. Reed
 * @version 2025/09/19
 */
import java.util.Objects;

public class Player {

    private String name;
    private String position_played;
    private int jersey_number;

    /**
     * Default constructor
     */
    public Player() {
        this.jersey_number = -1;
    }

    /**
     * Overloaded constructor
     *
     * @param name
     * @param position_played
     * @param jersey_number
     */
    public Player(String name, String position_played, int jersey_number) {
        this.name = name;
        this.position_played = position_played;
        this.jersey_number = jersey_number;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return position_played
     */
    public String getPositionPlayed() {
        return this.position_played;
    }

    /**
     * @param position_played
     */
    public void setPositionPlayed(String position_played) {
        this.position_played = position_played;
    }

    /**
     * @return jersey_number
     */
    public int getJerseyNumber() {
        return this.jersey_number;
    }

    /**
     * @param jersey_number
     */
    public void setJerseyNumber(int jersey_number) {
        this.jersey_number = jersey_number;
    }

    /**
     * @return string representing Player
     */
    @Override
    public String toString() {
        // There's definetely a way to put this into a loop,
        // but I haven't figured it out yet, hang on.
        // I'm running outta time to work on this too...
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(name);
        sb.append(", ");
        sb.append(position_played);
        sb.append(", ");
        sb.append(jersey_number);
        sb.append("]");
        return sb.toString();
    }

    /**
     * @param o object to compare this against
     * @return whether compared objects equate
     */
    @Override
    public boolean equals(Object o) {
        // This relies on toString.
        // Why? Because I'm not writing out all of the instance vars twice.
        return Objects.equals(this.toString(), o.toString());
    }

}
