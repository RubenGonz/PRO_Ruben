package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

/**
 *
 * @author rubengonzalezrodriguez
 */
public class Direccion {
    
    String calle;
    int numero;
    String codPostal;
    String provincia;
    
    // Contructores

    public Direccion() {
    }

    public Direccion(String calle, int numero, String codPostal, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.codPostal = codPostal;
        this.provincia = provincia;
    }
    
    // Getters y Setters

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
