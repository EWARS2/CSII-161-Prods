   
    public class MiddleComparator implements Comparator<Person> {
    
    public int compare( Person a, Person b ){
        
        String valueA = a.getMiddle();
        String valueB = b.getMiddle();
        
        return valueA.compareTo( valueB );
        
    }
}

    
