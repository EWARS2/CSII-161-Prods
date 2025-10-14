
/**
 *
 * @author Joe Latimer
 * @version 08/29/2025
 * an example of a subclass.
 */
public class Salaried extends Employee {
    
    private String title;   //  the title
    private int salary;     //  the salary
    
    /**
     * 
     * @param id
     * @param name
     * @param title
     * @param salary 
     */
    public Salaried( int id, String name, String title, int salary )
    {
        super( id, name );
        this.title = title;
        this.salary = salary;
    }
    
    /**
     * 
     * @return title
     */
    public String getTitle( ) { return title; }
    
    /**
     * 
     * @param title updates title
     */
    public void setTitle( String title ) { this.title = title; }
    
    /**
     * 
     * @return salary
     */
    public int getSalary( ) { return salary; }
    
    /**
     * 
     * @param salary updates salary
     */
    public void setSalary( int salary ) { this.salary = salary; }
    
    /**
     * 
     * @return contents of instance
     */
    public String toString()
    {
        return super.toString() + ":" + getClass().getName() + "@" + title + ":" + salary;
    }
    
    /**
     * 
     * @param o
     * @return true if equal, false otherwise
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Salaried ) )
            return false;
        
        Salaried s = ( Salaried ) o;
        
        return super.equals( s )
                && title.equals( s.title )
                && salary == s.salary;
    }    
}
