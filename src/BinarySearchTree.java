
//codigo sacado del libro de texto y clase de algoritmos

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>>

{
    //referencia a la raiz
    protected BinaryTree<E> root;

    //el nodo
    protected final BinaryTree<E> EMPTY = new BinaryTree<E>();

    //el numero de nodos en el arbol
    protected int count;

    //usar el ordering en este buscador de arbol
    protected Comparator<E> ordering;



    public BinarySearchTree()
    {
        this(new NaturalComparator<E>());
    }
    // post: constructs an empty binary search tree

    public BinarySearchTree(Comparator<E> alternateOrder)
    {
        root = EMPTY;
        count = 0;
        ordering = alternateOrder;
    }
    // post: constructs an empty binary search tree

    public boolean isEmpty()
    {
        return root == EMPTY;
    }
    // post: returns true iff the binary search tree is empty
    public void clear()
    {
        root = new BinaryTree<E>();
        count = 0;
    }
    // post: removes all elements from binary search tree
    public int size()
    {
        return count;
    }
    // post: returns the number of elements in binary search tree

    protected BinaryTree<E> locate(BinaryTree<E> root, E value)
    {
        E rootValue = root.value();
        BinaryTree<E> child;

        //encontrar en la raiz
        if(rootValue.equals(value))
            return root;
        if(ordering.compare(rootValue,value) < 0)
        {
            child = root.right();
        }
        else
        {
            child = root.left();
        }
        //si ya no hay hijos regresar el nodo, sino seguir buscando
        if(child.isEmpty())
        {
            return root;
        }
        else
        {
            return locate(child, value);
        }
    }

    protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }

    protected BinaryTree<E> successor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.right();
        while (!result.left().isEmpty()) {
            result = result.left();
        }
        return result;
    }

    public void add(E value) {
        BinaryTree<E> newNode = new BinaryTree<E>(value, EMPTY, EMPTY);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty()) {
            root = newNode;
        } else {
            BinaryTree<E> insertLocation = locate(root, value);
            E nodeValue = insertLocation.value();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            if (ordering.compare(nodeValue, value) < 0) {
                insertLocation.setRight(newNode);
            } else {
                if (!insertLocation.left().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRight(newNode);
                } else {
                    insertLocation.setLeft(newNode);
                }
            }
        }
        count++;
    }

}
