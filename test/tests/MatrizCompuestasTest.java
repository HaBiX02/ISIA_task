package tests;

import matrices.DimensionesIncompatibles;
import matrices.Matriz;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrizCompuestasTest {

    @Test
    public void traspuestaDeTraspuesta_esLaOriginal() {
        Matriz z = new Matriz(new int[][]{
            { 1,  2,  3},
            { 4,  5,  6},
            { 7,  8,  9}
        });

        Matriz zt = Matriz.invertir(z);
        Matriz ztt = Matriz.invertir(zt);

        // Sin equals(): comparamos por toString()
        assertEquals(z.toString(), ztt.toString());
    }

    @Test
    public void traspuestaDelProducto_esProductoDeTraspuestas() throws DimensionesIncompatibles {
        Matriz z = new Matriz(new int[][]{
            {1, 2, 3},
            {0, 1, 4},
            {5, 6, 0}
        });

        Matriz q = new Matriz(new int[][]{
            { -2, 1, 0},
            {  3, 0, 1},
            {  4, 2, 1}
        });

        Matriz prod = Matriz.multiplicarDosMatrices(z, q);       // Z·Q
        Matriz izq = Matriz.invertir(prod);                      // (Z·Q)^T

        Matriz qt = Matriz.invertir(q);                          // Q^T
        Matriz zt = Matriz.invertir(z);                          // Z^T
        Matriz der = Matriz.multiplicarDosMatrices(qt, zt);      // Q^T · Z^T

        // Sin equals(): comparamos por toString()
        assertEquals(izq.toString(), der.toString());
    }
}
