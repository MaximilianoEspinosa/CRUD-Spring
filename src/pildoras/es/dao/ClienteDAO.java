package pildoras.es.dao;

import java.util.List;
import pildoras.es.controlador.entity.Cliente;
import pildoras.es.controlador.entity.Pedido;

public interface ClienteDAO {

	public List<Cliente> getClientes();

	public void registrarCliente(Cliente cliente);

	public Cliente getCliente(int id);
	
	public void eliminarCliente(Cliente cliente);

	public void agregarPedido(Pedido pedido);
	
}
