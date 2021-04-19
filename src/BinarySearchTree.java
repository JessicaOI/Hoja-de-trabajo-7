
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


    /**
     * Determines if the binary search tree contains a value
     *
     * @post Returns true iff val is a value found within the tree
     *
     * @param value The value sought.  Should be non-null
     * @return True iff the tree contains a value "equals to" sought value
     */
    public boolean contains(E value)
    {
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.value());
    }

    /**
     * Returns reference to value found within three.  This method can
     * be potentially dangerous if returned value is modified: if
     * modification would change the relation of value to others within
     * the tree, the consistency of the structure is lost
     * <b>Don't modify returned value</b>
     *
     * @post Returns object found in tree, or null
     *
     * @param value Value sought from within tree
     * @return A value "equals to" value sought; otherwise null
     */
    public E get(E value)
    {
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = locate(root,value);
        if (value.equals(possibleLocation.value()))
            return possibleLocation.value();
        else
            return null;
    }

    /**
     * Remove an value "equals to" the indicated value.  Only one value
     * is removed, and no guarantee is made concerning which of duplicate
     * values are removed.  Value returned is no longer part of the
     * structure
     *
     * @post Removes one instance of val, if found
     *
     * @param value Value sought to be removed from tree
     * @return Actual value removed from tree
     */
    public E remove(E value)
    {
        if (isEmpty()) return null;

        if (value.equals(root.value())) // delete root value
        {
            BinaryTree<E> newroot = removeTop(root);
            count--;
            E result = root.value();
            root = newroot;
            return result;
        }
        else
        {
            BinaryTree<E> location = locate(root,value);

            if (value.equals(location.value())) {
                count--;
                BinaryTree<E> parent = location.parent();
                if (parent.right() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
                return location.value();
            }
        }
        return null;
    }

    /**
     * Removes the top node of the tree rooted, performs the necissary
     * rotations to reconnect the tree.
     *
     * @pre topNode contains the value we want to remove
     * @post We return an binary tree rooted with the predecessor of topnode.
     * @param topNode Contains the value we want to remove
     * @return The root of a new binary tree containing all of topNodes
     * descendents and rooted at topNode's predecessor
     */
    protected BinaryTree<E> removeTop(BinaryTree<E> topNode)
    {
        // remove topmost BinaryTree from a binary search tree
        BinaryTree<E> left  = topNode.left();
        BinaryTree<E> right = topNode.right();
        // disconnect top node
        topNode.setLeft(EMPTY);
        topNode.setRight(EMPTY);
        // Case a, no left BinaryTree
        //   easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right BinaryTree
        //   easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        //   easy: make right subtree of left
        BinaryTree<E> predecessor = left.right();
        if (predecessor.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        BinaryTree<E> parent = left;
        while (!predecessor.right().isEmpty())
        {
            parent = predecessor;
            predecessor = predecessor.right();
        }
        // Assert: predecessor is predecessor of root
        parent.setRight(predecessor.left());
        predecessor.setLeft(left);
        predecessor.setRight(right);
        return predecessor;
    }

    /**
     * Returns an iterator over the binary search tree.  Iterator should
     * not be used if tree is modified, as behavior may be unpredicatable
     * Traverses elements using in-order traversal order
     *
     * @post Returns iterator to traverse BST
     *
     * @return An iterator over binary search tree
     */
    public void iterator()
    {
        root.inorderIterator(this.root);
    }

    /**
     * Returns the hashCode of the value stored by this object.
     *
     * @return The hashCode of the value stored by this object.
     */
    public int hashCode(){
        return root.hashCode();
    }

    /**
     * Returns a (possibly long) string representing tree.  Differs
     * from {@link #toString()} in that {@link #toString()} outputs
     * a single line representation of the contents of the tree.
     * <code>treeString</code>, however, prints out a graphical
     * representations of the tree's <i>structure</i>.
     *
     * @post Generates a string representation of the AVLST
     * @return String representation of tree
     */
    public String treeString(){
        return root.treeString();
    }

    /**
     * Returns a string representing tree
     *
     * @post Generates a string representation of the BST
     *
     * @return String representation of tree
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<BinarySearchTree:");
        if (!root.isEmpty()) {
            s.append(root);
        }
        s.append(">");
        return s.toString();
    }

}
