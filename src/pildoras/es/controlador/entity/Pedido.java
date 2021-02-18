package pildoras.es.controlador.entity;

import java.util.GregorianCalendar;
import javax.persistence.*;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", updatable=false)
	private int id;
	
	@Column(name="fecha")
	private GregorianCalendar fecha;
	
	@Column(name="forma_pago")
	private String formaPago;
	
	//Todas las cascadas permitidas menos la de REMOVE, para que no se elimine cliente cuando se elimine un pedido
	//ManyToOne indica que muchos objetos de esta clase, pertenecen a un objeto de otra clase
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Pedido() {}
	
	public Pedido(GregorianCalendar gregorianCalendar) {
		this.fecha = gregorianCalendar;
		this.formaPago = "Sin indicar";
	}
	
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", formaPago=" + formaPago + "]";
	}
}