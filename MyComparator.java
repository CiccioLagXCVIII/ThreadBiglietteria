import java.util.Comparator;
class MyComparator implements Comparator<Cliente>{
    //Overriding compare() method of Comparator for descending order of priority
    public int compare(Cliente c1, Cliente c2) {
        if (c1.tipoPagamento < c2.tipoPagamento){
            return 1;
        } else if (c1.tipoPagamento > c2.tipoPagamento){
            return -1;
        }
        return 0;
    }
}