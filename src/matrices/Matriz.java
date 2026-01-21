/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrices;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author galvez
 */
public class Matriz {
    private int[][]datos;
    private Random rnd = new Random();
    
    public Matriz(int filas, int columnas, boolean inicializarAleatorio){
        datos = new int[columnas][];
        for(int i=0; i<columnas; i++){
            datos[i] = new int[filas];
            if (inicializarAleatorio)
                for(int j=0; j<filas; j++)
                    datos[i][j] = rnd.nextInt(100);
        }
    }
    public Matriz(Dimension d, boolean inicializarAleatorio){
        this(d.height, d.width, inicializarAleatorio);
    }
    
    public Dimension getDimension(){
        return new Dimension(datos.length, datos[0].length);
    }
    
    public static Matriz multiplicarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles { 
        if(a.getDimension().width != b.getDimension().height) 
            throw new DimensionesIncompatibles("La multiplicación de matrices requiere las misma cantidad de columnas de A, que de filas de B.");        
    
        int filasA = a.getDimension().height;
        int columnasA = a.getDimension().width;
        int columnasB = b.getDimension().width;

        Matriz resultado = new Matriz(filasA, columnasB, false);

        for (int i = 0; i < columnasB; i++) {
            for (int j = 0; j < filasA; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado.datos[i][j] += a.datos[k][j] * b.datos[i][k];
                }
            }
        }

        return resultado;
    }     

    public static Matriz invertir(Matriz m) {

    int filas = m.getDimension().height;
    int columnas = m.getDimension().width;

    // La transpuesta invierte filas y columnas
    Matriz t = new Matriz(columnas, filas, false);

    for (int i = 0; i < columnas; i++) {
        for (int j = 0; j < filas; j++) {
            t.datos[j][i] = m.datos[i][j];
        }
    }

    return t;
}

    
    public static Matriz sumarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles { 
        if(! a.getDimension().equals(b.getDimension())) throw new DimensionesIncompatibles("La suma de matrices requiere matrices de las mismas dimensiones");        
        int i, j, filasA, columnasA; 
        filasA = a.getDimension().height; 
        columnasA = a.getDimension().width; 
        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (j = 0; j < filasA; j++) { 
            for (i = 0; i < columnasA; i++) { 
                matrizResultante.datos[i][j] += a.datos[i][j] + b.datos[i][j]; 
            } 
        } 
        return matrizResultante; 
    } 

    @Override
    public String toString(){
        String ret = "";
        ret += "[\n";

        for (int j = 0; j < getDimension().height; j++) { // filas
            ret += "(";
            for (int i = 0; i < getDimension().width; i++) { // columnas
                ret += String.format("%3d", datos[i][j]);
                if (i != getDimension().width - 1) ret += ", ";
            }
            ret += ")";
            if (j != getDimension().height - 1) ret += ",";
            ret += "\n";
        }

        ret += "]\n";
        return ret;
    }
}
