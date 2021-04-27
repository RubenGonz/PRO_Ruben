package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.exception.DivisaException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.DivisaModelo;

public class DivisaModeloTest {
    
    // Variables de clase

    DivisaModelo divisaModelo;
    Divisa divisa;
    Divisa divisa2;

    @BeforeEach
    public void SetUp() {
        if (divisaModelo == null) {
            divisaModelo = new DivisaModelo();
        }
        divisa = crearDivisa();
        divisa2 = new Divisa("USD", 1.21f);
        insertarDivisaTest();
        try {
            divisaModelo.insertar(divisa2);
        } catch (DivisaException excepcion){
            fail("No se deberia llegar hasta aqui");
        }
    }

    @AfterEach
    public void after() {
        eliminarDivisaTest();
    }

    @Test
    public void insertarDivisaTest() {
        try {
            divisaModelo.insertar(divisa);
        } catch (DivisaException excepcion){
            assertTrue(excepcion.getMessage().contains("La divisa que intenta insertar en la lista ya esta insertada"), "Deberia contener un mensaje de error y no lo contiene");
        }
    }

    @Test
    public void existeTest() {
        assertTrue(divisaModelo.existe(divisa), "La divisa deberia existir y no existe");
    }

    @Test
    public void eliminarDivisaTest() {
        try {
            divisaModelo.eliminar(divisa2);
        } catch (DivisaException excepcion){
            assertTrue(excepcion.getMessage().contains("La divisa que intenta eliminar de la lista no esta insertada"), "Deberia contener un mensaje de error y no lo contiene");
        }
    }

    @Test
    public void obtenerTest() {
        try {
            assertEquals(divisaModelo.obtener("EUR"),divisa,"No devuelve la divisa esperada");
        } catch (DivisaException e) {
            fail("El test no deberia llegar hasta aqui");
        }
    }

    @Test
    public void obtenerErroneoTest() {
        try {
            divisaModelo.obtener("YEN");
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("La divisa que se quiere obtener no existe"),"La divisa no deberia existir y existe");
        }
    }

    @Test
    public void convertirTest() {
        try {
            assertEquals(24.2f, divisaModelo.convertir("EUR", "USD", 20), "El resultado obtenido no es el esperado");
        } catch (DivisaException e) {
            fail("El test no deberia llegar hasta aqui");
        }
    }

    @Test
    public void convertirOrigenErroneoTest() {
        try {
            divisaModelo.convertir("YEN", "USD", 20);
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("No se le pudo dar valor a a la variable"),"Deberia devolver el mensaje de error especificado y no lo devuelve");
        }
    }

    @Test
    public void convertirDestinoErroneoTest() {
        try {
            divisaModelo.convertir("EUR", "YEN", 20);
        } catch (DivisaException excepcion) {
            assertTrue(excepcion.getMessage().contains("No se le pudo dar valor a a la variable"),"Deberia devolver el mensaje de error especificado y no lo devuelve");
        }
    }

    @Test
    public void toStringTest() {
        assertEquals("ListaDivisas = {EUR=Codigo = EUR, valor = 1.0, USD=Codigo = USD, valor = 1.21}", divisaModelo.toString(), "El toString no funciona como deberia");
    }

    private Divisa crearDivisa() {
        Divisa divisa;
        divisa = new Divisa();
        divisa.setCodigo("EUR");
        divisa.setValor(1f);
        return divisa;
    }
}
