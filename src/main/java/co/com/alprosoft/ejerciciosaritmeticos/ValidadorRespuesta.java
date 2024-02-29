/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

/**
 *
 * @author leand
 */
public class ValidadorRespuesta {    
    
    /*
    Versión 0.1 del programa
    private int respuestaUsuario;
    private int respuestaEjercicio;
    private int dificultadEjercicio;
    private double tiempoMaximoRespuestaCorrectaEjercicio;
    private int numeroIntentosMaximoEjercicio;
    */
    private Ejercicio ejercicio;
    private int respuestaUsuario;
    private double tiempoRespuestaCorrectaUsuario;
    private int numeroIntentosUsuario;

    /*
    Versión 0.1 del programa
    public ValidadorRespuesta(int respuestaUsuario, int respuestaEjercicio, int dificultadEjercicio) {
        this.respuestaUsuario = respuestaUsuario;
        this.respuestaEjercicio = respuestaEjercicio;
        this.dificultadEjercicio = dificultadEjercicio;
    }
    */
    public ValidadorRespuesta(Ejercicio ejercicio, int respuestaUsuario) {        
        this.ejercicio = ejercicio;
        this.respuestaUsuario = respuestaUsuario;
    }
    
    public ValidadorRespuesta(Ejercicio ejercicio, int respuestaUsuario, 
            double tiempoRespuestaCorrectaUsuario) {
        this.ejercicio = ejercicio;
        this.respuestaUsuario = respuestaUsuario;
        this.tiempoRespuestaCorrectaUsuario = tiempoRespuestaCorrectaUsuario;
    }
    
    public ValidadorRespuesta(Ejercicio ejercicio, int respuestaUsuario, 
            double tiempoRespuestaCorrectaUsuario, int numeroIntentosUsuario) {
        this.respuestaUsuario = respuestaUsuario;
        this.ejercicio = ejercicio;
        this.tiempoRespuestaCorrectaUsuario = tiempoRespuestaCorrectaUsuario;
        this.numeroIntentosUsuario = numeroIntentosUsuario;
    }

    /*
    Versión 0.1 del programa
    public int getRespuestaEjercicio() {
        return respuestaEjercicio;
    }
    */

    /*
    Versión 0.1 del programa
    public void setRespuestaEjercicio(int respuestaEjercicio) {
        this.respuestaEjercicio = respuestaEjercicio;
    }
    */

    /*
    Versión 0.1 del programa
    public int getDificultadEjercicio() {
        return dificultadEjercicio;
    }
    */

    /*
    Versión 0.1 del programa
    public void setDificultadEjercicio(int dificultadEjercicio) {
        this.dificultadEjercicio = dificultadEjercicio;
    }
    */

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
    
    public int getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(int respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public double getTiempoRespuestaCorrectaUsuario() {
        return tiempoRespuestaCorrectaUsuario;
    }

    public void setTiempoRespuestaCorrectaUsuario(double tiempoRespuestaCorrectaUsuario) {
        this.tiempoRespuestaCorrectaUsuario = tiempoRespuestaCorrectaUsuario;
    }

    public int getNumeroIntentosUsuario() {
        return numeroIntentosUsuario;
    }

    public void setNumeroIntentosUsuario(int numeroIntentosUsuario) {
        this.numeroIntentosUsuario = numeroIntentosUsuario;
    }
    
    public DecisionValidador validarRespuesta(int version, MaquinaDificultades md) {
        switch (version) {
            case Versiones.V1 -> {
                return validarRespuestaConValidadorV1(md);
            }
            case Versiones.V2 -> {
                return validarRespuestaConValidadorV2(md);
            }
            case Versiones.V3 -> {
                return validarRespuestaConValidadorV3(md);
            }
            default -> {
            }
        }
        return null;
    }
    
    /*
    Versión 0.1 del programa
    public int validarRespuestaConValidador1() {
        // Validador Versión 1
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, 
        //  indique que la dificultad se debe aumentar en 1.
        if (this.respuestaUsuario == this.respuestaEjercicio) {
            return this.dificultadEjercicio + 1;
        }
        return this.dificultadEjercicio;
    }
    */
    private DecisionValidador validarRespuestaConValidadorV1(MaquinaDificultades md) {
        // Validador Versión 1
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, 
        //  indique que la dificultad se debe aumentar en 1.
        // (Cuando la dificultad cambia, el siguiente ejercicio a mostrar 
        //  debe necesariamente diferente al ejercicio actual).
        // En caso contrario, mantenga la misma dificultad con el mismo ejercicio.
        if (this.respuestaUsuario == this.ejercicio.getRespuestaCorrecta()) {
            return new DecisionValidador(true, md.obtenerDificultadSuperior(
                    this.ejercicio.getDificultad()), false);
        }
        return new DecisionValidador(false, this.ejercicio.getDificultad(), 
                true);
    }
    
    /*
    Versión 0.1 del programa
    public int validarRespuestaConValidador2() {
        // Validador Versión 2
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, 
        //  indique que la dificultad se debe aumentar en 1.
        if (this.respuestaUsuario == this.respuestaEjercicio) {
            return this.dificultadEjercicio + 1;
        }
        return this.dificultadEjercicio;
    }
    */
    private DecisionValidador validarRespuestaConValidadorV2(MaquinaDificultades md) {
        // Validador Versión 2
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, 
        //  y el tiempo de respuesta correcta del usuario es menor o igual al tiempo de
        //  respuesta correcta esperada según la dificultad del ejercicio, entonces
        //  indique que la dificultad se debe aumentar en 1.
        // (Cuando la dificultad cambia, el siguiente ejercicio a mostrar 
        //  debe necesariamente diferente al ejercicio actual).
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, pero
        //  el tiempo de respuesta correcta del usuario es mayor al tiempo de respuesta
        //  correcta esperada para la dificultad del ejercicio, entonces indique
        //  que la dificultad debe permanecer igual, pero el ejercicio debe ser
        //  diferente.
        // En otro caso, indique que la dificultad debe permanecer igual, y que
        //  el siguiente ejercicio a mostrar es el mismo.
        if (this.respuestaUsuario == this.ejercicio.getRespuestaCorrecta()) {
            if (this.tiempoRespuestaCorrectaUsuario <= this.ejercicio.getDificultad()
                    .getTiempoMaximoRespuestaCorrectaEjercicio()) {
                return new DecisionValidador(true, md.obtenerDificultadSuperior(
                    this.ejercicio.getDificultad()), false);
            } else {
                return new DecisionValidador(true, this.ejercicio.getDificultad(), 
                false);
            }
        }
        return new DecisionValidador(false, this.ejercicio.getDificultad(), 
                true);
    }
    
    private DecisionValidador validarRespuestaConValidadorV3(MaquinaDificultades md) {
        // Validador Versión 3
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, 
        //  y el tiempo de respuesta correcta del usuario es menor o igual al tiempo de
        //  respuesta correcta esperada según la dificultad del ejercicio, entonces
        //  indique que la dificultad se debe aumentar en 1.
        // (Cuando la dificultad cambia, el siguiente ejercicio a mostrar 
        //  debe necesariamente diferente al ejercicio actual).
        
        // Si la respuesta del usuario es igual a la respuesta del ejercicio, pero
        //  el tiempo de respuesta correcta del usuario es mayor al tiempo de respuesta
        //  correcta esperada para la dificultad del ejercicio, entonces indique
        //  que la dificultad debe permanecer igual, pero el ejercicio debe ser
        //  diferente.
        
        // Si la respuesta del usuario NO es igual a la respuesta del ejercicio,
        //  y el número de intentos realizados por el usuario es igual o mayor que el 
        //  número de intentos máximo según la dificultad del ejercicio, 
        //  entonces indique que la dificultad se debe disminuir en 1.
        // (Cuando la dificultad cambia, el siguiente ejercicio a mostrar 
        //  debe necesariamente diferente al ejercicio actual).

        // En otro caso, indique que la dificultad debe permanecer igual, y que
        //  el siguiente ejercicio a mostrar es el mismo.
        if (this.respuestaUsuario == this.ejercicio.getRespuestaCorrecta()) {
            if (this.tiempoRespuestaCorrectaUsuario <= this.ejercicio.getDificultad()
                    .getTiempoMaximoRespuestaCorrectaEjercicio()) {
                return new DecisionValidador(true, md.obtenerDificultadSuperior(
                    this.ejercicio.getDificultad()), false);
            } else {
                return new DecisionValidador(true, this.ejercicio.getDificultad(), 
                false);
            }
        } else {
            if (this.numeroIntentosUsuario >= this.ejercicio.getDificultad()
                    .getNumeroMaximoIntentosEjercicio()) {
                return new DecisionValidador(false, md.obtenerDificultadInferior(
                    this.ejercicio.getDificultad()), false);
            } else {
                return new DecisionValidador(false, this.ejercicio.getDificultad(), 
                true);
            }
        }        
    }
    
}
