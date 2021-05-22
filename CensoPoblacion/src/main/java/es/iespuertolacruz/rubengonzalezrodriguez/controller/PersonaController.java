package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Persona;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.CensoException;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.PersistenciaException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.PersonaModelo;

public class PersonaController {

    // Variables de clase

    PersonaModelo personaModelo;

    // Constructores

    public PersonaController() throws PersistenciaException {
        personaModelo = new PersonaModelo();
    }

    // Funcioens y metodos

    /**
     * Metodo encargado de realizar la validacion del objeto persona
     * 
     * @param persona a validar
     * @throws PersonaException con el mensaje descriptivo de lo que sucede
     */
    public void validarPersona(Persona persona) throws CensoException {
        String mensaje = "";

        if (persona == null) {
            mensaje = "Se esta validando un objeto nulo";
            throw new CensoException(mensaje);
        }

        if (persona.getDni() == null || persona.getDni().isEmpty()) {
            mensaje = "El dni de la persona es nulo o vacio, ";
        }

        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            mensaje += "el nombre de la persona es nulo o vacio, ";
        }

        if (persona.getFechaNacimiento() == null || persona.getFechaNacimiento().isEmpty()) {
            mensaje += "la fecha de nacimiento de la persona es nula o vacia, ";
        }

        if (persona.getDireccion() == null || persona.getDireccion().isEmpty()) {
            mensaje += "la direccion de la persona es nula o vacia, ";
        }

        if (persona.getTelefono() <= 0) {
            mensaje += "el telefono de la persona es 0 o menor.";
        }
        
        if (!mensaje.isEmpty()) {
            throw new CensoException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * 
     * @param persona a insertar
     * @throws CensoException        con mensaje controlado
     * @throws PersistenciaException con mensaje controlado
     */
    public void insertar(Persona persona) throws CensoException, PersistenciaException {
        validarPersona(persona);
        if (existe(persona)) {
            throw new CensoException("La persona indicada ya existe");
        }
        personaModelo.insertar(persona);
    }

    /**
     * Metodo encargado de eliminar
     * 
     * @param persona a eliminar
     * @throws CensoException        con mensaje controlado
     * @throws PersistenciaException con mensaje controlado
     */
    public void eliminar(Persona persona) throws CensoException, PersistenciaException {
        validarPersona(persona);
        if (!existe(persona)) {
            throw new CensoException("La persona indicada no existe");
        }
        personaModelo.eliminar(persona);
    }

    /**
     * Meotod encargado de realiza la eliminacion
     * 
     * @param dni del elemento a eliminar
     * @throws CensoException        con mensaje controlado
     * @throws PersistenciaException con mensaje controlado
     */
    public void eliminar(String dni) throws CensoException, PersistenciaException {
        Persona persona;
        persona = buscar(dni);
        eliminar(persona);
    }

    /**
     * Metodo encargado de buscar por el dni
     * 
     * @param dni para localizar la persona
     * @return persona a traves del dni
     * @throws PersistenciaException con mensaje controlado
     */
    public Persona buscar(String dni) throws PersistenciaException {
        Persona persona = null;
        persona = personaModelo.buscar(dni);
        return persona;
    }

    /**
     * Metodo encargado de realizar la modificacion de una persona
     * 
     * @param persona a modficar
     * @throws CensoException        con mensaje controlado
     * @throws PersistenciaException con mensaje controlado
     */
    public void modificar(Persona persona) throws CensoException, PersistenciaException {

        validarPersona(persona);
        if (!existe(persona)) {
            throw new CensoException("La persona indicada no existe");
        }
        personaModelo.modificar(persona);
    }

    /**
     * Funcion encargada de verificar si existe la persona
     * 
     * @param persona a encontrar
     * @return true si existe o false si no existe
     * @throws PersistenciaException con mensaje controlado
     */
    private boolean existe(Persona persona) throws PersistenciaException {
        boolean encontrada = false;
        Persona personaEncontrada;

        personaEncontrada = buscar(persona.getDni());
        if (personaEncontrada != null) {
            encontrada = true;
        }
        return encontrada;
    }

}