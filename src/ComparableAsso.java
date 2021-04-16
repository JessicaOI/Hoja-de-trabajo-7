public class ComparableAsso<K extends Comparable<K>,V>
        extends Association<K,V>
        implements Comparable<ComparableAsso<K,V>>
        ,MapEntry<K,V> {

    //set null en el contructor
    public ComparableAsso(K key)
    {
        this(key, null);
    }

    public ComparableAsso(K key, V value)
    {
        super(key, value);
    }

    //determina la comparación
    //determinar el orden de dos comparable assocation, basado en la llave
    public int compareTo(ComparableAsso<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    //string del comparable association
}
