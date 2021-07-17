package unsch.edu.pe.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiales")
public class Materiales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmateriales;
	private String nombre;
	private Double ancho;
	private Double largo;
	private String imagen;

	public int getIdmateriales() {
		return idmateriales;
	}

	public void setIdmateriales(int idmateriales) {
		this.idmateriales = idmateriales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
