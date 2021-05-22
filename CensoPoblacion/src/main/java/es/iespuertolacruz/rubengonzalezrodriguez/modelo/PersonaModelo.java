package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Persona;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.PersistenciaException;

public class PersonaModelo {

    // Variables de clase

    DdBbSqLite persistencia;

    private static final String TABLA = "PERSONA";
    private static final String CLAVE = "DNI";

    // Constructores

    public PersonaModelo() throws PersistenciaException {
        persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
    }

    // Metodos y funciones

    public void insertar(Persona persona) throws PersistenciaException {
        String sql = "INSERT INTO " + TABLA + " VALUES ('" + persona.getDni() + "','" + persona.getNombre() + "','"
                + persona.getFechaNacimiento() + "','" + persona.getDireccion() + "'," + persona.getTelefono() + ");";
        persistencia.update(sql);
    }

    public void eliminar(Persona persona) throws PersistenciaException {
        String sql = "DELETE FROM " + TABLA + " WHERE " + CLAVE + " = '" + persona.getDni() + "';";
        persistencia.update(sql);
    }

    public Persona buscar(String dni) throws PersistenciaException {
        return (Persona) persistencia.buscarElemento(dni);
    }

    public void modificar(Persona persona) throws PersistenciaException {
        String sql = "UPDATE " + TABLA + " SET NOMBRE = '" + persona.getNombre() + "', FECNAC = '"
                + persona.getFechaNacimiento() + "', DIR = '" + persona.getDireccion() + "', TFNO = "
                + persona.getTelefono() + " WHERE " + CLAVE + " = '" + persona.getDni() + "';";
        persistencia.update(sql);
    }

}
