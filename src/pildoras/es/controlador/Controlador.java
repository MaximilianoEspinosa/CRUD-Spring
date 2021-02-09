package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	//Para acciones CRUD sobre los clientes en base de datos
	@Autowired
	private ClienteDAO clienteDAO;

	@RequestMapping("/lista")
	public String lista_clientes(Model modelo) {
		
		//Obtener los clientes desde el DAO
		List<Cliente> clientes = clienteDAO.getClientes();
		
		//Añadir los clientes al modelo
		modelo.addAttribute("clientes", clientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/formulario_registro")
	public String muestroFormularioRegistro(Model modelo) {
		
		//Bind datos de cliente
		
		Cliente nuevo_cliente = new Cliente();
		
		modelo.addAttribute("nuevo_cliente", nuevo_cliente);
		
		return "formulario-cliente";
	}
	
	@PostMapping("/registrar_cliente")
	public String registrarCliente(@ModelAttribute("nuevo_cliente") Cliente cliente) {
		
		//Registrar cliente desde form en BBDD
		clienteDAO.registrarCliente(cliente);
		
		return "redirect:/cliente/lista";
	}
}