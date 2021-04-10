package es.iespuertolacruz.rubengonzalezrodriguez;

import java.util.Objects;

public class Planta {
    
    //Variables de clase

    String id;
    String nombre;
    int tamanio;
    float precioBase;
    float precioFinal;
    int articulos;

    //Constructores

    /**
     * Constructor por defecto de la clase Planta
     */
    public Planta() {
    }

    /**
     * Constructor por parametros de la clase Planta
     * 
     * @param id Referencia del producto dentro del sistema
     * @param nombre Nombre de la planta dentro del sistema
     * @param tamanio Tamanio aproximado que ocupa en el almacen
     * @param precioBase Precio al que le suministran la planta desde el distribuidor
     * @param precioFinal Precio final de la planta en tienda
     * @param articulos Numero de artículos en tienda
     */
    public Planta(String id, String nombre, int tamanio, float precioBase, float precioFinal, int articulos) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.precioBase = precioBase;
        this.precioFinal = precioFinal;
        this.articulos = articulos;
    }

    //Getter and Setter

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public float getPrecioBase() {
        return this.precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public float getPrecioFinal() {
        return this.precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getArticulos() {
        return this.articulos;
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }

    //Metodos y funciones
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Planta)) {
            return false;
        }
        Planta planta = (Planta) o;
        return Objects.equals(id, planta.id) && Objects.equals(nombre, planta.nombre) && tamanio == planta.tamanio && precioBase == planta.precioBase && precioFinal == planta.precioFinal && articulos == planta.articulos;
    }

    @Override
    public String toString() {
        return "Id = " + getId() +
            ", nombre = " + getNombre() +
            ", tamanio = " + getTamanio() +
            ", precioBase = " + getPrecioBase() +
            ", precioFinal = " + getPrecioFinal() +
            ", articulos = " + getArticulos();
    }

}

