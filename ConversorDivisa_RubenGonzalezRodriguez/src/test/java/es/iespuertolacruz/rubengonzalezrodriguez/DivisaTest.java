package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;

public class DivisaTest {

    // Variables de clase

    Divisa divisa1;
    Divisa divisa2;

    @BeforeEach
    public void SetUp() {
        divisa1 = crearDivisa();
        divisa2 = new Divisa("EUR", 1f);
    }

    @Test
    public void toStringTest() {
        assertEquals("Codigo = EUR, valor = 1.0", divisa1.toString(), "El contenido del to String no es el esperado");
    }

    @Test
    public void equalsTest() {
        assertTrue(divisa1.equals(divisa2), "Los objetos son iguales, pero el metodo dice lo contrario");
    }

    private Divisa crearDivisa() {
        Divisa divisa;
        divisa = new Divisa();
        divisa.setCodigo("EUR");
        divisa.setValor(1f);
        return divisa;
    }
}
