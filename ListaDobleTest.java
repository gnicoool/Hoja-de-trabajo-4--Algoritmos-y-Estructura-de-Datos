import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaDobleTest {
    private ListaDoble<Integer> listaDoble;

    @BeforeEach
    public void setUp() {
        listaDoble = new ListaDoble<>();
    }

    @Test
    public void testAddAndSize() {
        listaDoble.add(20);
        assertEquals(1, listaDoble.size());
    }

    @Test
    public void testPop() {
        listaDoble.add(20);
        assertEquals((Integer) 20, listaDoble.pop());
        assertEquals(0, listaDoble.size());
    }

    @Test
    public void testClear() {
        listaDoble.add(20);
        listaDoble.clear();
        assertEquals(0, listaDoble.size());
    }

    @Test
    public void testPopFromEmpty() {
        assertNull(listaDoble.pop());
    }
}