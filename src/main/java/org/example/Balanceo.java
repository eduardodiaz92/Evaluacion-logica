package org.example;

import java.util.Scanner;
import java.util.Stack;

public class Balanceo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Recibimos la expresión a evaluar
        String input = scan.next();
        // El stack o pila va a almacenar nuestros caracteres
        Stack<Character> pila = new Stack<Character>();

        // Recorremos la cadena de entrada
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                pila.push('(');
            } else if (c == ')') {
                if (pila.isEmpty()) {
                    // Si encontramos un paréntesis cerrado sin un paréntesis abierto previo, es incorrecto.
                    System.out.println("Incorrecto");
                    return; // Terminamos la ejecución
                } else {
                    pila.pop(); // Si hay un paréntesis abierto en la pila, lo emparejamos y lo eliminamos.
                }
            }
        }

        // Si la pila está vacía al final, la expresión es correcta.
        if (pila.isEmpty()) {
            System.out.println("Correcto");
        } else {
            System.out.println("Incorrecto");
        }
    }
}




