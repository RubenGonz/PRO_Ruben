package es.iespuertolacruz.rubengonzalezrodriguez;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.VehiculoModelo;

public class VehiculoModeloTest {
    
    //Variables de clase

    VehiculoModelo vehiculoModelo;
    Vehiculo vehiculo;

    //BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        vehiculoModelo = new VehiculoModelo();
        vehiculo = crearVehiculo();
    }

    @AfterEach
    public void after() {

    }

    //Test

    @Test
    public void validarVehiculoNuloTest() {

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
