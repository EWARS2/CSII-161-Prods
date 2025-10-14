
/**
 *
 * @author joseph.latimer
 */
public interface IntegerInterface {

    public int getCount( );
    
    // no setCount method, count is controlled by class
    
    // no getList method, user cannot get entire array
    
    // no setList method, user cannot set the entire array
    
    public int getCapacity( );
        
    public void add( int newInt ) throws IllegalArgumentException;
    
    public int get( int index ) throws IllegalArgumentException;
    
    public String toString( );

    public boolean equals( Object o );
   

    

    
    
    
    
    
    
    
    
    
    
    
    
    
}
