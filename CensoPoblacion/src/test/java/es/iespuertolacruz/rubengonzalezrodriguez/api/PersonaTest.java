package es.iespuertolacruz.rubengonzalezrodriguez.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class PersonaTest {
    
    // Variables de la clase

    Persona persona1;
    Persona persona2;
    Persona persona3;

    //BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        persona1 = crearPersona();
        persona2 = new Persona("43378653D","Ruben","31/05/2000","Calle la calle",650341025);
        persona3 = new Persona("43378653D'Ruben'31/05/2000'Calle la calle'650341025");
    }

    //Test

    @Test
    public void toStringTest() {
        assertEquals("43378653D'Ruben'31/05/2000'Calle la calle'650341025",persona1.toString(), "El texto recibido no era el esperado");
    }

    @Test
    public void EqualsTest() {
        assertEquals(persona2,persona3,"Los objetos son iguales y equals no lo reconoce");
    }

    //Funciones y metodos

    private Persona crearPersona() {
        Persona persona;
        persona = new Persona();
        persona.setDni("43378653D");
        persona.setNombre("Ruben");
        persona.setFechaNacimiento("31/05/2000");
        persona.setDireccion("Calle la calle");
        persona.setTelefono(650341025);
        return persona;
    }
}
