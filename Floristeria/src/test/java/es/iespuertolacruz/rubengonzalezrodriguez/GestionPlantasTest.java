package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionPlantasTest {

    // Variables de clase

    GestionPlantas plantas;
    Planta planta1;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        if (plantas == null) {
            plantas = new GestionPlantas();
        }
        planta1 = crearPlanta();
        try {
            plantas.insertar("Id01", planta1);
        } catch (PlantaException e) {
            fail("Se ha producido un error insertardo la planta1");
        }
    }

    @AfterEach void after() {
        try {
            plantas.eliminar("Id01");
        } catch (PlantaException e) {
            fail("Se ha producido un error eliminando la planta1");
        }
    }

    // Test

    @Test
    public void existeTest() {
        assertTrue(plantas.existe("Id01"), "La planta1 deberia existir pero no existe");
    }

    @Test
    public void buscarEncontradoTest() {
        assertSame(planta1,plantas.buscar("Id01"), "La planta deberia haberse encontrado");
    }

    @Test
    public void buscarNoEncontradoTest() {
        assertSame(null,plantas.buscar("Id02"), "No deberia encontrarse pero la encontró");
    }

    @Test
    public void mostrarPlantaTest() {
        assertTrue(plantas.mostarPlanta("Id01").contentEquals(
            "Id = P1, nombre = Girasol, tamanio = 2, precioBase = 0.5, precioFinal = 2.5, articulos = 25"),
            "El metodo no funciona como deberia");
    }
 
    @Test
    public void obtenerCantidadIncorrectaTest() {
        assertSame(0, plantas.obtenerCantidad("Id02"), "Debería tener valor 0 pero no lo tiene");
    }

    @Test
    public void obtenerCantidadCorrectaTest() {
        assertSame(25, plantas.obtenerCantidad("Id01"), "Debería tener valor 25 pero no lo tiene");
    }

    //Funciones y metodos

    private Planta crearPlanta() {
        return new Planta("P1", "Girasol", 2, 0.5f, 2.5f, 25);
    }
}
