package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombre;
	private String password;
	private String email;

	// asociación 1:N desde la tabla usuarios a la tabla usuariosgrupos
	@OneToMany(mappedBy = "usuario")
	private Set<UsuarioGrupo> usuariosgrupos = new HashSet<UsuarioGrupo>();

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String password, String email) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UsuarioGrupo> getUsuariosgrupos() {
		return usuariosgrupos;
	}

	public void setUsuariosgrupos(Set<UsuarioGrupo> usuariosgrupos) {
		this.usuariosgrupos = usuariosgrupos;
	}

}
