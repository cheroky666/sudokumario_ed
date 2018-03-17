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

    /**
     * Metodo toString muestra el resulado final     *
     * @return el resultado
     */
    @Override
    public String toString() {
        String resultadoFinal = "";
        for (int i = 0; i < numeros.size(); i++) {

            for (int b = 0; b < 9; b++) {

                int n = numeros.get(i).get(b);
                resultadoFinal += n + " ";
            }
            resultadoFinal += "\n";

        }

        return resultadoFinal;
    }

    /**
     * modifica un elemento del tablero por el que le pasemos nosotros en la
     * posición que nosotros le pasemos
     *
     * @param fila donde queremos insertar el elemento
     * @param columna donde queremos insertar el elemento
     * @param elemento número que queremos insertar en el tablero
     * @throws SudokuException
     */
    
    
    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException {
        if (puedoInsertar(fila, columna, elemento) == true) {
            numeros.get(fila - 1).set(columna - 1, elemento);
        } else {
            System.out.println("No se puede insertar el número.");
        }

    }

    /**
     * Pone un elemento vacío
     *
     *
     * @param fila donde está el elemento que queremos que este vacío
     * @param columna donde está el elemento que queremos que este vacío
     */
    
    
    public void vaciarElemento(int fila, int columna) {
        numeros.get(fila - 1).set(columna - 1, 0);
    }

    /**
     * Comprueba que él elemento que introducimos no esté repetido en la misma
     * fila
     *
     *
     * @param fila fila donde introducimos el elemento
     * @param elemento elemento que queremos introducir
     * @return true si se puede introducir y false si no se puede introdudcir
     */
    
    
    private boolean comprobarFila(int fila, int elemento) {
        boolean error = true;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(fila - 1).get(i) == elemento) {
                error = false;
            }
        }
        return error;
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
            for (ArrayList<Integer> numero : numeros) {
                if (numeros.get(i).get(columna - 1) == elemento) {
                    resultado = false;
                }
            }
        }
        return resultado;
    }

    /**
     * Comprueba el numero(elemento) en el cuadrante
     *
     * @param fila recive la fina del cuadrante
     * @param columna recive la columna del cuadrante
     * @param elemento numero que vamos a insertar
     * @return sepuede si es true se puede insertar el elemento
     */
    
    
    private boolean comprobarCuadrante(int fila, int columna, int elemento) {
        boolean sepuede = true;
        int v_x = 0, v_y = 0, terminax = 0, terminay = 0;
        int n_cuadrante = 0;
        if (fila >= 0 && fila <= 2) {
            v_x = 0;
            terminax = 2;
        } else if (fila >= 3 && fila <= 5) {
            v_x = 3;
            terminax = 5;
        } else if (fila >= 6 && fila <= 8) {
            v_x = 6;
            terminax = 8;
        }
        if (columna >= 0 && columna <= 2) {
            v_y = 0;
            terminay = 2;
        } else if (columna >= 3 && columna <= 5) {
            v_y = 3;
            terminay = 5;
        } else if (columna >= 6 && columna <= 8) {
            v_y = 6;
            terminay = 8;
        }

        for (int i = v_x; i <= terminax; i++) {
            for (int j = v_y; j <= terminay; j++) {
                if (numeros.get(i).get(j) == elemento) {

                    sepuede = false;

                }

            }
        }

        return sepuede;
    }

    /**
     * Este metodo se encarga de comprobar todos nuestros metodos anteriores
     * para ver si se puede colocar el numero
     *
     *
     * @param fila donde se encuentra el elemento
     * @param columna donde se encuentra el elemento
     * @param elemento que queremos insertar
     * @return true si se puede insertar y false si no se puede insertar
     */
    
    
    private boolean puedoInsertar(int fila, int columna, int elemento) {
        boolean ressult = false;

        if (comprobarFila(fila, elemento) == true && comprobarColumna(columna, elemento) == true && comprobarCuadrante(fila, columna, elemento) == true) {

            ressult = true;

        }
        return ressult;
    }
}
