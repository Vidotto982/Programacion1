import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Parcial2018 {
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    final static int MAX_FIL = 14;
    final static int MAX_COL = 30;
    final static int CANT = 8;

    public static void main(String[] args) {

        int[][] ints = {
                {0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0, 6, 5, 4, 3, 0, 4, 3, 5, 0, 1, 7, 1, 2, 7, 3, 4, 7, 4, 4},
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
                {0, 3, 4, 9, 3, 6, 8, 1, 7, 0, 2, 1, 0, 5, 5, 1, 7, 5, 9, 8, 5, 6, 9, 1, 4, 4, 6, 9, 2, 4},
        };
        try {
            mostrarMat(ints);
            buscarSecuencias(ints);
            mostrarMat(ints);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void buscarSecuencias(int[][] ints) {
        int posInicial = 0;
        int posFinal = 0;
        int cantSecuencias = 0;
        boolean posIni = false;
        for (int fil = 0; fil < MAX_FIL; fil++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (ints[fil][col] != 0 && !posIni) {
                    posInicial = col;
                    posIni = true;
                }
                if (ints[fil][col] == 0 && posIni) {
                    cantSecuencias++;
                    posFinal = col;
                    if (cantSecuencias == CANT) {
                        ordenarSecuencias(ints, posInicial, posFinal, fil);
                    }
                    posIni = false;
                }

            }

        }
    }

    private static void ordenarSecuencias(int[][] ints, int posInicial, int posFinal, int fil) {
        int aux;
        for (int filIni = fil; fil < MAX_FIL; fil++) {
            for (int colIni = posInicial; colIni < posFinal - 1; colIni++) {
                if (ints[filIni][colIni] > ints[filIni][colIni + 1]) {
                    aux = ints[filIni][colIni + 1];
                    ints[filIni][colIni + 1] = ints[filIni][colIni];
                    ints[filIni][colIni] = aux;

                }
            }
        }
        System.out.println();
    }


    public static void mostrarMat(int ints[][]) {
        for (int f = 0; f < MAX_FIL; f++) {
            for (int c = 0; c < MAX_COL; c++) {
                System.out.print(ints[f][c] + " ");

            }

            System.out.println();
        }
        System.out.println();
    }

}
