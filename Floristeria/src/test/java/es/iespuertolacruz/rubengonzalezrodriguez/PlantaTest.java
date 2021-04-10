package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlantaTest {

    // Variables de clase

    Planta planta1;
    Planta planta2;
    Planta plantaDefecto;

    // BeforeEach y AfterEach

    @BeforeEach
    public void SetUp() {
        planta1 = crearPlanta();
        planta2 = crearPlanta();
        plantaDefecto = new Planta();
    }

    // Test

    @Test
    public void getIdTest() {
        assertSame("P1", planta1.getId(), "La planta1 deberia tener el Id P1, pero no lo tiene");
    }

    @Test
    public void getNombreTest() {
        assertSame("Girasol", planta1.getNombre(), "La planta1 deberia tener el nombre Girasol, pero no lo tiene");
    }

    @Test
    public void getTamanioTest() {
        assertSame(2, planta1.getTamanio(), "La planta1 deberia tener el tamanio 2, pero no lo tiene");
    }

    @Test
    public void getPrecioBaseTest() {
        assertEquals(0.5f, planta1.getPrecioBase(), "La planta1 deberia tener el precioBase 0.5f, pero no lo tiene");
    }

    @Test
    public void getPrecioFinalTest() {
        assertEquals(2.5f, planta1.getPrecioFinal(), "La planta1 deberia tener el precioFinal 2.5f, pero no lo tiene");
    }

    @Test
    public void getArticulosTest() {
        assertSame(25, planta1.getArticulos(), "La planta1 deberia tener 25 articulos, pero no los tiene");
    }

    @Test
    public void setIdTest() {
        plantaDefecto.setId("P10");
        assertSame("P10", plantaDefecto.id, "La planta1 deberia tener el id P10, pero no lo tiene");
    }

    @Test
    public void setNombreTest() {
        plantaDefecto.setNombre("Margarita");
        assertSame("Margarita", plantaDefecto.nombre, "La planta1 deberia tener el nombre Margarita, pero no lo tiene");
    }

    @Test
    public void setTamanioTest() {
        plantaDefecto.setTamanio(1);
        assertSame(1, plantaDefecto.tamanio, "La planta1 deberia tener el tamanio 1, pero no lo tiene");
    }

    @Test
    public void setprecioBaseTest() {
        plantaDefecto.setPrecioBase(0.25f);
        assertEquals(0.25f, plantaDefecto.precioBase, "La planta1 deberia tener el precio base 0.25f, pero no lo tiene");
    }

    @Test
    public void setprecioFinalTest() {
        plantaDefecto.setPrecioFinal(1f);
        assertEquals(1f, plantaDefecto.precioFinal, "La planta1 deberia tener el precio final 1f, pero no lo tiene");
    }

    @Test
    public void setArticulosTest() {
        plantaDefecto.setArticulos(50);
        assertEquals(50, plantaDefecto.articulos, "La planta1 deberia tener 50 articulos, pero no lo tiene");
    }

    @Test
    public void equalsCorrectoTest() {
        assertTrue(planta1.equals(planta2), "El equals no funciona como deberia");
    }

    @Test
    public void equalsIncorrectoTest() {
        assertFalse(planta1.equals(plantaDefecto), "El equals no funciona como deberia");
    }

    @Test
    public void toStringTest() {
        assertTrue(planta1.toString().contentEquals(
                "Id = P1, nombre = Girasol, tamanio = 2, precioBase = 0.5, precioFinal = 2.5, articulos = 25"),
                "El toString no funciona como deberia");
    }

    //Funciones y metodos

    private Planta crearPlanta() {
        return new Planta("P1", "Girasol", 2, 0.5f, 2.5f, 25);
    }

}
