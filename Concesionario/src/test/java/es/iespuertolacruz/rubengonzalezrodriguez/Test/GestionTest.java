package es.iespuertolacruz.rubengonzalezrodriguez.Test;

import es.iespuertolacruz.rubengonzalezrodriguez.concecionario.Gestion;
import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Cliente;
import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Coche;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rubengonzalezrodriguez
 */
public class GestionTest {
    
    Gestion gestion;
    Coche coche;
    Cliente cliente;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (gestion == null) {
            gestion = new Gestion();
        }
        coche = generarCoche();
        gestion.insertarCoche(coche);

        cliente = generarCliente();
        gestion.insertarCliente(cliente);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test quue prueba la insercion de un coche
     */
    @Test
    public void insertarCocheTest() {
        assertTrue(gestion.getCoches().size() == 1, "El tamanio de la lista es "
                + "incorrecto se esperaba 1");
    }
    
    /**
     * Test quue prueba la insercion de un cliente
     */
    @Test
    public void insertarClienteTest() {
        assertTrue(gestion.getClientes().size() == 1, "El tamanio de la lista es "
                + "incorrecto se esperaba 1");
    }
    
    /**
     * Test que prueba la busqueda de un coche en el ArrayList
     */
    @Test
    public void buscarCocheTest() {
        Coche cocheEncontrado = gestion.buscarCoche("11111A");
        
        assertEquals(coche.getMatricula(), cocheEncontrado.getMatricula(), 
                "El coche encontrado no coincide");
         assertEquals(coche, cocheEncontrado, 
                "El coche encontrado no coincide");
    }
    
    /**
     * Test que prueba la busqueda de un coche en el ArrayList
     */
    @Test
    public void buscarClienteTest() {
        Cliente clienteEncontrado = gestion.buscarCliente("12345678A");
        
        assertEquals(cliente.getDni(), clienteEncontrado.getDni(), 
                "El cliente encontrado no coincide");
         assertEquals(cliente, clienteEncontrado, 
                "El cliente encontrado no coincide");
    }
    
    // Metodos
    
    /**
     * Metodo que crea un nuevo coche
     * @return Un coche nuevo
     */
    private Coche generarCoche() {
       Coche coche = null;
       
       coche = new Coche("Opel", "Corsa", "11111A");
       return coche;
    }
    
    /**
     * Metodo que crea un nuevo cliente
     * @return Un cliente nuevo
     */
    private Cliente generarCliente() {
       Cliente cliente = null;
       
       cliente = new Cliente("Ruben", "Gonzalez", "12345678A", 20);
       return cliente;
    }
}
