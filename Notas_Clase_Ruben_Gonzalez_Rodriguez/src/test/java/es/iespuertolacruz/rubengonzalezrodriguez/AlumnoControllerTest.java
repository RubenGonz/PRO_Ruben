package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.controlador.AlumnoController;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;

public class AlumnoControllerTest {

    // Variables de clase

    AlumnoController alumnoController;
    Alumno alumnoNulo;
    Alumno alumno;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        alumnoController = new AlumnoController();
        alumno = new Alumno();
    }

    // Test

    @Test
    public void validarAlumnoValidoTest() {
        alumno.setDni("43378653D");
        alumno.setNombre("Ruben");
        alumno.setApellido1("Gonzalez");
        alumno.setApellido2("Rodriguez");
        try {
            alumnoController.validarAlumno(alumno);
        } catch (AlumnoException e) {
            fail("No se deberia llegar hasta aqui");
        } 
    }

    @Test
    public void validarAlumnoNuloTest() {
        try {
            alumnoController.validarAlumno(alumnoNulo);
        } catch (AlumnoException e) {
            assertTrue(e.getMessage().contains("Se esta validando un objeto nulo de alumno"),
                    "Deberia lanzar un mensaje de error y no lo lanza");
        }
    }

    @Test
    public void validarAlumnoNoNuloTest() {
        try {
            alumnoController.validarAlumno(alumno);
        } catch (AlumnoException e) {
            assertTrue(e.getMessage().contains(
                    "El dni del alumno es nulo o vacio, el nombre del alumno es nulo o vacio, el primer apellido del alumno es nulo o vacio, el segundo apellido del alumno es nulo o vacio."),
                    "Deberia lanzar un mensaje de error y no lo lanza");
        }
    }

}
