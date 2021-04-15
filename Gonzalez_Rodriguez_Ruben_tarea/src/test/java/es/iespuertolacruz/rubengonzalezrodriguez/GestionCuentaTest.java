package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionCuentaTest {

    // Variables de clase

    GestionCuenta gestionCuenta1;
    GestionCuenta gestionCuenta2;
    Cuenta cuenta;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        cuenta = crearCuenta();
        gestionCuenta1 = crearGestionCuenta1(cuenta);
        gestionCuenta2 = crearGestionCuenta2(cuenta);
    }

    //Test

    @Test
    public void getGestionCuenta() {
        assertEquals(gestionCuenta1.cuenta, gestionCuenta2.getCuenta(),"El get de gestionCuenta falla");
    }

    @Test
    public void ingresarTest() {
        try {
            gestionCuenta1.ingresar(25);
        } catch (CuentaException e) {
            fail("Hubo un error al ingresar");
        }
        assertEquals(2525f,gestionCuenta1.cuenta.getSaldo(),"Hubo un error al ingresar");
    }

    @Test
    public void ingresarError1Test() {
        try {
            gestionCuenta1.ingresar(-25);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("negativas")); 
        }
    }

    @Test
    public void retirarTest() {
        try {
            gestionCuenta1.retirar(25);
        } catch (CuentaException e) {
            fail("Hubo un error al retirar");
        }
        assertEquals(2475f,gestionCuenta1.cuenta.getSaldo(),"Hubo un error al retirar");
    }

    @Test
    public void retirarError1Test() {
        try {
            gestionCuenta1.retirar(-25);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("negativas"));
        }
    }

    @Test
    public void retirarError2Test() {
        try {
            gestionCuenta1.retirar(5000);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("suficiente"));
        }
    }

    //Funciones y metodos

    private Cuenta crearCuenta() {
        return new Cuenta("Antonio López","1000-2365-85-1230456789",2500f,0f);
    }

    private GestionCuenta crearGestionCuenta1(Cuenta cuenta) {
        GestionCuenta gestionCuenta = new GestionCuenta();
        gestionCuenta.setCuenta(crearCuenta());
        return gestionCuenta;
    }

    private GestionCuenta crearGestionCuenta2(Cuenta cuenta) {
        GestionCuenta gestionCuenta = new GestionCuenta(cuenta);
        return gestionCuenta;
    }
    
}
