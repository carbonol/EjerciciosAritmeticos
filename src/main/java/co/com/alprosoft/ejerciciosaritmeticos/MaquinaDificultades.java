/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.alprosoft.ejerciciosaritmeticos;

import java.util.ArrayList;

/**
 * Una máquina de estados que permite variar la dificultad de los ejercicios a mostrar.
 * @author leand
 */
public class MaquinaDificultades {
    
    // NOTA IMPORTANTE:
    //  Por ahora, se sobreentiende que cada dificultad posterior en la MD es superior a la anterior,
    //    pero esto no está debidamente validado aún.
    //  Si es necesario, hay que explorar la posibilidad de modificar los métodos que calculan
    //    cuál es la dificultad superior, ya sea en su nomenclatura, o en su accionar.
    
    /*
    Versión 0.1 del programa
    private ArrayList<Integer> dificultades; // Estados
    private ArrayList<Double> tiemposRespuestaCorrecta; // Tiempos de respuesta correcta de referencia por nivel de dificultad
    private ArrayList<Integer> numeroIntentosMaximo; // Número de intentos máximo de referencia por nivel de dificultad
    private Integer dificultad; // Estado inicial
    */    
    private ArrayList<Dificultad> dificultades; // Estados posibles de la máquina de dificultades (MD)
    private Dificultad dificultad; // Estado actual de la MD
    // La dificultad inicial es la primera dificultad en el ArrayList llamado dificultades.
    // La dificultad final es la última dificultad en el ArrayList llamado dificultades.
    // La MD llega al estado final cuando se supera la última dificultad en el ArrayList llamado dificultades.
    //  Es decir, cuando se le pide a la MD que aumente su dificultad, pero no es posible, porque ya no hay más dificultades superiores.
    
    // Estados especiales en la máquina de dificultades
    public static final Dificultad ESTADO_INICIO = new Dificultad(Dificultad.DIFICULTAD_MINIMA);
    public static final Dificultad ESTADO_FIN = new Dificultad(Dificultad.DIFICULTAD_MAXIMA);
    
    /*
    Versión 0.1 del programa
    public MaquinaDificultades(ArrayList<Integer> dificultades) throws Exception {
        // Valide que existe por lo menos un nivel de dificultad a ingresar en la MD, y que ningún nivel
        //  de dificultad en el arreglo dificultades tenga un valor null.
        if (this.noExistenDificultadesNulasNiRepetidasParaMD(dificultades)) {
            // Por defecto, asigne el primer nivel de dificultad como la dificultad inicial.            
            this.dificultades = dificultades;
            this.dificultad = this.dificultades.get(0);
        } else {
            throw new Exception("Debe haber por lo menos un nivel de dificultad en la máquina de dificultad (MD)");
        }         
    }
    */
    public MaquinaDificultades(ArrayList<Dificultad> dificultades) throws Exception {
        // Valide que existe por lo menos un nivel de dificultad a ingresar en la MD, que ninguna de las
        //  dificultades a ingresar en la MD sean iguales a alguna de las otras, y que ninguna dificultad
        //  a ingresar en la MD sea inválida.
        // Las dificultades inválidas son las dos dificultades especiales (Ver Dificultad.java).
        if (this.dificultadesInicialesSonValidas(dificultades)) {
            // Agregue los estados especiales que debe tener toda MD a las dificultades a ingresar en la MD,
            //  donde ESTADO_INICIO debe estar de primero, antes de las dificultades a ingresar en la MD, y ESTADO_FIN,
            //  de último, después de las dificultades a ingresar en la MD.
            // this.dificultades = dificultades;
            this.dificultades = new ArrayList<>();
            this.dificultades.add(ESTADO_INICIO);
            for (Dificultad d : dificultades) {
                this.dificultades.add(d);
            }
            this.dificultades.add(ESTADO_FIN);
            // Por defecto, asigne el primer nivel de dificultad como la dificultad inicial.            
            this.dificultad = this.dificultades.get(0); // ESTADO_INICIO
        } else {
            throw new Exception("Debe haber por lo menos un nivel de dificultad en la máquina de dificultad (MD)");
        }
    }
    
    /*
    Versión 0.1 del programa
    public MaquinaDificultades(ArrayList<Integer> dificultades, Integer dificultadInicial) throws Exception {
        // Valide que existe por lo menos un nivel de dificultad a ingresar en la MD, y que ningún nivel
        //  de dificultad en el arreglo dificultades tenga un valor null.
        if (this.noExistenDificultadesNulasNiRepetidasParaMD(dificultades)) {
            // Valide que la dificultad inicial ingresada exista en el listado de dificultades posibles
            if (this.existeDificultadEnMD(dificultadInicial)) {
                this.dificultades = dificultades;
                this.dificultad = dificultadInicial;
            } else {
                throw new Exception("El nivel de dificultad inicial asignado a la máquina de dificultad (MD) no existe en los niveles de dificultad especificados en la MD");
            }
        } else {
            throw new Exception("Debe haber por lo menos un nivel de dificultad en la máquina de dificultad (MD)");
        }
    }
    */
    public MaquinaDificultades(ArrayList<Dificultad> dificultades, Dificultad dificultadInicial) throws Exception {
        // Valide que existe por lo menos un nivel de dificultad a ingresar en la MD, que ninguna de las
        //  dificultades a ingresar en la MD sean iguales a alguna de las otras, y que ninguna dificultad
        //  a ingresar en la MD sea inválida.
        // Las dificultades inválidas son las dos dificultades especiales (Ver Dificultad.java).
        if (this.dificultadesInicialesSonValidas(dificultades)) {
            // Agregue los estados especiales que debe tener toda MD a las dificultades a ingresar en la MD,
            //  donde ESTADO_INICIO debe estar de primero, antes de las dificultades a ingresar en la MD, y ESTADO_FIN,
            //  de último, después de las dificultades a ingresar en la MD.
            // this.dificultades = dificultades;
            this.dificultades = new ArrayList<>();
            this.dificultades.add(ESTADO_INICIO);
            for (Dificultad d : dificultades) {
                this.dificultades.add(d);
            }
            this.dificultades.add(ESTADO_FIN);
            // Valide que la dificultad inicial ingresada exista en el listado de dificultades posibles
            if (this.existeDificultadEnMD(dificultadInicial)) {                
                this.dificultad = dificultadInicial;
            } else {
                throw new Exception("El nivel de dificultad inicial asignado a la máquina de dificultad (MD) no existe en los niveles de dificultad especificados en la MD");
            }
        } else {
            throw new Exception("Debe haber por lo menos un nivel de dificultad en la máquina de dificultad (MD)");
        }
    }
    
    /*
    Versión 0.1 del programa
    public MaquinaDificultades(ArrayList<Integer> dificultades, 
            ArrayList<Double> tiemposRespuestaCorrecta) throws Exception {
        // Valide que existe por lo menos un nivel de dificultad a ingresar en la MD, y que ningún nivel
        //  de dificultad en el arreglo dificultades tenga un valor null.
        if (this.noExistenDificultadesNulasNiRepetidasParaMD(dificultades)) {
            if (this.noExistenTiemposRespuestaCorrectaNulos(tiemposRespuestaCorrecta)) {
                // Por defecto, asigne el primer nivel de dificultad como la dificultad inicial.            
                this.dificultades = dificultades;
                this.dificultad = this.dificultades.get(0);
                this.tiemposRespuestaCorrecta = tiemposRespuestaCorrecta;
            } else {
                throw new Exception("Debe haber por lo menos un tiempo de respuesta correcta por nivel de dificultad en la máquina de dificultad (MD)");
            }            
        } else {
            throw new Exception("Debe haber por lo menos un nivel de dificultad en la máquina de dificultad (MD)");
        }         
    }
    */    
    
    /*
    Versión 0.1 del programa
    public ArrayList<Integer> getDificultades() {
        return dificultades;
    }
    */
    public ArrayList<Dificultad> getDificultades() {
        return this.dificultades;
    }

    /*
    Versión 0.1 del programa
    public Integer getDificultad() {
        return dificultad;
    }
    */
    public Dificultad getDificultad() {
        return this.dificultad;
    }

    /**
    Intenta cambiar la dificultad de los ejercicios:
    * Si esto es posible, se hace esto, y se retorna el valor true;
    * pero si no es posible, porque la dificultad por la cual se quiere cambiar
    * no existe, entonces devuelva false.
     * @param dificultad El nivel de dificultad a asignar (Integer).
     * @return true si esta operación se realiza exitosamente; false si no.
    **/
    /*
    Versión 0.1 del programa
    public boolean setDificultad(Integer dificultad) {
        // Valide que la dificultad a ingresar existe en el listado de dificultades posibles de la máquina de dificultades (MD), 
        //  y obtenga el índice del listado de dificultades de la MD en donde está la dificultad a ingresar.
        int indice = this.obtenerIndiceDificultadEnMD(dificultad);
        if (indice != -1) {
            // Asigne la nueva dificultad a ingresar.
            this.dificultad = this.dificultades.get(indice);
            return true;
        } else {
            return false;
        }        
    }
    */
    
    /**
    Intenta cambiar la dificultad de los ejercicios:
    * Si esto es posible, se hace esto, y se retorna el valor true;
    * pero si no es posible, porque la dificultad por la cual se quiere cambiar
    * no existe, entonces devuelva false.
     * @param dificultad El nivel de dificultad a asignar (Integer).
     * @return true si esta operación se realiza exitosamente; false si no.
    **/
    public boolean setDificultad(Dificultad dificultad) {
        // Valide que la dificultad a ingresar existe en el listado de dificultades posibles de la máquina de dificultades (MD), 
        //  buscando el índice del listado de dificultades de la MD en donde está la dificultad a ingresar.
        int indice = this.obtenerIndiceDificultadEnMD(dificultad);
        if (indice != -1) {
            // Asigne la nueva dificultad a ingresar.
            this.dificultad = this.dificultades.get(indice);
            return true;
        } else {
            return false;
        }        
    }
    
    /*
    Versión 0.1 del programa
    private boolean noExistenDificultadesNulasNiRepetidasParaMD(ArrayList<Integer> dificultades) {
        if (dificultades != null) {
            if (!dificultades.isEmpty()) {
                for (Integer dificultad : dificultades) {
                    if (dificultad == null) {
                        return false;
                    }
                }
                for (int i = 0; i < dificultades.size(); i++) {
                    for (int j = i + 1; j < dificultades.size(); j++) {
                        if (Objects.equals(dificultades.get(i), dificultades.get(j))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    */
    
    /*
    Versión 0.1 del programa
    private boolean noExistenTiemposRespuestaCorrectaNulos(ArrayList<Double> tiemposRespuestaCorrecta) {
        if (tiemposRespuestaCorrecta != null) {
            if (!tiemposRespuestaCorrecta.isEmpty()) {
                for (Double tiempoRespuestaCorrecta : tiemposRespuestaCorrecta) {
                    if (tiempoRespuestaCorrecta == null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    */
    
    /**
    Intenta aumentar la dificultad de los ejercicios:
    * Si esto es posible, se hace esto, y se retorna el valor true;
    * pero si no es posible, porque la dificultad ya está en el máximo, 
    * entonces devuelva false.
     * @return true si esta operación se realiza exitosamente; false si no.
    **/
    /*
    Versión 0.1 del programa
    public boolean aumentarDificultad() {
        // Obtenga el nivel de dificultad actual.
        Integer dificultadActual = this.dificultad;        
        // Obtenga el índice donde está la dificultad actual en la máquina de dificultades (MD).
        int indice = this.obtenerIndiceDificultadEnMD(dificultadActual);
        if (indice + 1 == this.dificultades.size()) {
            // No existe una dificultad superior a la actual.
            return false;
        } else {
            this.dificultad = this.dificultades.get(indice + 1);
            return true;
        }        
    }
    */
    /**
    Intenta aumentar la dificultad de los ejercicios:
    * Si esto es posible, se hace esto, y se retorna el valor true;
    * pero si no es posible, porque la dificultad ya está en el máximo, 
    * entonces devuelva false.
     * @return true si esta operación se realiza exitosamente; false si no.
    **/
    public boolean aumentarDificultad() {
        // Obtenga el nivel de dificultad actual.
        Dificultad dificultadActual = this.dificultad;        
        // Obtenga el índice donde está la dificultad actual en la máquina de dificultades (MD).
        int indice = this.obtenerIndiceDificultadEnMD(dificultadActual);
        if (indice + 1 == this.dificultades.size()) {
            // No existe una dificultad superior a la actual.
            return false;
        } else {
            this.dificultad = this.dificultades.get(indice + 1);
            return true;
        }        
    }
    
    public Dificultad obtenerDificultadSuperior(Dificultad dificultad) {        
        // Obtenga el índice donde está la dificultad actual en la máquina de dificultades (MD).
        int indice = this.obtenerIndiceDificultadEnMD(dificultad);
        if (indice != -1) {
            if (indice + 1 == this.dificultades.size()) {
                // No existe una dificultad superior a la actual.
                return null;
            } else {
                return this.dificultades.get(indice + 1);
            } 
        } else {
            // Esta dificultad no existe en la MD.
            return null;
        }
    }
    
    /**
    Intenta disminuir la dificultad de los ejercicios:
    * Si esto es posible, se hace esto, y se retorna el valor true;
    * pero si no es posible, porque la dificultad ya está en el mínimo, 
    * entonces devuelva false.
     * @return true si esta operación se realiza exitosamente; false si no.
    **/
    /*
    Versión 0.1 del programa
    public boolean disminuirDificultad() {
        // Obtenga el nivel de dificultad actual.
        Integer dificultadActual = this.dificultad;        
        // Obtenga el índice donde está la dificultad actual en la máquina de dificultades (MD).
        int indice = this.obtenerIndiceDificultadEnMD(dificultadActual);
        if (indice - 1 == -1) {
            // No existe una dificultad inferior a la actual.
            return false;
        } else {
            this.dificultad = this.dificultades.get(indice - 1);
            return true;
        } 
    }
    */
    /**
    Intenta disminuir la dificultad de los ejercicios:
    * Si esto es posible, se hace esto, y se retorna el valor true;
    * pero si no es posible, porque la dificultad ya está en el mínimo, 
    * entonces devuelva false.
     * @return true si esta operación se realiza exitosamente; false si no.
    **/
    public boolean disminuirDificultad() {
        // Obtenga el nivel de dificultad actual.
        Dificultad dificultadActual = this.dificultad;        
        // Obtenga el índice donde está la dificultad actual en la máquina de dificultades (MD).
        int indice = this.obtenerIndiceDificultadEnMD(dificultadActual);
        if (indice - 1 == -1) {
            // No existe una dificultad inferior a la actual.
            return false;
        } else {
            this.dificultad = this.dificultades.get(indice - 1);
            return true;
        } 
    }
    
    public Dificultad obtenerDificultadInferior(Dificultad dificultad) {      
        // Obtenga el índice donde está la dificultad actual en la máquina de dificultades (MD).
        int indice = this.obtenerIndiceDificultadEnMD(dificultad);
        if (indice != -1) {
            if (indice - 1 == -1) {
                // No existe una dificultad inferior a la actual.
                return null;
            } else {
                return this.dificultades.get(indice - 1);
            } 
        } else {
            // Esta dificultad no existe en la MD.
            return null;
        }
    }
    
    private boolean dificultadesInicialesSonValidas(ArrayList<Dificultad> dificultades){
        // Debe existir por lo menos una dificultad a ingresar
        if (dificultades != null) {
            if (!dificultades.isEmpty()) {
                // Ninguna de las dificultades a ingresar son niveles de dificultades especiales (Ver Dificultad.java)
                for (Dificultad d : dificultades) {
                    if (d.getNivelDificultad() == Dificultad.DIFICULTAD_MINIMA 
                            || d.getNivelDificultad() == Dificultad.DIFICULTAD_MAXIMA) {
                        return false;
                    }
                }                
                // Ninguna de las dificultades a ingresar son iguales
                for (int i = 0; i < dificultades.size(); i++) {
                    for (int j = i + 1; j < dificultades.size(); j++) {
                        if (dificultades.get(i).getNivelDificultad() == dificultades.get(j).getNivelDificultad()) {
                            // Existen dos niveles de dificultad que son iguales
                            return false;
                        }
                    }
                }
                return true;
            }
        }        
        return false;
    }
    
    /*
    Versión 0.1 del programa
    public final boolean existeDificultadEnMD(Integer dificultad) {
        for (Integer dificultadEnMD : this.dificultades) {
            if (Objects.equals(dificultad, dificultadEnMD)) {
                return true;
            }
        }
        return false;
    }
    */
    public final boolean existeDificultadEnMD(Dificultad dificultad) {
        for (Dificultad dificultadEnMD : this.dificultades) {
            if (dificultad.getNivelDificultad() == dificultadEnMD.getNivelDificultad()) {
                return true;
            }
        }
        return false;
    }
    
    /*
    Versión 0.1 del programa
    public int obtenerIndiceDificultadEnMD(Integer dificultad) {
        for (int i = 0; i < this.dificultades.size(); i++) {
            if (Objects.equals(dificultad, this.dificultades.get(i))) {
                return i;
            }
        }
        return -1;
    }
    */
    public int obtenerIndiceDificultadEnMD(Dificultad dificultad) {
        for (int i = 0; i < this.dificultades.size(); i++) {
            if (dificultad.getNivelDificultad() == this.dificultades.get(i).getNivelDificultad()) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean estaEnEstadoInicio() {
        return this.dificultad == MaquinaDificultades.ESTADO_INICIO;
    }
    
    public boolean estaEnEstadoFin() {
        return this.dificultad == MaquinaDificultades.ESTADO_FIN;
    }
    
}