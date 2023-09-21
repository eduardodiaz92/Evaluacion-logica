package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscarRuta {
    public static void main(String[] args) {
        try {
            // Leer el archivo de texto
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/laberinto.txt"));

            // Leer la primera línea para obtener el tamaño del mapa
            String[] dimensiones = br.readLine().split(" ");
            int filas = Integer.parseInt(dimensiones[0]);
            int columnas = Integer.parseInt(dimensiones[1]);

            // Leer el mapa
            char[][] mapa = new char[filas][columnas];
            for (int i = 0; i < filas; i++) {
                String fila = br.readLine();
                for (int j = 0; j < columnas; j++) {
                    mapa[i][j] = fila.charAt(j);
                }
            }

            // Pedir la posición de inicio al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("En qué posición deseas iniciar (fila): ");
            // Restar 1 para convertir a índice de matriz
            int columnaInicio = scanner.nextInt() - 1;
            // Siempre inicia en la primera fila osea la 0
            int filaInicio = 0;
            scanner.close();

            // Encontrar la ruta
            List<String> ruta = encontrarRuta(filas, columnas, mapa, filaInicio, columnaInicio);

            // Mostrar la ruta encontrada
            System.out.println("Ruta:");
            for (String paso : ruta) {
                System.out.println(paso);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> encontrarRuta(int filas, int columnas, char[][] mapa, int filaInicio, int columnaInicio) {
        List<String> ruta = new ArrayList<>();
        encontrarRutaRecursivo(filas, columnas, mapa, filaInicio, columnaInicio, ruta);
        return ruta;
    }

    private static boolean encontrarRutaRecursivo(int filas, int columnas, char[][] mapa, int fila, int columna, List<String> ruta) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || mapa[fila][columna] == '1') {
            return false; // Fuera de los límites o encontró una pared
        }

        String paso = "[FILA: " + (fila + 1) + " COLUMNA: " + (columna + 1) + "]";
        ruta.add(paso);

        if (fila == filas - 1) {
            return true; // Llegó a la parte inferior
        }

        // Marcar la casilla como visitada
        mapa[fila][columna] = '1';

        // Mover hacia abajo, izquierda y derecha (en ese orden)
        if (encontrarRutaRecursivo(filas, columnas, mapa, fila + 1, columna, ruta) ||
                encontrarRutaRecursivo(filas, columnas, mapa, fila, columna - 1, ruta) ||
                encontrarRutaRecursivo(filas, columnas, mapa, fila, columna + 1, ruta)) {
            return true;
        }

        // Si no encuentra una ruta válida, retrocede
        ruta.remove(ruta.size() - 1);
        return false;
    }
}
