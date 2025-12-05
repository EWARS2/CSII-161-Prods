public class FirstComparator implements Comparator<Person> {
    
    public int compare( Person a, Person b ){
        
        String valueA = a.getFirst();
        String valueB = b.getFirst();
        
        return valueA.compareTo( valueB );
        
    }
}
