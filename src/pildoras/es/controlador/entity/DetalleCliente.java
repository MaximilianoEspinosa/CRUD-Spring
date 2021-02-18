package pildoras.es.controlador.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalles_clientes")
public class DetalleCliente {
	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="web")
	private String web;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="comentarios")
	private String comentarios;
	
	//Relación con Cliente
	//Para la bireccionalidad, "detalle" es el nombre del campo usado en clase Cliente
	@OneToOne(mappedBy = "detalle", cascade=CascadeType.ALL)
	private Cliente cliente;
	
	//Constructores
	public DetalleCliente() {
	}

	public DetalleCliente(String web, String telefono, String comentarios) {
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
