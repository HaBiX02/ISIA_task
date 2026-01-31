package tests;

import matrices.DimensionesIncompatibles;
import matrices.Matriz;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrizMultiplicarTest {

    @Test
    public void multiplicar_dimensionesIncompatibles_lanzaExcepcion() {
        // A = 2x3 (filas=2, columnas=3)
        Matriz a = new Matriz(2, 3, false);

        // B = 4x2 (filas=4, columnas=2)
        Matriz b = new Matriz(4, 2, false);

        // Columnas(A)=3, Filas(B)=4 -> incompatibles
        assertThrows(DimensionesIncompatibles.class, () -> {
            Matriz.multiplicarDosMatrices(a, b);
        });
    }

    @Test
    public void multiplicar_3x3_resultadoEsperado() throws DimensionesIncompatibles {
        // Usamos el constructor Matriz(int[][] valores) que añadiste:
        Matriz a = new Matriz(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });

        Matriz b = new Matriz(new int[][]{
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        });

        Matriz esperado = new Matriz(new int[][]{
            { 30,  24,  18},
            { 84,  69,  54},
            {138, 114,  90}
        });

        Matriz resultado = Matriz.multiplicarDosMatrices(a, b);

        // Como Matriz no tiene equals, comparamos por toString()
        // (Alternativa mejor: implementar get() y comparar celda a celda)
        assertEquals(esperado.toString(), resultado.toString());
    }
}
