package es.iespuertolacruz.rubengonzalezrodriguez;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.AlumnosModelo;

public class AlumnosModeloTest {
    
    //Variables de clase

    AlumnosModelo alumnos;
    Alumno alumno;

    @BeforeEach
    public void SetUp(){
        if(alumnos == null) {
            alumnos = new AlumnosModelo();
        }
        alumno = crearAlumno();
        try {
            alumnos.insertar(alumno);
        } catch (AlumnoException e) {
            fail("No se deberia llegar hasta aqui");
        }
    }
    
    @AfterEach
    public void After() {
        try {
            alumnos.eliminar(alumno.getDni());
        } catch (AlumnoException e) {
            fail("No se deberia llegar hasta aqui");
        }
    }

    @Test
    public void existeAlumnoTest() {
        assertTrue(alumnos.existe(alumno),"El alumno deberia existir en la lista y no existe");
    }

    @Test
    public void mostrarListaTest() {
        assertTrue(alumnos.mostrarLista().contains("43378653D"),"La lista deberia devolver la lista con la palabra 43378653D y no la devuelve");
    }

    private Alumno crearAlumno() {
        return alumno = new Alumno("43378653D", "Ruben", "Gonzalez", "Rodriguez", null);
    }
}
