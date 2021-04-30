package es.iespuertolacruz.rubengonzalezrodriguez;

import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;


public class VehiculoTest {
    
    //Variables de clase

    Vehiculo vehiculo1;
    Vehiculo vehiculo2;
    
    //BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        vehiculo1 = crearVehiculo();
        vehiculo2 = new Vehiculo("5992 HLJ", "Opel");
    }

    //Test

    @Test
    public void equalsTest() {
        assertTrue(vehiculo1.equals(vehiculo2), "Los objetos son iguales pero el metodo dice que son distintos");
    }

    @Test
    public void toStringTest() {
        assertEquals("Matricula = 5992 HLJ, marca = Opel", vehiculo1.toString(), "El mensaje recibido no es el esperado");
    }

    //Metodos y funciones de clase

    private Vehiculo crearVehiculo() {
        Vehiculo vehiculo;
        vehiculo = new Vehiculo();
        vehiculo.setMatricula("5992 HLJ");
        vehiculo.setMarca("Opel");
        return vehiculo;
    }

}
