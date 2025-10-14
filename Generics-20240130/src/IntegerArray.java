
public class IntegerArray implements IntegerInterface {

    private int[] list;
    
    private int count;  
    
    public IntegerArray( )
    {
        this(10);               // calling the constructor for this class
    }
    
    public IntegerArray( int length )
    {
        list = new int[ length ]; 
        count = 0;
    }

    public int getCount( ) { return count; }
    
    // no setCount method, count is controlled by class
    
    // no getList method, user cannot get entire array
    
    // no setList method, user cannot set the entire array
    
    public int getCapacity( ) { return list.length; }
    
    
    public void add( int newInt )
    {
        if ( count == list.length )
            throw new IllegalArgumentException( "IntArray is full" );
        list[ count++ ] = newInt;
    }
    
    public int get( int index )
    {
        if ( count == 0 )
            throw new IllegalArgumentException( "IntArray is empty" );
        
        if ( index < 0 || index >= count )
            throw new IndexOutOfBoundsException( "Index out of bounds");        
        
        return list[ index ];
    }    
        
    public String toString( )
    {
        String returnString = getClass().getName();
        
        returnString = returnString + ":count = " + count + ":list = [";
            
        for ( int i = 0; i < count; i++ )
            returnString = returnString + " " + list[i] + " ";
        
        returnString += "]";
        
        return returnString;                
    }

    public boolean equals( Object o )
    {
        if ( !( o instanceof IntegerArray ) )
            return false;
        
        IntegerArray intArrayObj = ( IntegerArray ) o;
        
        if ( count != intArrayObj.count )
            return false;
        
        for ( int i = 0; i < count; i++ )
            if ( list[i] != intArrayObj.list[i] )
                return false;
        
        return true;        
    }
}
