/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author leand
 */
public class Cronografo {
    private long tiempoInicio;
    
    public Cronografo() {
    }
    
    public void iniciar() {
        this.reiniciar();
    }
    
    public void reiniciar() {
        this.tiempoInicio = System.nanoTime();
    }
    
    public long tiempoTranscurrido() {
        long tiempoFin = System.nanoTime();
        return tiempoFin - this.tiempoInicio;
    }
    
    public long tiempoTranscurrido(TimeUnit unidadTiempo) {
        return unidadTiempo.convert(this.tiempoTranscurrido(), TimeUnit.NANOSECONDS);
    }
    
}
