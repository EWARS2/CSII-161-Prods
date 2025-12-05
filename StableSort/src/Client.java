
import java.util.Random;


public class Client {

    public static void main(String[] args) {

        Person[] people;
        Comparator compFirst  = new FirstComparator();        
        Comparator compMiddle = new MiddleComparator();       
        Comparator compLast   = new LastComparator();               
        
        people = createPeopleArray();       
        printArray( people, "Initial Order" );

        Sort.bubbleSort1( people, compLast);
        printArray( people, "Sorted on Last Name Array" );        
 
        Sort.bubbleSort1( people, compFirst);
        printArray( people, "Sorted on First Name Array" );        
        
        Sort.bubbleSort1( people, compMiddle);
        printArray( people, "Sorted on Middle Initial Array" );                

        System.out.println("========================================================");
        System.out.println("============  Try One, using BubbleSort1  ==============");
        System.out.println("========================================================");
        people = createPeopleArray();         
        printArray( people, "Initial Order" );        
        Sort.bubbleSort1( people, compMiddle);
        printArray( people, "Sorted on Middle Initial Array" );                
        Sort.bubbleSort1( people, compFirst);
        printArray( people, "Sorted on First Name Array" );       
        Sort.bubbleSort1( people, compLast);
        printArray( people, "Sorted on Last Name Array" );                
        
        System.out.println("========================================================");
        System.out.println("============  Try Two, using BubbleSort2  ==============");
        System.out.println("========================================================");
        people = createPeopleArray();         
        printArray( people, "Initial Order" );        
        Sort.bubbleSort2( people, compMiddle);
        printArray( people, "Sorted on Middle Initial Array" );                
        Sort.bubbleSort2( people, compFirst);
        printArray( people, "Sorted on First Name Array" );       
        Sort.bubbleSort2( people, compLast);
        printArray( people, "Sorted on Last Name Array" );                       
        
        System.out.println("========================================================");
        System.out.println("============  Try Three, using RadixSort  ==============");
        System.out.println("========================================================");
        people = createPeopleArray();    
        printArray( people, "Initial Order" );
        Sort.radixSort( people, compLast, compFirst, compMiddle);
        printArray( people, "Sorted using radix sort" );                               

        System.out.println("========================================================");
        System.out.println("============  Try Three, using RadixSort  ==============");
        System.out.println("========================================================");
        people = createPeopleArray();    
        scrambleArray( people );
        printArray( people, "Initial Scrambled Order" );
        Sort.radixSort( people, compLast, compFirst, compMiddle);
        printArray( people, "Sorted using radix sort" );                                       
    }





    
public static Person[] createPeopleArray( )    
{
        Person[] people = {
            new Person("Jane", "A", "Doe"),
            new Person("Jane", "B", "Doe"),
            new Person("Jane", "C", "Doe"),
            new Person("John", "A", "Doe"),
            new Person("John", "B", "Doe"),
            new Person("John", "C", "Doe"),
            new Person("Jane", "A", "Smith"),            
            new Person("Jane", "B", "Smith"),                    
            new Person("Jane", "C", "Smith"),                           
            new Person("John", "A", "Smith"),
            new Person("John", "B", "Smith"),                
            new Person("John", "C", "Smith"),        
        };
        
        return people;
}
               
    public static void printArray( Person[] data, String title )
    {
        System.out.printf( "==========  %s  ==========\n", title );
        for ( int i = 0; i < data.length; i++ )
        {
            System.out.println( data[i].toString() );
        }
    }
    
    public static void scrambleArray( Person[] data )
    {
        Random rand = new Random();
        
        for ( int i = 0; i < data.length; i++ )
        {
            data[i].setOrder( rand.nextDouble() );;            
        }        
        
        for ( int i = 0; i < data.length; i++ )
        {
            for ( int j = 0; j < data.length - 1; j++ )
            {
                if ( data[j].getOrder() > data[j + 1].getOrder() )
                {
                    Person temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }                            
    }

}
