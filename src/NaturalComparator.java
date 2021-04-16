import java.util.Comparator;

public class NaturalComparator<E extends Comparable<E>> implements Comparator<E> {


    @Override
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof NaturalComparator);
    }
}
