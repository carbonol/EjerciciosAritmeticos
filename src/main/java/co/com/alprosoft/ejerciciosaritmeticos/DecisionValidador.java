/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

/**
 *
 * @author leand
 */
public class DecisionValidador {
    
    private boolean correcto;
    private Dificultad siguienteDificultad;
    private boolean mismoEjercicio;

    public DecisionValidador(boolean correcto, Dificultad siguienteDificultad, boolean mismoEjercicio) {
        this.correcto = correcto;
        this.siguienteDificultad = siguienteDificultad;
        this.mismoEjercicio = mismoEjercicio;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public Dificultad getSiguienteDificultad() {
        return siguienteDificultad;
    }

    public void setSiguienteDificultad(Dificultad siguienteDificultad) {
        this.siguienteDificultad = siguienteDificultad;
    }

    public boolean isMismoEjercicio() {
        return mismoEjercicio;
    }

    public void setMismoEjercicio(boolean mismoEjercicio) {
        this.mismoEjercicio = mismoEjercicio;
    }
    
}
