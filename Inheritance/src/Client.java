
/**
 *
 * An client that demonstrates polymorphism.
 * 
 * @author latimerlocal
 * @version 08/29/2025
 */
public class Client {
    
    public static void main(String[] args) {
        
        // create an instance Salaried
        Salaried salaried1 = new Salaried( 86, "Maxwell", "Agent", 60000 );
        
        // display the contents fo the Salaried instance
        System.out.printf( "salaried1 = %s\n", salaried1.toString() );
        
        // cast the Salaried instance to Employee to demonstrate polymorphism
        Employee employee1 = ( Employee ) salaried1;
                       
        // try to print out the salary from the Employee reference
        // uncomment line below to see compiler error
        //System.out.printf("employee1 salary =  %d" + employee1.getSalary() );
        
        // print out the Employee reference to demonstrate dynamic dispatch

        System.out.println( employee1 );                
        System.out.println( employee1.toString() );                
    }
                
}
