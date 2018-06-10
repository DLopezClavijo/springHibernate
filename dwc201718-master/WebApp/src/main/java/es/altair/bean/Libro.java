package es.altair.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="libros") 
public class Libro implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibro;
	private String titulo;
	private String autor;
	private int isbn;
	private byte[] portada;
	private String uuid;

	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, String autor, int isbn, byte[] portada, String uuid, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.portada = portada;
		this.uuid = uuid;
		this.usuario = usuario;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public byte[] getPortada() {
		return portada;
	}

	public void setPortada(byte[] portada) {
		this.portada = portada;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", portada="
				+ Arrays.toString(portada) + ", uuid=" + uuid + ", usuario=" + usuario + "]";
	}

}
