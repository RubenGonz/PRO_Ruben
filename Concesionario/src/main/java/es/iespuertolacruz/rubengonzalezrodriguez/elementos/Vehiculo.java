package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

/**
 *
 * @author rubengonzalezrodriguez
 */
public class Vehiculo {
    
    String marca;
    String modelo;
    String matricula;
    
    // Constructores

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
    
    // Getters y Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
