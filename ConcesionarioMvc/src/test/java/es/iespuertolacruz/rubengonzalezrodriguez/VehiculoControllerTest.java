package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;
import es.iespuertolacruz.rubengonzalezrodriguez.controller.VehiculoController;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.FicheroException;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.VehiculoException;

public class VehiculoControllerTest {
    
    //Variables de clase

    VehiculoController vehiculoController;
    Vehiculo vehiculo;

    //BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        vehiculoController = new VehiculoController();
        vehiculo = crearVehiculo();
    }

    @AfterEach
    public void after() {

    }

    //Test

    @Test
    public void validarTest() {
        try {
            vehiculoController.validar(vehiculo);
        } catch (VehiculoException e) {
            fail("El test no deberia llegar hasta aqui");
        }
    }

    @Test
    public void validarVehiculoNuloTest() {
        Vehiculo vehiculoNulo = null;
        try {
            vehiculoController.validar(vehiculoNulo);
        } catch (VehiculoException exception) {
            assertTrue(exception.getMessage().contains("El vehiculo es nulo"), "La excepcion no devuelve el mensaje esperado");
        }
    }

    @Test
    public void validarVehiculoVacioTest() {
        Vehiculo vehiculoVacio;
        vehiculoVacio = new Vehiculo("","");
        try {
            vehiculoController.validar(vehiculoVacio);
        } catch (VehiculoException exception) {
            assertTrue(exception.getMessage().contains("La matricla del vehiculo es nula o vacia, La marca del vehiculo es nula o vacia."), "La excepcion no devuelve el mensaje esperado");
        }
    }

    //Metodos y funciones privadas

    private Vehiculo crearVehiculo() {
        Vehiculo vehiculo;
        vehiculo = new Vehiculo();
        vehiculo.setMatricula("5992 HLJ");
        vehiculo.setMarca("Opel");
        return vehiculo;
    }
}
