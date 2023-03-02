import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Homework {
    public static void main(String[] args) {

        long start = System.nanoTime();
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Parametrul trimis nu este acceptat, trebuie sa fie INT");
            return;
        }
        if (n < 1) {
            System.out.println("Parametrul trimis trebui sa aiba valoare > 0");
            return;
        }
        System.out.println(n);

        int[][] matrice = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrice[i][j] = (i + j) % n + 1;

        //in cazul acestui tip de matrici liniile si coloanele corespondente lunt la fel
        //as fi putut sa mut aceasta iteratie in for ul de generare

        if (n < 10_000) {
            String linie = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    linie += matrice[i][j];
                System.out.println("Linia " + i + ": " + linie);
                linie = "";
            }

            String coloana = "";
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++)
                    coloana += matrice[i][j];

                System.out.println("Coloana " + j + ": " + coloana);
                coloana = "";
            }
        } else {
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("nanoseconds: " + time);
            System.out.println("miliseconds: " + time / 1000000);
        }

    }
}
