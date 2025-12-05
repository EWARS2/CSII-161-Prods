
public class Person {
    
    private String last;
    private String first;
    private String middle;
    private double order;
    
    public Person( String first, String middle, String last ){
        this.first = first;
        this.middle = middle;
        this.last = last;
        order = 0.0;        
    }
    
    public String getFirst() { return first; }
    public String getMiddle() { return middle; }
    public String getLast() { return last; }                
    public double getOrder() { return order; } 
    public void setOrder( double order ) { this.order = order; }
    
    public String toString( ) { 
        return last + ",\t" + first + "\t" + middle;
    }
            
    
}
