/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

import java.util.Random;

/**
 *
 * @author leand
 */
public class GeneradorEjercicios {
    
    public GeneradorEjercicios() {
    }
    
    /*
    Versión 0.1 del programa
    public Ejercicio generarEjercicio(int dificultad) {
        String descripcion;
        int respuestaCorrecta;        
        Random secuenciaRNG1 = new Random();
        Random secuenciaRNG2 = new Random();
        Random secuenciaRNG3 = new Random();
        switch(dificultad) {
            case 1 -> {
                // Dificultad 1: 1 dígito + 1 dígito
                // Generar números entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10);  
                int digito2 = secuenciaRNG2.nextInt(10);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 2 -> {
                // Dificultad 2: 2 dígitos + 1 dígito
                // Generar un número entre 10 y 99, y otro, entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10, 100);  
                int digito2 = secuenciaRNG2.nextInt(10);
                int orden = secuenciaRNG3.nextInt(2);
                // Generar la descripción del ejercicio con base en los dígitos generados, y el orden de presentación de los dígitos
                if (orden == 1) {
                    int temp = digito1;
                    digito1 = digito2;
                    digito2 = temp;
                }
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la descripción y la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 3 -> {
                // Dificultad 3: 2 dígitos + 2 dígitos
                // Generar números entre 10 y 99
                int digito1 = secuenciaRNG1.nextInt(10, 100);  
                int digito2 = secuenciaRNG2.nextInt(10, 100);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 4 -> {
                // Dificultad 4: 3 dígitos + 2 dígitos
                // Generar un número entre 100 y 999, y otro, entre 10 y 99
                int digito1 = secuenciaRNG1.nextInt(100, 1000);  
                int digito2 = secuenciaRNG2.nextInt(10, 100);
                int orden = secuenciaRNG3.nextInt(2);
                // Generar la descripción del ejercicio con base en los dígitos generados, y el orden de presentación de los dígitos
                if (orden == 1) {
                    int temp = digito1;
                    digito1 = digito2;
                    digito2 = temp;
                }
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la descripción y la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 5 -> {
                // Dificultad 5: 3 dígitos + 3 dígitos
                // Generar números entre 100 y 999
                int digito1 = secuenciaRNG1.nextInt(100, 1000);  
                int digito2 = secuenciaRNG2.nextInt(100, 1000);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 6 -> {
                // Dificultad 6: 1 dígito * 1 dígito
                // Generar números entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10);  
                int digito2 = secuenciaRNG2.nextInt(10);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " * " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 * digito2;
            }
            case 7 -> {
                // Dificultad 7: 2 dígitos * 1 dígito
                // Generar un número entre 10 y 99, y otro, entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10, 100);  
                int digito2 = secuenciaRNG2.nextInt(10);
                int orden = secuenciaRNG3.nextInt(2);
                // Generar la descripción del ejercicio con base en los dígitos generados, y el orden de presentación de los dígitos
                if (orden == 1) {
                    int temp = digito1;
                    digito1 = digito2;
                    digito2 = temp;
                }
                descripcion = digito1 + " * " + digito2 + " = ";
                // Sumar ambos números para obtener la descripción y la respuesta correcta
                respuestaCorrecta = digito1 * digito2;
            }
            default -> {
                return null;
            }
        }
        return new Ejercicio(descripcion, dificultad, respuestaCorrecta);
    }
    */
    public Ejercicio generarEjercicio(Dificultad dificultad) {
        String descripcion;
        int respuestaCorrecta;        
        Random secuenciaRNG1 = new Random();
        Random secuenciaRNG2 = new Random();
        Random secuenciaRNG3 = new Random();
        switch(dificultad.getNivelDificultad()) {
            case 1 -> {
                // Dificultad 1: 1 dígito + 1 dígito
                // Generar números entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10);  
                int digito2 = secuenciaRNG2.nextInt(10);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 2 -> {
                // Dificultad 2: 2 dígitos + 1 dígito
                // Generar un número entre 10 y 99, y otro, entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10, 100);  
                int digito2 = secuenciaRNG2.nextInt(10);
                int orden = secuenciaRNG3.nextInt(2);
                // Generar la descripción del ejercicio con base en los dígitos generados, y el orden de presentación de los dígitos
                if (orden == 1) {
                    int temp = digito1;
                    digito1 = digito2;
                    digito2 = temp;
                }
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la descripción y la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 3 -> {
                // Dificultad 3: 2 dígitos + 2 dígitos
                // Generar números entre 10 y 99
                int digito1 = secuenciaRNG1.nextInt(10, 100);  
                int digito2 = secuenciaRNG2.nextInt(10, 100);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 4 -> {
                // Dificultad 4: 3 dígitos + 2 dígitos
                // Generar un número entre 100 y 999, y otro, entre 10 y 99
                int digito1 = secuenciaRNG1.nextInt(100, 1000);  
                int digito2 = secuenciaRNG2.nextInt(10, 100);
                int orden = secuenciaRNG3.nextInt(2);
                // Generar la descripción del ejercicio con base en los dígitos generados, y el orden de presentación de los dígitos
                if (orden == 1) {
                    int temp = digito1;
                    digito1 = digito2;
                    digito2 = temp;
                }
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la descripción y la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 5 -> {
                // Dificultad 5: 3 dígitos + 3 dígitos
                // Generar números entre 100 y 999
                int digito1 = secuenciaRNG1.nextInt(100, 1000);  
                int digito2 = secuenciaRNG2.nextInt(100, 1000);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " + " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 + digito2;
            }
            case 6 -> {
                // Dificultad 6: 1 dígito * 1 dígito
                // Generar números entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10);  
                int digito2 = secuenciaRNG2.nextInt(10);
                // Generar la descripción del ejercicio con base en los dígitos generados
                descripcion = digito1 + " * " + digito2 + " = ";
                // Sumar ambos números para obtener la respuesta correcta
                respuestaCorrecta = digito1 * digito2;
            }
            case 7 -> {
                // Dificultad 7: 2 dígitos * 1 dígito
                // Generar un número entre 10 y 99, y otro, entre 0 y 9
                int digito1 = secuenciaRNG1.nextInt(10, 100);  
                int digito2 = secuenciaRNG2.nextInt(10);
                int orden = secuenciaRNG3.nextInt(2);
                // Generar la descripción del ejercicio con base en los dígitos generados, y el orden de presentación de los dígitos
                if (orden == 1) {
                    int temp = digito1;
                    digito1 = digito2;
                    digito2 = temp;
                }
                descripcion = digito1 + " * " + digito2 + " = ";
                // Sumar ambos números para obtener la descripción y la respuesta correcta
                respuestaCorrecta = digito1 * digito2;
            }
            default -> {
                return null;
            }
        }
        return new Ejercicio(descripcion, dificultad, respuestaCorrecta);
    }
}