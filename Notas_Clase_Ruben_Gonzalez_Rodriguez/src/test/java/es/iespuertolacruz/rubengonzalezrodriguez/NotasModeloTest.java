package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Nota;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.NotasModelo;

public class NotasModeloTest {
    
    //Variables de clase

    NotasModelo notasModelo;
    Nota nota;

    @BeforeEach
    public void SetUp(){
        if(notasModelo == null) {
            notasModelo = new NotasModelo();
        }
        nota = crearNota();
        notasModelo.insertar(nota);
    }
    
    @AfterEach
    public void After() {
        notasModelo.eliminar(nota);
    }

    @Test
    public void existeNotaTest() {
        assertTrue(notasModelo.existe(nota),"La nota deberia existir en la lista y no existe");
    }

    @Test
    public void mostrarListaTest() {
        assertTrue(notasModelo.mostrarLista().contains("Programacion"),"La lista deberia devolver la lista con la palabra programacion y no la devuelve");
    }

    private Nota crearNota() {
        return nota = new Nota("Programacion", 8);
    }
}
