/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

/**
 *
 * @author leand
 */
public class Dificultad {
    
    private int nivelDificultad; // Puede ser cualquier número entero
    private double tiempoMaximoRespuestaCorrectaEjercicio = Double.MAX_VALUE; // Debe ser mayor que 0 (Por defecto, este es el mayor valor posible)
    private int numeroMaximoIntentosEjercicio = Integer.MAX_VALUE; // Debe ser mayor que 0 (Por defecto, este es el mayor valor posible)
    
    // Dificultades Especiales
    public static final int DIFICULTAD_MINIMA = Integer.MIN_VALUE;
    public static final int DIFICULTAD_MAXIMA = Integer.MAX_VALUE;

    public Dificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public Dificultad(int nivelDificultad, double tiempoMaximoRespuestaCorrectaEjercicio) throws Exception {
        if (tiempoMaximoRespuestaCorrectaEjercicio > 0) {
            this.nivelDificultad = nivelDificultad;
            this.tiempoMaximoRespuestaCorrectaEjercicio = tiempoMaximoRespuestaCorrectaEjercicio;
        } else {
            throw new Exception("El tiempo máximo de respuesta correcta ante ejercicios de cualquier dificultad debe ser mayor que 0");
        }        
    }

    public Dificultad(int nivelDificultad, double tiempoMaximoRespuestaCorrectaEjercicio, int numeroMaximoIntentosEjercicio) throws Exception {
        if (tiempoMaximoRespuestaCorrectaEjercicio > 0 && numeroMaximoIntentosEjercicio > 0) {
            this.nivelDificultad = nivelDificultad;
            this.tiempoMaximoRespuestaCorrectaEjercicio = tiempoMaximoRespuestaCorrectaEjercicio;
            this.numeroMaximoIntentosEjercicio = numeroMaximoIntentosEjercicio;
        } else if (tiempoMaximoRespuestaCorrectaEjercicio <= 0) {
            throw new Exception("El tiempo máximo de respuesta correcta a exigir ante ejercicios de cualquier dificultad debe ser mayor que 0");
        } else {
            throw new Exception("El número máximo de intentos a exigir ante ejercicios de cualquier dificultad debe ser mayor que 0");
        }
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public double getTiempoMaximoRespuestaCorrectaEjercicio() {
        return tiempoMaximoRespuestaCorrectaEjercicio;
    }

    public void setTiempoMaximoRespuestaCorrectaEjercicio(double tiempoMaximoRespuestaCorrectaEjercicio) throws Exception {
        if (tiempoMaximoRespuestaCorrectaEjercicio > 0) {
            this.tiempoMaximoRespuestaCorrectaEjercicio = tiempoMaximoRespuestaCorrectaEjercicio;
        } else {
            throw new Exception("El tiempo máximo de respuesta correcta ante ejercicios de cualquier dificultad debe ser mayor que 0");
        }
    }

    public int getNumeroMaximoIntentosEjercicio() {
        return numeroMaximoIntentosEjercicio;
    }

    public void setNumeroMaximoIntentosEjercicio(int numeroMaximoIntentosEjercicio) throws Exception {
        if (numeroMaximoIntentosEjercicio > 0) {
            this.numeroMaximoIntentosEjercicio = numeroMaximoIntentosEjercicio;
        } else {
            throw new Exception("El número máximo de intentos a exigir ante ejercicios de cualquier dificultad debe ser mayor que 0");
        }        
    }
    
}
