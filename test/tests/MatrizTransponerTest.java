package tests;

import matrices.Matriz;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrizTransponerTest {

    @Test
    public void trasponer_3x3_resultadoEsperado() {
        Matriz m = new Matriz(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });

        Matriz esperado = new Matriz(new int[][]{
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        });

        Matriz resultado = Matriz.invertir(m);

        // Como Matriz no tiene equals, comparamos por toString()
        assertEquals(esperado.toString(), resultado.toString());
    }
}
