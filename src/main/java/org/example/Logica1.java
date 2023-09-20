package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Logica1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Numero de casos
        int t = scan.nextInt();

        while (t-- > 0) {
            // Numero de ingredientes
            int n = scan.nextInt();
            int m = 1;

            // Crear dos arrays para almacenar los valores originales y los valores modificados
            Integer array1[] = new Integer[n];
            Integer array2[] = new Integer[array1.length];

            // Leer los valores de los ingredientes en el primer array
            for (int i = 0; i < n; i++) {
                array1[i] = scan.nextInt();
            }

            // Copiar los valores del primer array al segundo array
            for (int i = 0; i < n; i++) {
                array2[i] = array1[i];
            }

            // Calcular el máximo común divisor (MCD) de dos valores adyacentes
            for (int i = 0; i < n - 1; i++) {
                // Encontrar el mínimo entre dos valores
                int min = Collections.min(Arrays.asList(array1[i], array2[i + 1]));

                // Encontrar el MCD entre los dos valores
                for (int j = 1; j <= min; j++) {
                    if (array2[i] % j == 0 && array2[i + 1] % j == 0) {
                        m = j;
                    }
                }
                array2[i + 1] = m;
            }

            // Imprimir los valores originales divididos por el MCD
            for (int i = 0; i < n; i++) {
                System.out.print(array1[i] / m + " ");
            }

            System.out.println();
        }
    }
}