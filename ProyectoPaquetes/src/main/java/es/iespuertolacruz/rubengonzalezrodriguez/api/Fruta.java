package es.iespuertolacruz.rubengonzalezrodriguez.api;

/**
 * Clase fruta de la aplicacion
 */
public class Fruta {
    
    //Declaracion de variables de clase

    String identificador;
    String nombre;
    float precio;
    float coste;

    //Constructores

    /**
     * Constructor por defecto
     */
    public Fruta() {
    }

    /**
     * Consrtructor con las propiedades de la fruta
     * @param identificador de la fruta
     * @param nombre de la fruta
     * @param precio de la fruta
     * @param coste de la frutra
     */
    public Fruta(String identificador, String nombre, float precio, float coste) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.precio = precio;
        this.coste = coste;
    }

    //Getter and Setter


    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCoste() {
        return this.coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    //Metodos y funciones

    /**
     * Funcion que calcula cual es el benefecio de una fruta
     * @return float del beneficio de la fruta
     */
    public float beneficio() {
        return precio - coste;
    }
    
}
