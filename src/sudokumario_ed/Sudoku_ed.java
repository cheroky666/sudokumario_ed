/*
- * To change this license header, choose License Headers in Project Properties.
- * To change this template file, choose Tools | Templates
- * and open the template in the editor.
 */
package sudokumario_ed;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mario
 */
public class Sudoku_ed {

    // Variables privadas de la clase
    private ArrayList<ArrayList<Integer>> numeros;
    private Random aleatorio;

    public Sudoku_ed() {
        numeros = new ArrayList<>();
    }

    public void inicializar() {
        numeros = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> n2 = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                n2.add(0);
            }

            numeros.add(n2);
        }

        aleatorio = new Random();
    }

    @Override
    public String toString() {
        String resultadoFinal = "";

        return resultadoFinal;
    }

    public void modificarElemento(int fila, int columna, int elemento) throws
            SudokuException {

    }

    public void vaciarElemento(int fila, int columna) {

    }

    private boolean comprobarFila(int fila, int elemento) {
        boolean resultado = true;

        return resultado;
    }

    /**
     * metodo comprobar la columna
     *
     * @param columna columna del tablero
     * @param elemento numero que añadimos
     * @return true o false depende de si no aparece el numero en la columna
     */
    private boolean comprobarColumna(int columna, int elemento) {

        boolean resultado = true;
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = 0; j < numeros.size(); j++) {
                if (numeros.get(i).get(columna - 1) == elemento) {
                    resultado = false;
                }
            }
        }
        return resultado;
    }

    private boolean comprobarCuadrante(int fila, int columna, int elemento) {
        boolean resultado = true;

        return resultado;
    }

    private boolean puedoInsertar(int fila, int columna, int elemento) {
        boolean resultado = false;

        return resultado;
    }
}
