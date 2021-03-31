package es.iespuertolacruz.rubengonzalezrodriguez.test;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Aula;
import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Nota;
import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Profesor;

public class InstitutoTenerifeTest {

    // Variable de clase

    Profesor profesor;
    Aula aula;
    Alumno alumno;
    Nota nota;
    ArrayList<Aula> listaAulas;
    ArrayList<Alumno> listaAlumnos;
    ArrayList<Nota> listaNotas;

    // Before each y After each

    @BeforeEach
    public void setUp() {
        profesor = crearProfesor();
        aula = crearAula();
        alumno = crearAlumno();
        nota = crearNota();

        profesor.setAulas(listaAulas);
        if (listaAulas ==  null) {
            listaAulas = new ArrayList<>();
            profesor.insertar(aula);
        }
        aula.setAlumnos(listaAlumnos);
        if (listaAlumnos ==  null) {
            listaAlumnos = new ArrayList<>();
            aula.insertar(alumno);
        }
        alumno.setNotas(listaNotas);
        if (listaNotas ==  null) {
            listaNotas = new ArrayList<>();
            alumno.insertar(nota);
        }
    }

    @AfterEach
    public void after() {
        profesor.eliminar(aula);
        aula.eliminar(alumno);
        alumno.eliminar(nota);
    }

    // Tests

    @Test
    public void AulaExisteTest() {
        assertTrue(profesor.existe(aula), "El aula no existe en la lista de aulas");
    }
    
    @Test
    public void AlumnoExisteTest() {
        assertTrue(aula.existe(alumno), "El alumno no existe en la lista de alumnos");
    }
    
    @Test
    public void NotaExisteTest() {
        assertTrue(alumno.existe(nota), "La nota no existe en la lista de notas");
    }

    @Test
    public void DniValidoTest() {
        alumno.setDni("12345678A");
        assertTrue(alumno.getDni() == "12345678A", "El dni deberia ser valido y no lo es");
    }

    @Test
    public void DniInvalidoTest() {
        alumno.setDni("jk12yg");
        assertTrue(alumno.getDni() == "jk12yg", "El dni no deberia ser valido y lo es");
    }

    // Metodos y funciones privadas para los test

    /**
     * Funcion encargada de generar un profesor para los test
     * 
     * @return objeto de tipo profesor
     */
    private Profesor crearProfesor() {
        return new Profesor("12345678A", "Juan", "Hernandez Perez", listaAulas);
    }

    /**
     * Funcion encargada de generar un alumno para los test
     * 
     * @return objeto de tipo alumno
     */
    private Alumno crearAlumno() {
        return new Alumno("23456789B", "Antonio", "Rodriguez Gonzalez", listaNotas);
    }

    /**
     * Funcion encargada de generar un aula para los test
     * 
     * @return objeto de tipo aula
     */
    private Aula crearAula() {
        return new Aula(1, 1, listaAlumnos);
    }

    /**
     * Funcion encargada de generar una nota para los test
     * 
     * @return objeto de tipo nota
     */
    private Nota crearNota() {
        return new Nota("Programacion", 10);
    }

}