import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ALTest {
    private AL<Integer> al;

    @BeforeEach
    public void setUp() {
        al = new AL<>();
    }

    @Test
    public void testAddAndSize() {
        al.add(40);
        assertEquals(1, al.size());
    }

    @Test
    public void testPop() {
        al.add(40);
        assertEquals((Integer) 40, al.pop());
        assertEquals(0, al.size());
    }

    @Test
    void testClear() {
        al.add(40);
        al.clear();
        assertEquals(0, al.size());
    }

    @Test
    void testPopFromEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> al.pop());
    }
}
