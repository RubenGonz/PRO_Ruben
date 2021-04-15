package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {

    // Variables de clase

    Cuenta cuenta1;
    Cuenta cuenta2;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        cuenta1 = crearCuenta1();
        cuenta2 = crearCuenta2();
    }

    // Test

    @Test
    public void equalsTest() {
        assertTrue(cuenta1.equals(cuenta2), "El equals no funciona como deberia");
    }

    @Test
    public void toStringTest() {
        assertEquals("Nombre = Antonio Lopez, numero = 1000-2365-85-1230456789, saldo = 2500.0, tipoInteres = 0.0",
                cuenta1.toString(), "El toString no funciona como deberia");
    }

    // Funciones y metodos

    private Cuenta crearCuenta2() {
        return new Cuenta("Antonio Lopez", "1000-2365-85-1230456789", 2500f, 0f);
    }

    private Cuenta crearCuenta1() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("Antonio Lopez");
        cuenta.setNumero("1000-2365-85-1230456789");
        cuenta.setSaldo(2500f);
        cuenta.setTipoInteres(0f);
        return cuenta;
    }

}
