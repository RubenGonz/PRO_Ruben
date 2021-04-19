package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Nota;

public class NotaTest {
    
    // Variables de clase

    Nota nota1;
    Nota nota2;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        nota1 = crearNota1();
        nota2 = crearNota2();
    }

    // Test

    @Test
    public void equalsTest() {
        assertTrue(nota1.equals(nota2), "El equals no funciona como deberia");
    }

    @Test
    public void toStringTest() {
        assertEquals("Asignatura = Programacion, calificacion = 8",
                nota1.toString(), "El toString no funciona como deberia");
    }

    // Funciones y metodos

    private Nota crearNota1() {
        Nota nota = new Nota();
        nota.setAsignatura("Programacion");
        nota.setCalificacion(8);
        return nota;
    }

    private Nota crearNota2() {
        return new Nota("Programacion", 8);
    }
}
