package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.controller.DivisaController;
import es.iespuertolacruz.rubengonzalezrodriguez.exception.DivisaException;

public class DivisaControllerTest {// Variables de clase

    DivisaController divisaController;
    Divisa divisa;

    @BeforeEach
    public void SetUp() {
        divisaController = new DivisaController();
        divisa = crearDivisa();
        insertarTest();
    }

    @AfterEach
    public void after() {
        eliminarTest();
    }

    @Test
    public void validarTest() {
        try {
            divisaController.validarDivisa(divisa);
        } catch (DivisaException exception) {
            assertEquals(null, exception.getMessage(), "No se deberia lanzar mensaje de error y lo manda");
        }
    }

    @Test
    public void validarNuloTest() {
        Divisa divisaNula = null;
        try {
            divisaController.validarDivisa(divisaNula);
        } catch (DivisaException exception) {
            assertTrue(exception.getMessage().contains("Se esta intentando validar una divisa que es nula o vacia"), "No se esta lanzando el mensaje esperado");
        }
    }

    @Test
    public void validarParametrosVaciosTest() {
        divisa.setCodigo("");
        divisa.setValor(-10f);
        try {
            divisaController.validarDivisa(divisa);
        } catch (DivisaException exception) {
            assertTrue(exception.getMessage().contains("Se esta intentando validar una divisa con codigo nulo o vacio"), "No se esta lanzando el mensaje esperado");
        }
    }

    @Test
    public void insertarTest() {
        try {
            divisaController.insertar(divisa);
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("La divisa indicada ya existe"), "Se deberia recibir el mensaje especificado y no lo recibe");
        }
    }

    @Test
    public void eliminarTest() {
        try {
            divisaController.eliminar(divisa);
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("La divisa indicada no existe"), "Se deberia recibir el mensaje especificado y no lo recibe");
        }
    }

    @Test
    public void obtenerTest() {
        try {
            assertEquals(divisa,divisaController.obtener("EUR"), "No devuelve la divisa esperada");
        } catch (DivisaException e) {
            fail("No se deberia llegar hasta aqui");
        }
    }

    @Test
    public void obtenerErroneoTest() {
        try {
            divisaController.obtener("YEN");
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("No se ha podido obtener la divisa"),"Se deberia recibir el mensaje especificado y no lo recibe");
        }
    }

    @Test
    public void convertirTest() {
        Divisa divisa2;
        divisa2 = new Divisa("USD", 1.21f);
        try {
            divisaController.insertar(divisa2);
        } catch (DivisaException e1) {
            fail("No se deberia llegar hasta aqui");
        }
        try {
            assertEquals(24.2f, divisaController.convertir("EUR", "USD", 20), "El metodo no devuelve el valor esperado");
        } catch (DivisaException e) {
            fail("No se deberia llegar hasta aqui");
        }
    }

    @Test
    public void convertirErroneoTest() {
        try {
            divisaController.convertir("EUR", "USD", 20);
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("No se ha podido convertir la divisa"));
        }
    }

    @Test
    public void toStringTest() {
        assertEquals("ListaDivisas = {EUR=Codigo = EUR, valor = 1.0}", divisaController.toString(),"Se deberia recibir el mensaje especificado y no lo recibe");
    }

    private Divisa crearDivisa() {
        Divisa divisa;
        divisa = new Divisa();
        divisa.setCodigo("EUR");
        divisa.setValor(1f);
        return divisa;
    }
}
