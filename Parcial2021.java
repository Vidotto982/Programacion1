import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Se tiene una matriz de enteros de tamanio 7*30 de secuencias de numeros pares entre 1 y 9 (por cada fila), separadas por 0.
La matriz esta precargada (no implementar el metodo de carga), y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
elimine todas las secuencias que cumplan con alguna de las siguientes condiciones: _esta ordenada de forma descendente y contiene el valor 6, _tiene al menos 10 valores multiplos de 3, _no es capicua.
*/
public class Parcial2021 {
    final static int MAX_FIL = 7;
    final static int MAX_COL = 30;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int[][] ints = {
                {0, 2, 3, 4, 2, 0, 0, 0, 0, 0, 0, 6, 5, 4, 3, 0, 4, 3, 5, 0, 1, 7, 1, 2, 7, 3, 4, 7, 4, 4},
                {0, 2, 4, 6, 8, 8, 8, 8, 8, 6, 4, 4, 4, 5, 0, 8, 4, 0, 4, 6, 3, 2, 4, 1, 7, 3, 1, 4, 0, 1},
                {0, 8, 2, 6, 6, 4, 5, 0, 1, 7, 9, 6, 3, 0, 0, 6, 8, 2, 3, 4, 6, 4, 4, 2, 1, 9, 1, 7, 9, 8},
                {0, 6, 0, 2, 6, 6, 7, 5, 6, 9, 1, 9, 1, 2, 2, 0, 6, 5, 4, 4, 5, 6, 8, 3, 6, 8, 3, 8, 6, 6},
                {0, 8, 2, 8, 7, 0, 1, 5, 5, 8, 8, 1, 5, 2, 2, 6, 4, 8, 5, 7, 6, 2, 0, 9, 8, 9, 4, 2, 4, 2},
                {0, 8, 1, 4, 0, 0, 1, 0, 6, 1, 9, 9, 7, 8, 5, 2, 9, 8, 2, 8, 5, 4, 3, 8, 4, 8, 5, 4, 2, 5},
                {0, 3, 4, 9, 3, 6, 8, 1, 7, 0, 1, 1, 0, 5, 5, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 4, 6, 9, 2, 4},
                {0, 2, 6, 4, 6, 5, 3, 5, 9, 5, 7, 5, 8, 3, 0, 7, 4, 3, 5, 0, 1, 7, 1, 2, 7, 3, 4, 7, 4, 4},
                {0, 3, 0, 4, 2, 1, 7, 3, 3, 6, 8, 2, 7, 4, 0, 8, 4, 0, 4, 6, 3, 2, 4, 1, 7, 3, 1, 4, 0, 1},
                {0, 8, 2, 6, 6, 4, 5, 0, 1, 7, 9, 6, 3, 0, 0, 6, 8, 2, 3, 4, 6, 4, 4, 2, 1, 9, 1, 7, 9, 8},
                {0, 6, 0, 2, 6, 6, 7, 5, 6, 9, 1, 9, 1, 2, 2, 0, 6, 5, 4, 4, 5, 6, 8, 3, 6, 8, 3, 8, 6, 6},
                {0, 8, 2, 8, 7, 0, 1, 5, 5, 8, 8, 1, 5, 2, 2, 6, 4, 8, 5, 7, 6, 2, 0, 9, 8, 9, 4, 2, 4, 2},
                {0, 8, 1, 4, 0, 0, 1, 0, 6, 1, 9, 9, 7, 8, 5, 2, 9, 8, 2, 8, 5, 4, 3, 8, 4, 8, 5, 4, 2, 5},
                {0, 3, 4, 9, 3, 6, 8, 1, 7, 0, 1, 1, 0, 5, 5, 1, 7, 5, 9, 8, 5, 6, 9, 1, 4, 4, 6, 9, 2, 4},
        };
        try {
            final int[][] mat = new int[MAX_FIL][MAX_COL];
            mostrarMat(ints);
            buscarSecuencia(ints);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cargaMat(int ints[][]) {
        for (int f = 0; f < MAX_FIL; f++) {
            for (int c = 1; c < MAX_COL; c++) {
                ints[f][c] = (int) (Math.random() * 10);
            }
//           ordenarMat(mat, maxcol, maxfil);
        }
    }

    //
    public static void mostrarMat(int ints[][]) {
        for (int f = 0; f < MAX_FIL; f++) {
            for (int c = 0; c < MAX_COL; c++) {
                System.out.print(ints[f][c] + " ");

            }

            System.out.println();
        }

    }

    public static void buscarSecuencia(int ints[][]) {
        int posInicial = 0;
        int posFinal = 0;
        boolean posIni = false;

        for (int fil = 0; fil < MAX_FIL; fil++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (ints[fil][col] != 0 && !posIni) {
                    posInicial = col;
                    posIni = true;
                } else if (ints[fil][col] == 0 && posIni) {
                    posFinal = col;
                    chequearSecuencia(posInicial, posFinal, ints, fil);
                    posIni = false;
                }

            }
        }
    }

    public static void eliminarSecuencia(int posInicial, int posFinal, int[][] ints, int fil) {
        for (int colIni = posInicial; colIni < posFinal; colIni++) {
            ints[fil][colIni] = 0;
        }
        System.out.println();
        mostrarMat(ints);
    }

    public static void chequearSecuencia(int posInicial, int posFinal, int[][] ints, int fil) {

        if (!esCapicua(posInicial, posFinal, ints, fil)) {
            eliminarSecuencia(posInicial, posFinal, ints, fil);
        } else if (desendiente(posInicial, posFinal, ints, fil)) { // es descendiente y tiene el 6
            eliminarSecuencia(posInicial, posFinal, ints, fil);

        } else if (Multiplos(posInicial, posFinal, ints, fil)) { // tiene 10 multiplos de 10
            eliminarSecuencia(posInicial, posFinal, ints, fil);
        }
//            } else if (mat[fil][colIni] % 3 == 0) {//tiene que tener 10 multiplos de 3
//                multiplos++;
//                if (multiplos == 10) {
//                    System.out.println("Tiene 10 multiplos" + colIni + posFinal);
//                    eliminarSecuencia(posInicial, posFinal, mat, fil);        mostrarMat(ints);

    }

    public static boolean esCapicua(int posInicial, int posFinal, int[][] ints, int fil) {
        for (int colIni = posInicial; colIni < posFinal-1 / 2; colIni++) {
            if (ints[fil][colIni] != ints[fil][posFinal - colIni]) { //no es capicua
                return false;
            }
        }
        return true;
    }


    public static boolean Multiplos(int posInicial, int posFinal, int[][] mat, int fil) {
        int contadorMultiplos = 0;
        for (int colIni = posInicial; colIni < posFinal; colIni++) {
            if (mat[fil][colIni] % 3 == 0) {
                contadorMultiplos++;
                if (contadorMultiplos >= 10) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean desendiente(int posInicial, int posFinal, int[][] mat, int fil) {
        boolean esDesendiente = false;
        boolean contiene6 = false;
        for (int colIni = posInicial; colIni <= posFinal; colIni++) {
            if (mat[fil][colIni] > mat[fil][colIni  + 1]) {
                esDesendiente = true;
            }
            if (mat[fil][colIni] == 6) {
                contiene6 = true;
            }
            if (colIni == posFinal && contiene6 && esDesendiente) {
                return true;
            }
        }
        return false;
    }
//    public static void ordenarMat(int mat[][], int maxcol, int maxfil) {
//        int aux;
//
//        for (int f = 0; f < maxfil; f++) {
//            for (int col = 0; col < maxcol; col++) {
//                for (int c = 0; c < maxcol  1; c++) {
//                    if (mat[f][c] < mat[f][c + 1]) {
//                        aux = mat[f][c];
//                        mat[f][c] = mat[f][c + 1];
//                        mat[f][c + 1] = aux;
//                    }
//                }
//            }
//        }
//    }
}

