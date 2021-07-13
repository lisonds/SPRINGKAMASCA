package unsch.edu.pe.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trabajo")
public class Trabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtrabajos;
	private String categoria;
	private String medida;
	private double precio;
	private String foto;

	@OneToOne
	@JoinColumn(name = "diseniador_id")
	private Diseniador diseniador;

	public int getIdtrabajos() {
		return idtrabajos;
	}

	public void setIdtrabajos(int idtrabajos) {
		this.idtrabajos = idtrabajos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Diseniador getDiseniador() {
		return diseniador;
	}

	public void setDiseniador(Diseniador diseniador) {
		this.diseniador = diseniador;
	}

}
