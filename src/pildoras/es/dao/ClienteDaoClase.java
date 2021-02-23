package pildoras.es.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.controlador.entity.Pedido;

@Repository
public class ClienteDaoClase implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {

		//Obtener la session		
		Session sesion = sessionFactory.getCurrentSession();	
		
		//Crear la consulta (Query)
		Query<Cliente> mi_query = sesion.createQuery("from Cliente", Cliente.class);
		
		//Ejecutar query y retornar resultados
		List<Cliente> clientes = mi_query.getResultList();
		
		return clientes;
	}

	@Override
	@Transactional
	public void registrarCliente(Cliente cliente) {
		
		//Obtener la session		
		Session sesion = sessionFactory.getCurrentSession();
		
		//Registra el cliente o modifica el cliente si ya existe
		//sesion.save(cliente);
		sesion.saveOrUpdate(cliente);
		
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {

		//Obtener la sesión
		Session sesion = sessionFactory.getCurrentSession();
		
		//Obtener la info del clienteCl
		Cliente cliente = sesion.get(Cliente.class, id);
		
		return cliente;
	}
	
	@Override
	@Transactional
	public void eliminarCliente(Cliente cliente) {
		//Obtener la sesión
		Session sesion = sessionFactory.getCurrentSession();
		
		//eliminar la info del cliente
		sesion.delete(cliente);
	}	

	@Override
	@Transactional
	public void guardarPedido(Pedido pedido) {
		
		//Obtener la session
		Session sesion = sessionFactory.getCurrentSession();
		
		pedido.setFecha(new Date());
		
		sesion.saveOrUpdate(pedido);
		
	}
}
