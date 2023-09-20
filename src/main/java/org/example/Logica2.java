package org.example;


import java.io.*;


public class Logica2 {
    public static void main(String[] args) throws IOException {
        // Configurar la entrada y la salida
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        // Leer el número de casos de prueba
        int tests = Integer.parseInt(reader.readLine());

        while (tests-- > 0) {
            // Leer los parámetros para cada caso de prueba
            String[] params = reader.readLine().split(" ");
            int rows = Integer.parseInt(params[0]);

            // Crear un arreglo para representar el jardín
            String[] garden = new String[rows];

            // Leer la descripción del jardín
            for (int i = 0; i < rows; i += 1)
                garden[i] = reader.readLine();

            // Calcular la elegancia y escribir el resultado
            out.write(computeElegance(garden) + "\r\n");
        }

        // Vaciar el búfer de salida
        out.flush();
    }

    // Función para calcular la elegancia del jardín
    public static int computeElegance(String[] garden) {
        int squares = 0;
        int rows = garden.length;
        int columns = garden[0].length();

        // Iterar a través de las filas y columnas del jardín
        for (int i = 0; i < rows - 1; i += 1) { // Para cada fila en el jardín
            for (int j = 0; j < columns - 1; j += 1) { // Para cada columna en el jardín
                char tLeftChar = garden[i].charAt(j); // Carácter en la esquina superior izquierda

                // Comprobar si se forma un cuadrado con esquinas del mismo color
                for (int tRight = j + 1, bLeft = i + 1; tRight < columns && bLeft < rows; tRight += 1, bLeft += 1) {
                    if (garden[i].charAt(tRight) == tLeftChar && // Comprobar esquina superior derecha
                            garden[bLeft].charAt(j) == tLeftChar && // Comprobar esquina inferior izquierda
                            garden[bLeft].charAt(tRight) == tLeftChar) { // Comprobar esquina inferior derecha
                        squares += 1; // Incrementar el contador de cuadrados elegantes
                    }
                }
            }
        }
        // Devolver la cantidad total de cuadrados elegantes
        return squares;
    }
}
