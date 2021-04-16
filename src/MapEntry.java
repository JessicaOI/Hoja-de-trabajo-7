// ejmplo visto en clase

public interface MapEntry<K,V> {

    public boolean equals (Object o);
    //post: returns tru if this ntry <K,V> is equal to object o

    public K getKey();
    //post: retuns the key K of this entry

    public V getValue();
    //post: returns the value V of the entry

    public int hashCode();
    //post: returns the hashcode for the key

    public V setValue(V value);
    //post: replaces the Vale od this entry

}
