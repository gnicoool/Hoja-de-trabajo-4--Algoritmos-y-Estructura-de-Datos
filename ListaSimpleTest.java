import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaSimpleTest {
    private ListaSimple<Integer> listaSimple;

    @BeforeEach
    public void setUp() {
        listaSimple = new ListaSimple<>();
    }

    @Test
    public void testAddAndSize() {
        listaSimple.add(5);
        assertEquals(1, listaSimple.size());
    }

    @Test
    public void testPop() {
        listaSimple.add(5);
        assertEquals((Integer) 5, listaSimple.pop());

        assertEquals(0, listaSimple.size());
    }

    @Test
    public void testClear() {
        listaSimple.add(5);
        listaSimple.clear();
        assertEquals(0, listaSimple.size());
    }

    @Test
    public void testPopFromEmpty() {
        assertNull(listaSimple.pop());
    }
}
