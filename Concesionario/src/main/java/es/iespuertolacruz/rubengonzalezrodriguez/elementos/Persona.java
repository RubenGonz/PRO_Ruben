package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

/**
 *
 * @author rubengonzalezrodriguez
 */
public class Persona {

    String mombre;
    String apellidos;
    String dni;
    int edad;
    
    
    //Constructores
    
    public Persona() {
    }

    public Persona(String mombre, String apellidos, String dni, int edad) {
        this.mombre = mombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }
    
    // Getters y Setters

    public String getMombre() {
        return mombre;
    }

    public void setMombre(String mombre) {
        this.mombre = mombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
