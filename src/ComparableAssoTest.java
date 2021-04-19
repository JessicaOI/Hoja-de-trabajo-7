import org.junit.jupiter.api.Test;

class ComparableAssoTest {

    String key = "key";
    String valor = "valor";
    ComparableAsso ca = new ComparableAsso(key,valor);
    @Test
    void process() {

        System.out.println(ca.toString());

    }
}