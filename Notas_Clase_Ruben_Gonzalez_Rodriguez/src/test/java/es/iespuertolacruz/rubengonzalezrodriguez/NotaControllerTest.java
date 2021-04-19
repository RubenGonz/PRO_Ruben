package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Nota;
import es.iespuertolacruz.rubengonzalezrodriguez.controlador.NotaController;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.NotaException;

public class NotaControllerTest {

    // Variables de clase

    NotaController notaController;
    Nota notaNula;
    Nota nota;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        notaController = new NotaController();
        nota = new Nota();
    }

    // Test

    @Test
    public void validarNotaValidaTest() {
        nota.setAsignatura("Programacion");
        nota.setCalificacion(8);
        try {
            notaController.validarNota(nota);
        } catch (NotaException e) {
            assertTrue(e.getMessage().contains("Se esta validando un objeto nulo de nota"),
                    "Deberia lanzar un mensaje de error y no lo lanza");
        }
    }

    @Test
    public void validarNotaNulaTest() {
        try {
            notaController.validarNota(notaNula);
        } catch (NotaException e) {
            assertTrue(e.getMessage().contains("Se esta validando un objeto nulo de nota"),
                    "Deberia lanzar un mensaje de error y no lo lanza");
        }
    }

    @Test
    public void validarAlumnoNoNuloTest() {
        try {
            notaController.validarNota(nota);
        } catch (NotaException e) {
            assertTrue(e.getMessage().contains(
                    "La asignatura de la nota es nula o vacia, la calificacion es 0 o menor."),
                    "Deberia lanzar un mensaje de error y no lo lanza");
        }
    }

}
