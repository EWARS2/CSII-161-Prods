
public class Client {

    public static void main(String[] args) {
        
        IntegerArray intArray = new IntegerArray( );
        
        intArray.add( 55 );
        intArray.add( 37 );
        
        System.out.println( intArray );
        
        System.out.println("\n==========\n");
        System.out.println("Using the Generic Class and ");
        System.out.println("fixing the Class for the generic placeholder.");
        
        GenericArray<Employee> employeeArray = new GenericArray<>();
                
        employeeArray.add( new Employee( 111, "Sue" ) );
        
        employeeArray.add( new Employee( 222, "Bob") );
        
        System.out.println( employeeArray );
        
        
    }
    
}
