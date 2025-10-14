/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author latimerlocal
 */
public interface GenericInterface<T> {
  
    public int getCount( );
    
    // no setCount method, count is controlled by class
    
    // no getList method, user cannot get entire array
    
    // no setList method, user cannot set the entire array
    
    public int getCapacity( );
        
    public void add( T newInt ) throws IllegalArgumentException;
    
    public T get( int index ) throws IllegalArgumentException, IndexOutOfBoundsException;
       
    public String toString( );

    public boolean equals( Object o );
   
    
    
}
