package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;

public class AlumnoTest {
    
    // Variables de clase

    Alumno alumno1;
    Alumno alumno2;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        alumno1 = crearAlumno1();
        alumno2 = crearAlumno2();
    }

    // Test

    @Test
    public void equalsTest() {
        assertTrue(alumno1.equals(alumno2), "El equals no funciona como deberia");
    }

    @Test
    public void toStringTest() {
        assertEquals("Dni = 43378653D, nombre = Ruben, apellido1 = Gonzalez, apellido2 = Rodriguez",
                alumno1.toString(), "El toString no funciona como deberia");
    }

    // Funciones y metodos

    private Alumno crearAlumno1() {
        Alumno alumno = new Alumno();
        alumno.setDni("43378653D");
        alumno.setNombre("Ruben");
        alumno.setApellido1("Gonzalez");
        alumno.setApellido2("Rodriguez");
        return alumno;
    }

    private Alumno crearAlumno2() {
        return new Alumno("43378653D", "Ruben", "Gonzalez", "Rodriguez");
    }
}
