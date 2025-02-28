import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    private Calculadora<Double> calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = Calculadora.getInstance();
    }

    @Test
    public void testSingleton() {
        Calculadora<Double> otraCalculadora = Calculadora.getInstance();
        assertSame(calculadora, otraCalculadora, "Debe devolver la misma instancia (Singleton)");
    }

    @Test
    public void testSuma() {
        assertEquals(5.5, calculadora.suma(2.5, 3.0), 0.0001);
        assertEquals(-1.0, calculadora.suma(-3.0, 2.0), 0.0001);
    }

    @Test
    public void testResta() {
        assertEquals(1.5, calculadora.resta(5.0, 3.5), 0.0001);
        assertEquals(-5.0, calculadora.resta(-3.0, 2.0), 0.0001);
    }

    @Test
    public void testMultiplicacion() {
        assertEquals(6.0, calculadora.multiplicacion(2.0, 3.0), 0.0001);
        assertEquals(-6.0, calculadora.multiplicacion(-2.0, 3.0), 0.0001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculadora.division(6.0, 3.0), 0.0001);
        assertThrows(ArithmeticException.class, () -> calculadora.division(6.0, 0.0));
    }

    @Test
    public void testModulo() {
        assertEquals(1.0, calculadora.modulo(7.0, 3.0), 0.0001);
        assertThrows(ArithmeticException.class, () -> calculadora.modulo(6.0, 0.0));
    }

    @Test
    public void testIsOperator() {
        assertTrue(calculadora.isOperator('+'));
        assertTrue(calculadora.isOperator('-'));
        assertFalse(calculadora.isOperator('&'));
    }
}
