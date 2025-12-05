    
    public class LastComparator implements Comparator<Person> {
    
    public int compare( Person a, Person b ){
        
        String valueA = a.getLast();
        String valueB = b.getLast();
        
        return valueA.compareTo( valueB );
        
    }
}

    

