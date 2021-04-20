package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.AlumnosModelo;

public class AlumnosModeloTest {
    
    //Variables de clase

    AlumnosModelo alumnosModelo;
    Alumno alumno;

    @BeforeEach
    public void SetUp(){
        if(alumnosModelo == null) {
            alumnosModelo = new AlumnosModelo();
        }
        alumno = crearAlumno();
        alumnosModelo.insertar(alumno);
    }
    
    @AfterEach
    public void After() {
        alumnosModelo.eliminar(alumno);
    }

    @Test
    public void existeNotaTest() {
        assertTrue(alumnosModelo.existe(alumno),"El alumno deberia existir en la lista y no existe");
    }

    @Test
    public void mostrarListaTest() {
        assertTrue(alumnosModelo.mostrarLista().contains("43378653D"),"La lista deberia devolver la lista con la palabra 43378653D y no la devuelve");
    }

    private Alumno crearAlumno() {
        return alumno = new Alumno("43378653D", "Ruben", "Gonzalez", "Rodriguez");
    }
}
