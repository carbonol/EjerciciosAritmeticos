/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

/**
 *
 * @author leand
 */
public class Ejercicio {
    
    private String descripcion; // Descripción visible del ejercicio
    // Versión 0.1 del programa
    // private int dificultad; // Dificultad del ejercicio
    private Dificultad dificultad; // Dificultad del ejercicio
    private int respuestaCorrecta; // Respuesta correcta del ejercicio

    /*
    Versión 0.1 del programa
    public Ejercicio(String descripcion, int dificultad, int respuestaCorrecta) {
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    */
    public Ejercicio(String descripcion, Dificultad dificultad, int respuestaCorrecta) {
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
    Versión 0.1 del programa
    public int getDificultad() {
        return dificultad;
    }
    */
    public Dificultad getDificultad() {
        return dificultad;
    }

    /*
    Versión 0.1 del programa
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    */
    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
}