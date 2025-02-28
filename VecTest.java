import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VecTest {
    private Vec<Integer> vec;

    @BeforeEach
    public void setUp() {
        vec = new Vec<>(5);
    }

    @Test
    public void testAddAndSize() {
        vec.add(30);
        assertEquals(1, vec.size());
    }

    @Test
    public void testPop() {
        vec.add(30);
        assertEquals((Integer) 30, vec.pop());
        assertEquals(0, vec.size());
    }

    @Test
    public void testClear() {
        vec.add(30);
        vec.clear();
        assertEquals(0, vec.size());
    }

    @Test
    public void testPopFromEmpty() {
        assertNull(vec.pop());
    }
}
