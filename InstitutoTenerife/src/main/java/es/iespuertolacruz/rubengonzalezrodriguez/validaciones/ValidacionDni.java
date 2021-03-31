package es.iespuertolacruz.rubengonzalezrodriguez.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionDni {

    // Variables de clase

    private String patron = "^[0-9]{8}[A-Z-a-z]$";

    Pattern pattern;
    Matcher matcher;

    // Metodos y funciones
    
    /**
     * Metodo que valida si un Dni es valido y lo devuelve
     * 
     * @param valor que queremos comprobar
     * @return el valor si es váido o un mensaje si no lo es 
     */
    public String validar(String valor) {

        boolean validacion = false;

        this.pattern = Pattern.compile(patron);
        this.matcher = pattern.matcher(valor);
        validacion = matcher.find();

        if (validacion) {
            return valor;
        } else {
            return "El dni es invalido";
        }
    }

}
