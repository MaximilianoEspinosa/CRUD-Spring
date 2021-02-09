package pildoras.es.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.Cliente;

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
		
		//Registra el cliente
		sesion.save(cliente);
		
	}
}
