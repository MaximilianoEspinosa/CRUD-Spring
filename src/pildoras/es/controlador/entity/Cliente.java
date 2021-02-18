package pildoras.es.controlador.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos; 
	
	@Column(name="email")
	private String email;
	
	//Posee un único objeto de detalle
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private DetalleCliente detalle;
	
	//Posee múltiples pedidos
	//Indica que tiene muchos de una clase y "cliente" indica el atributo que usa la clase Pedido
	//FetchType.EAGER indica que cargará información inmediatamente a menos que en un futuro se solicite
	//En relaciones uno a varios o varios a varios, es LAZY por defecto
	@OneToMany(mappedBy = "cliente", 
				cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
				fetch = FetchType.EAGER
	)
	private List<Pedido> pedidos;
	
	//Constructor
	public Cliente() {}

	//Getters and setters
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DetalleCliente getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleCliente detalle) {
		this.detalle = detalle;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void agregarPedido(Pedido pedido) {
		
		if(pedidos == null) {
			pedidos = new ArrayList<>();
		}
		
		pedidos.add(pedido);
	}
}