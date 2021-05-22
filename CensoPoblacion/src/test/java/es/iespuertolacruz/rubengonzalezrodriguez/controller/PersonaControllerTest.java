package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Persona;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.CensoException;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.PersistenciaException;

public class PersonaControllerTest {

    // Variables de clase

    static PersonaController personaController;
    Persona persona = null;

    // Before y after

    @BeforeAll
    public static void beforeAll() {
        if (personaController == null) {
            try {
                personaController = new PersonaController();
            } catch (PersistenciaException e) {
                fail("Se ha producido un error iniciando personaController");
            }
        }
    }

    @BeforeEach
    public void crearPersona() {
        insertarPersonaTest();
    }

    @AfterEach
    public void eliminarPersona() {
        if (persona != null) {
            eliminarPersonaTest();
        }
    }

    // Test

    @Test
    public void insertarPersonaTest() {
        persona = new Persona("43378653D", "Ruben", "31/05/2000", "Calle la calle", 650341025);
        try {
            personaController.insertar(persona);
        } catch (CensoException | PersistenciaException e) {
            assertTrue(e.getMessage().contains("La persona indicada ya existe"), "No se recibio el mensaje esperado");
        }
    }

    @Test
    public void validarTest() {
        Persona personaInvalida = new Persona("", "", "", "", 0);
        try {
            personaController.validarPersona(personaInvalida);
        } catch (CensoException e) {
            assertTrue(e.getMessage().contains(
                    "El dni de la persona es nulo o vacio, el nombre de la persona es nulo o vacio, la fecha de nacimiento de la persona es nula o vacia, la direccion de la persona es nula o vacia, el telefono de la persona es 0 o menor."),
                    "No se recibio el mensaje esperado");
        }
    }

    @Test
    public void validarNuloTest() {
        Persona personaInvalida = null;
        try {
            personaController.validarPersona(personaInvalida);
        } catch (CensoException e) {
            assertTrue(e.getMessage().contains("Se esta validando un objeto nulo"),
                    "No se recibio el mensaje esperado");
        }
    }

    @Test
    public void eliminarPersonaTest() {
        try {
            personaController.eliminar(persona);
        } catch (CensoException | PersistenciaException e) {
            assertTrue(e.getMessage().contains("La persona indicada no existe"), "No se recibio el mensaje esperado");
        }
    }

    @Test
    public void eliminarPorDniTest() {
        try {
            personaController.eliminar("43378653D");
        } catch (CensoException | PersistenciaException e) {
            assertTrue(e.getMessage().contains("La persona indicada no existe"), "No se recibio el mensaje esperado");
        }
    }

    @Test
    public void buscarPersonaTest() {
        try {
            Persona personaEncontrada = personaController.buscar(persona.getDni());
            assertNotNull(personaEncontrada, "No se debe de obtener un elemento nulo");
            assertEquals(persona, personaEncontrada, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
            fail("Se ha producido un error en la consulta de la persona ,e:" + e.getMessage());
        }
    }

    @Test
    public void modificarPersonaExistenteTest() {
        try {
            personaController.modificar(persona);
        } catch (CensoException | PersistenciaException e) {
            assertEquals(null,e.getMessage(), "No deberia llgar ningun mensaje de error y llega");
        }
    }

    @Test
    public void modificarPersonaInexistenteTest() {
        Persona personaInexistente = new Persona("12345678A", "Jose", "05/06/2001", "Calle la avenida", 654987321);
        try {
            personaController.modificar(personaInexistente);
        } catch (CensoException | PersistenciaException e) {
            assertEquals("La persona indicada no existe",e.getMessage(), "El mensaje recibido no es el esperado");
        }
    }

}
