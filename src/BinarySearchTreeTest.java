import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    String key = "key";
    String valor = "valor";
    BinaryTree bt = new BinaryTree(valor);
    BinarySearchTree bst = new BinarySearchTree();
    ComparableAsso ca = new ComparableAsso(key,valor);
    @Test
    void process() {

        BinaryTree encontrar = bst.locate(bt, valor);

    }

}