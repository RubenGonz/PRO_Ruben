package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionLinkedListTest {

    Fruta fruta;

    @BeforeEach
    public void setUp() {
        fruta = crearFruta();
    }

    @Test
    public void constructorConParametrosFrutaTest(){
        assertSame("Rojo", fruta.color, "Deberia construirse una fruta de color Rojo y no lo es");
    }

    @Test
    public void constructorSinParametrosFrutaTest(){
        Fruta frutaDefecto = new Fruta();
        assertNull(frutaDefecto.color, "La fruta deberia ser null y lo es");
    }

    @Test
    public void setColorFrutaTest(){
        fruta.setColor("Azul");
        assertSame("Azul", fruta.color, "La fruta deberia ser de color azul y no lo es");
    }

    @Test
    public void getColorFrutaTest(){
        assertSame("Rojo", fruta.getColor(), "La fruta deberia ser roja y no lo es");
    }

    @Test
    public void setPesoFrutaTest(){
        fruta.setPeso(20);
        assertEquals(20, fruta.peso, "La fruta deberia pesar 20 y no lo pesa");
    }

    @Test
    public void getPesoFrutaTest(){
        assertSame(5, fruta.getPeso(), "La fruta deberia pesar 5 y no lo pesa");
    }

    private Fruta crearFruta() {
        fruta = new Fruta("Rojo", 5);
        return fruta;
    }
}
