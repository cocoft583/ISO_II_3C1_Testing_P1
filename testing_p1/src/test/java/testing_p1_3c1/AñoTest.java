package testing_p1_3c1;

import static org.junit.Assert.*;
import org.junit.Test;

public class AñoTest {

    // --- PRUEBAS DE CONSTRUCTOR ---

    // NOTA: Veo que tienes un archivo 'FechaInvalidaException.java'.
    // Si tu clase Año lanza esa excepción en lugar de IllegalArgumentException,
    // cambia 'IllegalArgumentException.class' por 'FechaInvalidaException.class' aquí abajo.

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_Invalido_MenorQueMenos45() throws FechaInvalidaException {
        // Valor según tabla de equivalencia
        new Año(-80); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_Invalido_Cero() throws FechaInvalidaException {
        // Valor según tabla de equivalencia
        new Año(0);
    }
    
    @Test
    public void testConstructor_Valido_LimiteInferior() throws FechaInvalidaException {
        Año a = new Año(-45);
        assertEquals(-45, a.getAño());
    }

    // --- PRUEBAS DE BISIESTOS ---

    @Test
    public void testBisiesto_Multiplo400() throws FechaInvalidaException {
        Año a = new Año(2000);
        assertTrue(a.esBisiesto());
    }

    @Test
    public void testBisiesto_Multiplo4_No100() throws FechaInvalidaException {
        Año a = new Año(2004);
        assertTrue(a.esBisiesto());
    }

    @Test
    public void testNoBisiesto_Multiplo100_No400() throws FechaInvalidaException {
        Año a = new Año(1900);
        assertFalse(a.esBisiesto());
    }

    @Test
    public void testNoBisiesto_NoMultiplo4() throws FechaInvalidaException {
        Año a = new Año(2001);
        assertFalse(a.esBisiesto());
    }

    // --- COBERTURA EACH USE (Resto de valores) ---
    
    @Test
    public void testRestoDeValoresEquivalencia() throws FechaInvalidaException {
        int[] valores = {-20, -9, -3, 7, 8, 50, 1582, 1700};
        
        for (int v : valores) {
            Año a = new Año(v);
            assertEquals(v, a.getAño());
            a.esBisiesto(); 
        }
    }
}