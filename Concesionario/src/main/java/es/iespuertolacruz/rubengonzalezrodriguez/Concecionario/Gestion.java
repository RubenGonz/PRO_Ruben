package es.iespuertolacruz.rubengonzalezrodriguez.concecionario;

import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Cliente;
import es.iespuertolacruz.rubengonzalezrodriguez.elementos.Coche;
import java.util.ArrayList;

/**
 *
 * @author rubengonzalezrodriguez
 */
public class Gestion {

    ArrayList<Coche> coches;
    ArrayList<Cliente> clientes;

    //Constructores
    
    public Gestion() {
        if (coches == null) {
            coches = new ArrayList<>();
        }
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
    }

    public Gestion(ArrayList<Coche> coches, ArrayList<Cliente> clientes) {
        this.coches = coches;
        this.clientes = clientes;
    }

    // Getters
    
    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    // Metodos

    /**
     * Metodo para insertar un coche en la lista
     *
     * @param coche elemento a insertar
     */
    public void insertarCoche(Coche coche) {
        coches.add(coche);
    }
    
    /**
     * Metodo para insertar un cliente en la lista
     * 
     * @param cliente elemento a insertar
     */
    public void insertarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Funcion que busca un elemento en la lista
     *
     * @param matricula Clave por la que busca el coche
     * @return retorna el coche/null
     */
    public Coche buscarCoche(String matricula) {
        boolean encontrar = false;
        int i = 0;
        Coche cocheEncontrado = null;
        while (i < coches.size() || !encontrar) {
            Coche coche = coches.get(i);
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                encontrar = true;
                cocheEncontrado = coche;
            }
            i++;
        }
        return cocheEncontrado;
    }
    
    /**
     * Funcion que busca un elemento en la lista
     *
     * @param dni Dni por el que busca al cliente
     * @return retorna el cliente/null
     */
    public Cliente buscarCliente(String dni) {
        boolean encontrar = false;
        int i = 0;
        Cliente clienteEncontrado = null;
        while (i < clientes.size() || !encontrar) {
            Cliente cliente = clientes.get(i);
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                encontrar = true;
                clienteEncontrado = cliente;
            }
            i++;
        }
        return clienteEncontrado;
    }
    
    /**
     * Metodo que elimina un elemento de la lista si existe
     *
     * @param coche El coche que queramos eliminar
     */
    public void eliminarCoche(Coche coche) {
        coches.remove(coche);
    }
    
    /**
     * Metodo que elimina un elemento de la lista si existe
     *
     * @param cliente El cliente que queramos eliminar
     */
    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

}
