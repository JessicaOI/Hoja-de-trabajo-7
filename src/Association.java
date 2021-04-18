public class Association<K,V> implements MapEntry<K,V>{

    protected K theKey;
    //the key of the key-value pair
    protected V theValue;
    //the value of the key-value pair


    public Association(K key, V value)
    {
        theKey = key;
        theValue = value;
    }

    public Association(K key)
    {
        this(key,null);
    }

    //compara las llaves
    @Override
    public boolean equals(Object obj) {
        Association otherAssoc = (Association)obj;
        return getKey().equals(otherAssoc.getKey());
    }

    /*implenta las funciones ed hashcode (
    Si los métodos hashcode de cada objeto devuelven diferente hash no seguirá comparando y considerará a los objetos distintos.
    En el caso en el que ambos objetos compartan el mismo hashcode Java invocará al método equals() y revisará a detalle si se cumple la igualdad.
     */

    @Override
    public int hashCode() {
        return getKey().hashCode();
    }

    //da la llave
    @Override
    public K getKey() {
        return theKey;
    }

    //da el valor
    @Override
    public V getValue() {
        return theValue;
    }

    //da el vaor de la pareja key-value
    @Override
    public V setValue(V value) {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }
    //cadena de string
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}
