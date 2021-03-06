/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokumario_ed;

import java.util.Scanner;

/**
 *
 * @author mario
 */
public class Sudokumario_ed_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        {

            Scanner teclado = new Scanner(System.in);
            Sudoku_ed s = new Sudoku_ed();

            int respuesta = 0;

            /**
             * Excepciones que puede tener
             */
            try {
                /**
                 * Menú del sudoku
                 */
                do {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("1. Iniciar/Reiniciar sudoku\n"
                            + "|   2. Realizar movimiento   |\n"
                            + "|   3. Vaciar casilla        | \n"
                            + "|   4. Mostrar sudoku        | \n"
                            + "|   5. Terminar              |");
                    System.out.println("|------------------------------------------------------------------------------------------------|");
                    respuesta = teclado.nextInt();

                    if (respuesta == 1) {
                        s.inicializar();
                    } /**
                     * Realizo un movimiento
                     */
                    else if (respuesta == 2) {
                        System.out.println("Dime las coordenadas de la casilla en la que quieres poner el número:");
                        System.out.println("Fila: ");
                        int fila = teclado.nextInt();
                        System.out.println("Columna:");
                        int columna = teclado.nextInt();
                        System.out.println("Dime el elemento que quieres insertar:");
                        int elemento = teclado.nextInt();

                        s.modificarElemento(fila, columna, elemento);
                    } else if (respuesta == 3) {
                        System.out.println("Dime las coordenadas de la casilla que quieres vaciar:");
                        System.out.println("Fila: ");
                        int fila = teclado.nextInt();
                        System.out.println("Columna:");
                        int columna = teclado.nextInt();

                        s.vaciarElemento(fila, columna);
                    } else if (respuesta == 4) {
                        System.out.println(s.toString());
                    }

                } while (respuesta < 1 || respuesta > 5 || respuesta != 5);

                /**
                 * Muestro un mensaje de que he terminado
                 */
                if (respuesta == 5) {
                    System.out.println("Has terminado el sudoku");

                }
            } catch (Exception error) {
                System.out.println("Error--> " + error.toString());
            }

        }

    }
}
