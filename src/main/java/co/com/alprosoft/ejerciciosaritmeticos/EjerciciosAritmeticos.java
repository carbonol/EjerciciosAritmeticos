/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.com.alprosoft.ejerciciosaritmeticos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author leand
 */
public class EjerciciosAritmeticos {
    
    // Versiones disponibles: [1, 2, 3]
    // public static final int VERSION = Versiones.V1;
    // public static final int VERSION = Versiones.V2;
    public static final int VERSION = Versiones.V3;

    public static void main(String[] args) {
        /*
        Versión 0.1 del programa
        // Genera una lista de dificultades (Del 1 al 7)
        ArrayList<Integer> dificultades = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            dificultades.add(i);
        }
        // Genera una lista de referentes de tiempos de respuesta correcta para cada una de las dificultades
        double[] tiempos = new double[]{2.1d, 5.2d, 6d, 9.3d, 13d, 6.8d, 22d};
        ArrayList<Double> tiemposRespuestaCorrecta = new ArrayList<>();
        for (int i = 0; i < dificultades.size(); i++) {
            tiemposRespuestaCorrecta.add(tiempos[i]);
        }
        // Genera una lista de referentes de número máximo de intentos para cada una de las dificultades
        int[] maximoIntentos = new int[]{1, 1, 1, 2, 2, 2, 2};
        ArrayList<Integer> maximoIntentosParaRespuestaCorrecta = new ArrayList<>();
        for (int i = 0; i < dificultades.size(); i++) {
            maximoIntentosParaRespuestaCorrecta.add(maximoIntentos[i]);
        }
        */
        // INICIO DE DEFINICIÓN DE DIFICULTADES, TIEMPOS MÁXIMOS DE RESPUESTA CORRECTA, Y NÚMERO MÁXIMO DE INTENTOS PARA OBTENER LA RESPUESTA CORRECTA
        // Genera una lista de dificultades (Del 1 al 7)
        ArrayList<Dificultad> dificultades = new ArrayList<>();
        try {
            // POSIBLEMENTE IMPORTANTE:
            for (int i = 1; i < 8; i++) {
                if (VERSION == Versiones.V1) {
                    dificultades.add(new Dificultad(i));
                } else {
                    // Genera una lista de tiempos máximos de respuesta correcta para cada una de las dificultades
                    double[] tiempos = new double[]{2.1d, 5.2d, 6d, 9.3d, 13d, 6.8d, 22d};
                    if (VERSION == Versiones.V2) {
                        dificultades.add(new Dificultad(i, tiempos[i - 1]));
                    } else if (VERSION == Versiones.V3){
                        // Genera una lista de números máximos de intentos para cada una de las dificultades
                        int[] maximoIntentos = new int[]{1, 1, 1, 2, 2, 2, 2};
                        dificultades.add(new Dificultad(i, tiempos[i - 1], maximoIntentos[i - 1]));
                    } else {
                        throw new Exception("La versión indicada para este programa no está implementada aún.");
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Hubo un problema al definir las dificultades de los ejercicios:\n" + exception + " : " + exception.getMessage());
            System.exit(0);
        }        
        // FIN DE DEFINICIÓN DE DIFICULTADES, TIEMPOS MÁXIMOS DE RESPUESTA CORRECTA, Y NÚMERO MÁXIMO DE INTENTOS PARA OBTENER LA RESPUESTA CORRECTA
        
        try {
            // boolean finAlcanzado = false;
            boolean mismoEjercicio = false;                    
            
            // Cronografo cronografoRespuestaEjercicio = new Cronografo();
            Cronografo cronografoRespuestaCorrectaEjercicio = new Cronografo();
        
            // Generar una nueva máquina de dificultades (MD) con las dificultades 1-7.
            MaquinaDificultades md = new MaquinaDificultades(dificultades);
            
            // System.out.println("---- Ejercicios Aritméticos ----");
            int numeroEjercicios = 0;
            Ejercicio ej = null;
            
            int numeroIntentos = 0;
            
            // while (finAlcanzado == false) {
            // while (true) {
            // Mientras que la Máquina de Dificultades no haya llegado al estado final
            //  (Esto es, el estado al que se llega cuando se supera la última dificultad).
            while (!md.estaEnEstadoFin()) {
                
                // Si la MD está en el estado INICIO, entonces aumente su dificultad para
                //  colocar el estado de la MD en el primer nivel de dificultad que enfrentará el usuario,
                //  y no ejecute el resto de las instrucciones en el ciclo hasta la próxima iteración.
                if (md.estaEnEstadoInicio()) {
                    md.aumentarDificultad();
                    continue;
                }
                
                if (mismoEjercicio == false) {
                    // Genera un nuevo ejercicio de la dificultad md.getDificultad()
                    ej = new GeneradorEjercicios().generarEjercicio(md.getDificultad());
                    numeroEjercicios++;
                    // Si es el primer ejercicio mostrado, muestre el mensaje inicial
                    if (numeroEjercicios == 1) {
                        System.out.println("---- Ejercicios Aritméticos ----");
                    }
                    // Inicializa el contador de número de intentos para el nuevo ejercicio en 0
                    numeroIntentos = 0;                    
                }
                
                // Muestra la información del siguiente ejercicio a mostrar
                System.out.println("-- Ejercicio # " + numeroEjercicios + " --");
                System.out.println("Escriba la respuesta para el siguiente ejercicio: ");
                System.out.println(ej.getDescripcion());
                System.out.print(">> ");
                
                // En este punto, se asume que el usuario puede comenzar a identificar el ejercicio
                // cronografoRespuestaEjercicio.iniciar();
                if (mismoEjercicio == false) {
                    // Inicializa el cronógrafo de tiempo de respuesta correcta para el nuevo ejercicio en 0.0d
                    cronografoRespuestaCorrectaEjercicio.iniciar();
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String entrada = reader.readLine();
                
                // En este punto, ya se ha recibido una respuesta al ejercicio por parte del usuario
                // long tiempoRespuestaEjercicioConPrecisionDeMS = cronografoRespuestaEjercicio.tiempoTranscurrido(TimeUnit.MILLISECONDS);
                // double tiempoRespuestaEjercicioSegundos = tiempoRespuestaEjercicioConPrecisionDeMS / 1000D;
                // System.out.println("El tiempo de respuesta ante el ejercicio fue de: " + tiempoRespuestaEjercicioSegundos + " segundos.");                
                long tiempoRespuestaCorrectaEjercicioConPrecisionDeMS = cronografoRespuestaCorrectaEjercicio.tiempoTranscurrido(TimeUnit.MILLISECONDS);
                double tiempoRespuestaCorrectaEjercicioSegundos = tiempoRespuestaCorrectaEjercicioConPrecisionDeMS / 1000D;                
                        
                Integer respuesta = null;
                try {
                    respuesta = Integer.valueOf(entrada);                    
                    // Una respuesta ya fue enviada por el usuario; 
                    //  consuma un intento para el ejercicio.
                    numeroIntentos += 1;
                    
                    // Valida la respuesta dada por el usuario mediante el validador
                    /*
                    Versión 0.1 del programas
                    ValidadorRespuesta vr = new ValidadorRespuesta(respuesta, 
                        ej.getRespuestaCorrecta(), md.getDificultad());
                    int dificultad = vr.validarRespuestaConValidador1();
                    */
                    ValidadorRespuesta vr;
                    if (VERSION == Versiones.V1) {
                        vr = new ValidadorRespuesta(ej, respuesta);
                    } else if (VERSION == Versiones.V2) {
                        vr = new ValidadorRespuesta(ej, respuesta, 
                                tiempoRespuestaCorrectaEjercicioSegundos);
                    } else if (VERSION == Versiones.V3) {
                        vr = new ValidadorRespuesta(ej, respuesta, 
                                tiempoRespuestaCorrectaEjercicioSegundos,
                                numeroIntentos);
                    }                    
                    DecisionValidador dv = vr.validarRespuesta(VERSION, md);
                    if (dv.isCorrecto()) {
                        // Se obtuvo una respuesta correcta
                        System.out.println("Correcto");
                        if (VERSION == Versiones.V2 || VERSION == Versiones.V3) {
                            System.out.println("El tiempo de respuesta correcta del ejercicio fue de: " 
                                    + tiempoRespuestaCorrectaEjercicioSegundos + " segundos.");                            
                        }
                        if (VERSION == Versiones.V3) {
                            System.out.println("El número total de respuestas enviadas en este ejercicio fue de: " 
                                    + numeroIntentos + " intento(s).");
                        }
                    } else {
                        // Se obtuvo una respuesta válida pero incorrecta
                        System.out.println("Incorrecto");
                        if (VERSION == Versiones.V3) {
                            System.out.println("El número de respuestas enviadas hasta ahora en este ejercicio es de: " 
                                    + numeroIntentos + " intento(s).");
                        }
                    }                    
                    md.setDificultad(dv.getSiguienteDificultad());
                    mismoEjercicio = dv.isMismoEjercicio();
                    
                    /*
                    Versión 0.1 del programas
                    if (dificultad > md.getDificultad().getNivelDificultad()) {
                        // Se obtuvo una respuesta correcta
                        System.out.println("Correcto");
                        System.out.println("El tiempo de respuesta correcta del ejercicio fue de: " + tiempoRespuestaCorrectaEjercicioSegundos + " segundos.");
                        if (md.aumentarDificultad() == false) { // Nota: Aquí se aumenta la dificultad de los ejercicios, si este aumento es posible.
                            // Se ha intentado aumentar la dificultad, más allá de la máxima permitida.                            
                            break; // finAlcanzado = true;
                        }
                        mismoEjercicio = false;
                    } else {
                        // Se obtuvo una respuesta válida pero incorrecta
                        System.out.println("Incorrecto");
                        mismoEjercicio = true;
                    }
                    */
                    
                    System.out.println();
                } catch (NumberFormatException numberFormatException) {
                    // Respuesta inválida
                    System.out.println("El formato de la respuesta no es el adecuado. Por favor ingrese un número para responder el ejercicio.");
                    System.out.println();
                    mismoEjercicio = true;
                }                
            }
        } catch (Exception ex) {
            System.out.println("Hubo un problema al mostrar el flujo de ejercicios:\n" + ex + " : " + ex.getMessage());
            // Logger.getLogger(EjerciciosAritmeticos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
