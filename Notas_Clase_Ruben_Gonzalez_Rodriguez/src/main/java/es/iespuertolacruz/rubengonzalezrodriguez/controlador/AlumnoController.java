package es.iespuertolacruz.rubengonzalezrodriguez.controlador;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.AlumnoModelo;

public class AlumnoController {

    // Variables de clase

    AlumnoModelo alumnoModelo;

    /**
     * Constructor por defecto con alumnoModelo inicializado
     */
    public AlumnoController() {
        alumnoModelo = new AlumnoModelo();
    }

    /**
     * Metodo que valida si un alumno es valido o no
     * 
     * @param alumno a validar
     * @throws AlumnoException excepcion propia
     */
    public void validarAlumno(Alumno alumno) throws AlumnoException {
        String mensaje = "";

        if (alumno == null) {
            mensaje = "Se esta validando un objeto nulo de alumno";
            throw new AlumnoException(mensaje);
        }

        if (alumno.getDni() == null || alumno.getDni().isEmpty()) {
            mensaje += "El dni del alumno es nulo o vacio, ";
        }

        if (alumno.getNombre() == null || alumno.getNombre().isEmpty()) {
            mensaje += "el nombre del alumno es nulo o vacio, ";
        }

        if (alumno.getApellido1() == null || alumno.getApellido1().isEmpty()) {
            mensaje += "el primer apellido del alumno es nulo o vacio, ";
        }

        if (alumno.getApellido2() == null || alumno.getApellido2().isEmpty()) {
            mensaje += "el segundo apellido del alumno es nulo o vacio.";
        }

        if (!mensaje.isEmpty()) {
            throw new AlumnoException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar una 
     * 
     * @param fruta a insertar
     * @throws FrutaException con mensaje controlado
     */
    public void insertar(Fruta fruta) throws FrutaException {
        validarFruta(fruta);
        if (existe(fruta)) {
            throw new FrutaException("La fruta indicada ya existe");
        }
        frutaModelo.insertar(fruta);
    }

    /**
     * Metodo encargado de eliminar
     * 
     * @param fruta a eliminar
     * @throws FrutaException
     */
    public void eliminar(Fruta fruta) throws FrutaException {
        validarFruta(fruta);
        if (!existe(fruta)) {
            throw new FrutaException("La fruta indicada NO existe");
        }
        frutaModelo.eliminar(fruta);
    }

    public void eliminar(String identificador) throws FrutaException {
        Fruta fruta;
        fruta = buscar(identificador);
        if (fruta == null) {
            throw new FrutaException("La fruta indicada NO existe");
        }
        frutaModelo.eliminar(fruta);
    }

    /**
     * Metodo encargado de buscar por identificador
     * 
     * @param identificador para localizar la fruta
     * @return fruta a traves del identificador
     */
    public Fruta buscar(String identificador) {
        Fruta fruta = null;
        fruta = frutaModelo.buscar(identificador);
        return fruta;
    }

    public void modificar(Fruta fruta) {
        // lo que sea
    }

    /**
     * Funcion encargada de verificar si existe la fruta
     * 
     * @param fruta a encontrar
     * @return true/false
     */
    private boolean existe(Fruta fruta) {
        boolean encontrada = false;
        Fruta frutaEncontrada;

        frutaEncontrada = buscar(fruta.getIdentificador());
        if (frutaEncontrada != null) {
            encontrada = true;
        }

        return encontrada;
    }

}
